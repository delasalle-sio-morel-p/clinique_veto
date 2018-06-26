package fr.eni.clinique.DAL;

import fr.eni.clinique.DAL.JDBC.GestionPersonnelDAOJdbcImpl;

public class DAOFactory {

    public static PersonnelDAO getPersonnelDAO(){

        return new GestionPersonnelDAOJdbcImpl();

    }
}
