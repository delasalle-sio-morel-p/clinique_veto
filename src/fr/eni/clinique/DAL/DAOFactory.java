package fr.eni.clinique.DAL;

import fr.eni.clinique.DAL.JDBC.*;

public class DAOFactory {

    public static PersonnelDAO getPersonnelDAO(){

        return new GestionPersonnelDAOJdbcImpl();

    }

    public static ClientDAO getClientDAO(){

        return new ClientDAOJdbcImpl();

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
