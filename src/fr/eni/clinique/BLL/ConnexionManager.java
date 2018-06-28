package fr.eni.clinique.BLL;

import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.PersonnelDAO;

import java.util.List;

public class ConnexionManager {
    private PersonnelDAO daoPersonnels;
    private List<Personnel> listePersonnels;
    private static ConnexionManager instance = null;

    private ConnexionManager() throws BLLException {
        daoPersonnels = DAOFactory.getPersonnelDAO();
        // Charger la liste de personnels
        try {
            listePersonnels = daoPersonnels.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des personnels - ", e);
        }
    }

    public static ConnexionManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new ConnexionManager();
        }
        return instance;
    }

    public Personnel getPersonnel(int codePers) throws BLLException {

        return listePersonnels.get(codePers);
    }

    public List<Personnel> getListePersonnels() throws BLLException {
        return listePersonnels;
    }
}
