package fr.eni.clinique.DAL.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Animal;
import fr.eni.clinique.DAL.AnimalDAO;
import fr.eni.clinique.DAL.DALException;


public class AnimalDAOJdbcImpl implements AnimalDAO {

    private static final String SELECT_BY_ID = "SELECT A.CodeAnimal, A.NomAnimal, A.Sexe, A.Couleur, "
            + "A.Race, A.Espece, A.Tatouage,A.Antecedents, A.Archive, A.CodeClient, "
            + "C.NomClient, C.PrenomClient "
            + "FROM Animaux as A JOIN Clients as C ON C.CodeClient = A.CodeClient "
            + "WHERE A.CodeAnimal=? and A.Archive=0;";

    private static final String SELECT_ANIMAUX_BY_CLIENT = "SELECT CodeAnimal, A.NomAnimal, A.Sexe, A.Couleur, "
            + "A.Race, A.Espece, A.Tatouage, A.Antecedents, A.Archive,A.CodeClient "
            + " C.NomClient, C.PrenomClient, "
            + "FROM Clients as C JOIN Animaux as A ON C.CodeClient = A.CodeClient "
            + "WHERE A.CodeClient=? AND A.Archive=0";

    private static final String SELECT_ALL = "SELECT * FROM Animaux WHERE Archive=0";

    private static final String INSERT_ANIMAL = "INSERT INTO Animaux(NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, "
            + "Tatouage, Antecedents, Archive) " + "VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE_ANIMAL = "UPDATE Animaux SET NomAnimal=?, Sexe=?, Couleur=?, Race=?, Espece=?, CodeClient=?, "
            + "Tatouage=?, Antecedents=?, Archive =? "
            + " WHERE CodeAnimal=?";


    private static final String DELETE_ANIMAL = "UPDATE ANIMAUX SET Archive = 1 where CodeAnimal = ?";

    @Override
    public Animal selectById(int id) throws DALException {
        Connection cnx;
        ResultSet rs;
        Animal animal = null;

        try {
            cnx = JDBCTools.getConnection();
            PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);
            rqt.setInt(1, id);
            rs = rqt.executeQuery();
            if (rs.next()) {
                animal = this.animalBuilder(rs);
                animal.setCodeAnimal(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectById");
        }

        return animal;


    }

    @Override
    public List<Animal> selectAnimauxByClient(int codeClient) throws DALException {

        Connection cnx;
        Statement rqt;
        ResultSet rs;

        List<Animal> listeAnimaux = new ArrayList<>();

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SELECT_ANIMAUX_BY_CLIENT);
            while (rs.next()) {
                listeAnimaux.add(this.animalBuilder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectAnimauxByClient");
        }

        return listeAnimaux;

    }

    @Override
    public List<Animal> selectAll() throws DALException {
        Connection cnx = null;
        Statement rqt = null;
        ResultSet rs = null;

        List<Animal> listeAnimaux = new ArrayList<>();

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                listeAnimaux.add(this.animalBuilder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur récupération liste complète des animaux");
        }

        return listeAnimaux;
    }

    @Override
    public void insert(Animal animal) throws DALException {
        Connection cnx;
        PreparedStatement rqt;
        ResultSet rsId;
        if (animal == null) {
            throw new NullPointerException();
        }
        try {

            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(INSERT_ANIMAL, Statement.RETURN_GENERATED_KEYS);
            preparerParametres(animal, rqt);
            rqt.executeUpdate();
            rsId = rqt.getGeneratedKeys();

            if (rsId.next()) {
                animal.setCodeAnimal(rsId.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("insert_animal");
        }

    }

    @Override
    public void update(Animal animal) throws DALException {
        PreparedStatement rqt;
        Connection cnx;
        if (animal == null) {
            throw new NullPointerException();
        }
        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(UPDATE_ANIMAL);
            preparerParametres(animal, rqt);
            rqt.setInt(10, animal.getCodeAnimal());
            rqt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("update_animal");
        }

    }

    @Override
    public void delete(Animal animal) throws DALException {
        PreparedStatement rqt;
        Connection cnx;
        if (animal == null) {
            throw new NullPointerException();
        }
        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(DELETE_ANIMAL);
            rqt.setInt(1, animal.getCodeAnimal());
            rqt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Suppression impossible");
        }
    }

    public Animal animalBuilder(ResultSet rs) throws SQLException {

        Animal animal = new Animal();

        if (rs != null) {
            animal.setCodeAnimal(rs.getInt("CodeAnimal"));
            animal.setNomAnimal(rs.getString("NomAnimal"));
            animal.setSexe(rs.getString("Sexe"));
            animal.setCouleur(rs.getString("Couleur"));
            animal.setRace(rs.getString("Race"));
            animal.setEspece(rs.getString("Espece"));
            animal.setCodeClient(rs.getInt("CodeClient"));
            animal.setTatouage(rs.getString("Tatouage"));
            animal.setAntecedents(rs.getString("Antecedents"));
            if (rs.getInt("Archive") == 0) {
                animal.setArchive(false);
            } else {
                animal.setArchive(true);
            }

        }
        return animal;
    }

    private void preparerParametres(Animal animal, PreparedStatement rqt) throws SQLException {
        rqt.setString(1, animal.getNomAnimal());
        rqt.setString(2, animal.getSexe());
        rqt.setString(3, animal.getCouleur());
        rqt.setString(4, animal.getRace());
        rqt.setString(5, animal.getEspece());
        rqt.setInt(6, animal.getCodeClient());
        rqt.setString(7, animal.getTatouage());
        rqt.setString(8, animal.getAntecedents());

        if (animal.isArchive())
            rqt.setByte(9, (byte) 1);

        if (!animal.isArchive())
            rqt.setByte(9, (byte) 0);

    }

}
