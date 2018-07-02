package fr.eni.clinique.DAL.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.*;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.PersonnelDAO;

public class GestionPersonnelDAOJdbcImpl implements PersonnelDAO {

    private static final String SELECT_BY_ID = "SELECT * FROM Personnels WHERE CodePers=?";


    private static final String SELECT_ALL = "SELECT * FROM Personnels WHERE Archive=0";

    private static final String INSERT = "INSERT INTO Personnels (Nom, Prenom, MotPasse, "
            + "Role, Archive) VALUES (?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE Personnels SET Nom=?, Prenom=?, MotPasse=?, Role=?, "
            + "Archive=? WHERE CodePers=?";
//A FAIRE @Patrick
//    private static final String DELETE = "DELETE FROM Personnels WHERE CodePers=?";

    @Override
    public Personnel selectById(int id) throws DALException {
        Connection cnx;
        ResultSet rs;
        Personnel personnel = null;

        try {
            cnx = JDBCTools.getConnection();
            PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);
            rqt.setInt(1, id);
            rs = rqt.executeQuery();
            if (rs.next()) {
                personnel = this.personnelBuilder(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectById");
        }

        return personnel;
    }


    @Override
    public List<Personnel> selectAll() throws DALException {
        Connection cnx = null;
        Statement rqt = null;
        ResultSet rs = null;

        List<Personnel> listeEmployes = new ArrayList<>();

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                listeEmployes.add(this.creationPersonnel(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur récupération liste complète du personnel");
        }

        return listeEmployes;
    }

    @Override
    public void insert(Personnel employe) throws DALException {
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rsId = null;

        if (employe == null) {
            throw new NullPointerException();
        }

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparerParametres(employe, rqt);

            rqt.executeUpdate();

            rsId = rqt.getGeneratedKeys();

            if (rsId.next()) {
                employe.setCodePersonnel(rsId.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur lors de l'insertion d'un nouvel employé");
        }

    }


    @Override
    public void update(Personnel employe) throws DALException {
        PreparedStatement rqt = null;
        Connection cnx = null;
        if (employe == null) {
            throw new NullPointerException();
        }
        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(UPDATE);
            preparerParametres(employe, rqt);
            rqt.setInt(6, employe.getCodePersonnel());
            rqt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur lors de la mise à jour d'une fiche employé");
        }


    }

    @Override
    public void delete(Personnel obj) throws DALException {

    }

    public Personnel creationPersonnel(ResultSet rs) throws SQLException {
        Personnel personne = null;
        String role = rs.getString("Role");

        switch (role) {
            case "adm":
                personne = new Admin();
                break;
            case "vet":
                personne = new Veterinaire();
                break;
            default:
                personne = new Secretaire();
                break;
        }

        personne.setCodePersonnel(rs.getInt("CodePers"));
        personne.setNom(rs.getString("Nom"));
        personne.setPrenom(rs.getString("Prenom"));
        personne.setMotPasse(rs.getString("MotPasse"));
        personne.setRole(role);
        if (rs.getInt("Archive") == 0) {
            personne.setArchive(false);
        } else {
            personne.setArchive(true);
        }

        return personne;
    }


    private void preparerParametres(Personnel employe, PreparedStatement rqt) throws SQLException {

        rqt.setString(1, employe.getNom());
        rqt.setString(2, employe.getPrenom());
        rqt.setString(3, employe.getMotPasse());
        rqt.setString(4, employe.getRole());

        if (employe.isArchive())
            rqt.setByte(5, (byte) 1);

        if (!employe.isArchive())
            rqt.setByte(5, (byte) 0);

    }

    @Override
    public Personnel personnelBuilder(ResultSet rs) throws SQLException {
        Personnel personne = null;
        String role = rs.getString("Role");
        switch (role) {
            case "adm":
                personne = new Admin();
                break;
            case "vet":
                personne = new Veterinaire();
                break;
            case "sec":
                personne = new Secretaire();
                break;
            default:
                personne = null;
                break;
        }
        personne.setCodePersonnel(rs.getInt("CodePers"));
        personne.setNom(rs.getString("Nom"));
        personne.setMotPasse(rs.getString("MotPasse"));
        personne.setRole(role);
        if (rs.getInt("Archive") == 0) {
            personne.setArchive(false);
        } else {
            personne.setArchive(true);
        }
        return personne;
    }
}