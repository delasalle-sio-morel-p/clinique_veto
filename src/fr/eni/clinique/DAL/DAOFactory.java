package fr.eni.clinique.DAL;

import fr.eni.clinique.DAL.JDBC.AnimalDAOJdbcImpl;
import fr.eni.clinique.DAL.JDBC.EspeceDAOJdbcImpl;
import fr.eni.clinique.DAL.JDBC.GestionPersonnelDAOJdbcImpl;

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
}
