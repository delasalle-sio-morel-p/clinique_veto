package fr.eni.clinique.BLL;


import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Espece;
import fr.eni.clinique.BO.Race;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.EspeceDAO;

public class EspeceManager {


    /* ******* SINGLETON ******* */

    private EspeceDAO daoEspece;

    private static EspeceManager instance = null;

    private EspeceManager() {
        daoEspece = DAOFactory.getEspeceDAO();
    }

    public static EspeceManager getInstance(){
        if (instance == null) {
            instance = new EspeceManager();
        }
        return instance;
    }

    /* ******* METHODES DU MANAGER ******* */

    public List<Race> selectEspByRace(String espece) throws BLLException {

        List<Race> racesSelect= new ArrayList<>();

        try {
            racesSelect = daoEspece.selectEspByRace(espece);

        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("Erreur d'accès aux données.");
        }

        return racesSelect;
    }


    public List<Espece> selectAllEspeces() throws BLLException{
        List<Espece> especesSelect = new ArrayList<>();

        try {
            especesSelect = daoEspece.selectAll();
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("Erreur d'accès aux données.");
        }

        return especesSelect;
    }

}