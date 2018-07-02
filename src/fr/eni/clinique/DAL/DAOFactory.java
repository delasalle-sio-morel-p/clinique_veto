package fr.eni.clinique.DAL;

import fr.eni.clinique.DAL.JDBC.AnimalDAOJdbcImpl;
import fr.eni.clinique.DAL.JDBC.EspeceDAOJdbcImpl;
import fr.eni.clinique.DAL.JDBC.GestionPersonnelDAOJdbcImpl;
import fr.eni.clinique.DAL.JDBC.RoleDAOJdbcImpl;

public class DAOFactory {

    public static PersonnelDAO getPersonnelDAO(){

        return new GestionPersonnelDAOJdbcImpl();

    }

    public static AnimalDAO getAnimalDAO(){

        return new AnimalDAOJdbcImpl();

    }

    public static EspeceDAO getEspeceDAO(){

        return new EspeceDAOJdbcImpl();

    }

    public static RoleDAO getRoleDAO(){

        return new RoleDAOJdbcImpl();

    }
}
