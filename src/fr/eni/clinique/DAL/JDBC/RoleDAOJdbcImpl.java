package fr.eni.clinique.DAL.JDBC;

import fr.eni.clinique.BO.Role;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.RoleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOJdbcImpl implements RoleDAO {

    private static final String SELECT_BY_ID = "SELECT * FROM Roles WHERE IdRole=?";

    private static final String SELECT_ALL = "SELECT * FROM Roles";

    private static final String INSERT = "INSERT INTO Roles (CodeRole, Libelle) VALUES (?, ?)";

    private static final String UPDATE = "UPDATE Roles SET CodeRole=?, Libelle=? WHERE IdRole=?";
//A FAIRE @Patrick
//    private static final String DELETE = "DELETE FROM Role WHERE CodeRole=?";

    @Override
    public Role selectById(int id) throws DALException {
        Role role = null;

        try (Connection cnx = JDBCTools.getConnection()) {

            PreparedStatement rqt = cnx.prepareStatement(SELECT_BY_ID);
            rqt.setInt(1, id);

            ResultSet rs = rqt.executeQuery();
            if (rs.next()) {
                role = this.roleBuilder(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("selectById");
        }

        return role;
    }


    @Override
    public List<Role> selectAll() throws DALException {
        Connection cnx = null;
        Statement rqt = null;
        ResultSet rs = null;

        List<Role> listeRoles= new ArrayList<>();

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                listeRoles.add(this.roleBuilder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur récupération liste complète des roles");
        }

        return listeRoles;
    }

    @Override
    public void insert(Role role) throws DALException {
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rsId = null;

        if (role == null) {
            throw new NullPointerException();
        }

        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparerParametres(role, rqt);

            rqt.executeUpdate();

            rsId = rqt.getGeneratedKeys();

            if (rsId.next()) {
                role.setIdRole(rsId.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur lors de l'insertion d'un nouveau role");
        }

    }


    @Override
    public void update(Role role) throws DALException {
        PreparedStatement rqt = null;
        Connection cnx = null;
        if (role == null) {
            throw new NullPointerException();
        }
        try {
            cnx = JDBCTools.getConnection();
            rqt = cnx.prepareStatement(UPDATE);
            preparerParametres(role, rqt);
            rqt.setInt(3, role.getIdRole());
            rqt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("Erreur lors de la mise à jour d'un role");
        }
    }

    @Override
    public void delete(Role obj) throws DALException {

    }

    private void preparerParametres(Role role, PreparedStatement rqt) throws SQLException {
        rqt.setString(1, role.getCodeRole());
        rqt.setString(2, role.getLibelle());
    }

    @Override
    public Role roleBuilder(ResultSet rs) throws SQLException {
        Role role = null;
        role = new Role();
        role.setIdRole(rs.getInt("IdRole"));
        role.setCodeRole(rs.getString("CodeRole"));
        role.setLibelle(rs.getString("Libelle"));
        return role;
    }
}
