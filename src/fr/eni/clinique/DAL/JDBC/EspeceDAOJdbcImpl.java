package fr.eni.clinique.DAL.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Espece;
import fr.eni.clinique.BO.Race;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.EspeceDAO;

public class EspeceDAOJdbcImpl implements EspeceDAO {

    private static final String SELECT_ALL_ESPECES = "SELECT Espece FROM Races GROUP BY Espece;";

    private static final String SELECT_RACE_BY_ESPECE = "SELECT Race FROM Races WHERE Espece =?;";


    @Override
    public List<Race> selectEspByRace(String espece) throws DALException {
        Connection cnx;
        ResultSet rs;
        List<Race> racesSelect = new ArrayList<>();

        try {
            cnx = JDBCTools.getConnection();
            PreparedStatement rqt = cnx.prepareStatement(SELECT_RACE_BY_ESPECE);
            rqt.setString(1, espece);
            rs = rqt.executeQuery();
            while (rs.next()) {
                racesSelect.add(this.raceBuilder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectEspByRace");
        }

        return racesSelect;
    }


    @Override
    public Espece selectById(int id) throws DALException {
        return null;
    }

    @Override
    public List<Espece> selectAll() throws DALException {
        Connection cnx;
        Statement rqt;
        ResultSet rs;
        List<Espece> especesSelect = new ArrayList<>();

        try  {
            cnx = JDBCTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SELECT_ALL_ESPECES);
            while (rs.next()) {
                especesSelect.add(this.especeBuilder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectEspByRace");
        }
        return especesSelect;
    }

    public Race raceBuilder(ResultSet rs) throws SQLException {
        Race race = new Race();

        if (rs != null) {
            race.setRace(rs.getString("Race"));
        }
        return race;
    }

    public Espece especeBuilder(ResultSet rs) throws SQLException {
        Espece espece = new Espece();

        if (rs != null) {
            espece.setEspece(rs.getString("Espece"));
        }
        return espece;
    }

    @Override
    public void insert(Espece data) throws DALException {

    }

    @Override
    public void update(Espece data) throws DALException {

    }

    @Override
    public void delete(Espece obj) throws DALException {

    }


}