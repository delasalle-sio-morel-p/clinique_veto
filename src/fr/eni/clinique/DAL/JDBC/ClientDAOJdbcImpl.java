package fr.eni.clinique.DAL.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Animal;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.DAL.AnimalDAO;
import fr.eni.clinique.DAL.ClientDAO;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;


public class ClientDAOJdbcImpl implements ClientDAO {

    public static final String SELECT_BY_ID = "SELECT  C.CodeClient, C.NomClient, C.PrenomClient, C.Adresse1, C.Adresse2, C.CodePostal, C.Ville,"
            + " C.NumTel, C.Assurance, C.Email, C.Remarque, C.Archive, "
            + "A.CodeAnimal, A.NomAnimal, A.Sexe, A.Couleur, A.Race, A.Espece, A.Tatouage, " + "A.Antecedents, A.Archive "
            + "FROM Animaux as A JOIN Clients as C ON A.CodeClient=C.CodeClient "
            + "WHERE C.CodeClient=? and A.Archive=0";

    public static final String SELECT_ALL = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, "
            + "Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive  FROM Clients WHERE Archive=0";

    public static final String SELECT_BY_MOT_CLE = SELECT_ALL + " AND NomCLient LIKE ?";

    public static final String INSERT = "INSERT INTO CLIENTS (NomClient, PrenomClient, Adresse1, "
            + "Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    public static final String UPDATE = " UPDATE CLIENTS SET NomClient=?, PrenomClient=?, Adresse1=?, Adresse2=?, CodePostal=?, Ville=?, "
            + "NumTel=?, Assurance=?, Email=?, Remarque=?, Archive=? WHERE CodeClient=?";

    public static final String DELETE = "UPDATE CLIENTS SET Archive = 1 where CodeClient = ?";

    @Override
    public Client selectById(int id) throws DALException {
        Connection cnx;
        ResultSet rs;
        Client client = null;

        try{
            cnx = JDBCTools.getConnection();
            PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);
            rqt.setInt(1, id);
            rs = rqt.executeQuery();
            if (rs.next()) {
                client = this.clientBuilder(rs, true);
                client.setCodeClient(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectById");
        }

        return client;
    }

    @Override
    public List<Client> selectAll() throws DALException {
        List<Client> listeClients = new ArrayList<>();

        try (Connection cnx = JDBCTools.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                listeClients.add(this.clientBuilder(rs, false));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectAll");
        }

        return listeClients;
    }

    @Override
    public void insert(Client client) throws DALException {
        if (client == null) {
            throw new NullPointerException();
        }
        try (Connection cnx = JDBCTools.getConnection()) {

            PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparerParametres(client, pstmt);
            pstmt.executeUpdate();
            ResultSet rsId = pstmt.getGeneratedKeys();
            if (rsId.next()) {
                client.setCodeClient(rsId.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("insertion client");
        }

    }

    @Override
    public void update(Client client) throws DALException {
        if (client == null) {
            throw new NullPointerException();
        }
        try (Connection cnx = JDBCTools.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
            preparerParametres(client, pstmt);
            pstmt.setInt(12, client.getCodeClient());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("update_client");
        }

    }

    @Override
    public void delete(Client client) throws DALException {
        if (client == null) {
            throw new NullPointerException();
        }
        try (Connection cnx = JDBCTools.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE);
            pstmt.setInt(1, client.getCodeClient());
            pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
            throw new DALException("Suppression impossible du client");

        }
    }

    @Override
    public List<Client> selectByMotCle(String motCle) throws DALException {

        if (motCle == null) {
            throw new DALException("Le mot-clé est obligatoire");
        }

        List<Client> clients = new ArrayList<>();

        try (Connection cnx = JDBCTools.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_MOT_CLE);
            pStmt.setString(1, (motCle + "%"));

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                clients.add(this.clientBuilder(rs, false));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectByMotCle");
        }

        return clients;


    }

    public Client clientBuilder(ResultSet rs, Boolean avecAnimaux) throws SQLException {

        Client client = new Client();
        List<Animal> animauxDuCli = new ArrayList<>();
        AnimalDAO animalDAOCourant = DAOFactory.getAnimalDAO();
        Animal animalCourant;

        if (rs != null) {
            client.setCodeClient(rs.getInt("CodeClient"));
            client.setNomClient(rs.getString("NomClient"));
            client.setPrenomClient(rs.getString("PrenomClient"));
            client.setAdresse1(rs.getString("Adresse1"));
            client.setAdresse2(rs.getString("Adresse2"));
            client.setCodePostal(rs.getString("CodePostal"));
            client.setVille(rs.getString("Ville"));
            client.setNumTel(rs.getString("NumTel"));
            client.setAssurance(rs.getString("Assurance"));
            client.setEmail(rs.getString("Email"));
            client.setRemarque(rs.getString("Remarque"));
            if (rs.getByte("Archive") == 0) {
                client.setArchive(false);
            } else {
                client.setArchive(true);
            }

            if (avecAnimaux) {
                do {
                    animalCourant = animalDAOCourant.animalBuilder(rs);
                    animauxDuCli.add(animalCourant);
                } while (rs.next());
                client.setListeAnimaux(animauxDuCli);

            } else {
                client.setListeAnimaux(animauxDuCli);

            }
        }
        return client;
    }

    private void preparerParametres(Client client, PreparedStatement rqt) throws SQLException {
        rqt.setString(1, client.getNomClient());
        rqt.setString(2, client.getPrenomClient());
        rqt.setString(3, client.getAdresse1());
        rqt.setString(4, client.getAdresse2());
        rqt.setString(5, client.getCodePostal());
        rqt.setString(6, client.getVille());
        rqt.setString(7, client.getNumTel());
        rqt.setString(8, client.getAssurance());
        rqt.setString(9, client.getEmail());
        rqt.setString(10, client.getRemarque());

        if (client.isArchive())
            rqt.setByte(11, (byte) 1);

        if (!client.isArchive())
            rqt.setByte(11, (byte) 0);

    }


}