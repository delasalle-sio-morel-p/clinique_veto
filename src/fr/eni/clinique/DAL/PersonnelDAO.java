package fr.eni.clinique.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.clinique.BO.Personnel;

public interface PersonnelDAO extends DAO<Personnel> {

    public Personnel personnelBuilder(ResultSet rs) throws SQLException;

}