package fr.eni.clinique.DAL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fr.eni.clinique.BO.Animal;

public interface AnimalDAO extends DAO<Animal> {

    List<Animal> selectAnimauxByClient(int codeClient) throws DALException;

    Animal animalBuilder(ResultSet rs) throws SQLException;


}