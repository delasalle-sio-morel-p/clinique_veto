package fr.eni.clinique.DAL;

import fr.eni.clinique.BO.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RoleDAO extends DAO<Role>{

    public Role roleBuilder(ResultSet rs) throws SQLException;

}
