package fr.eni.clinique.DAL;

import java.util.List;
import fr.eni.clinique.BO.Espece;
import fr.eni.clinique.BO.Race;

public interface EspeceDAO extends DAO<Espece> {

    List<Race> selectRaceByEsp(String espece) throws DALException;

}