package fr.eni.clinique.BLL;

import fr.eni.clinique.BO.Client;
import fr.eni.clinique.DAL.ClientDAO;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.DAOFactory;

import java.util.List;

public class GestionClientManager {

    private ClientDAO daoClients;
    private List<Client> listeClients;
    private static GestionClientManager instance = null;

    private GestionClientManager() throws BLLException {
        daoClients = DAOFactory.getClientDAO();
        // Charger la liste de personnels
        try {
            listeClients = daoClients.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des personnels - ", e);
        }
    }

    public static GestionClientManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new GestionClientManager();
        }
        return instance;
    }

    public Client getClient(int codeClient) throws BLLException {

        return listeClients.get(codeClient);
    }

    public List<Client> getListeClients() throws BLLException {
        return listeClients;
    }

    public void addClient(Client client) throws BLLException {

        try {
            daoClients.insert(client);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion en BDD du client.");
        }

    }

    public void updatePersonnel(Client client) throws BLLException {
        try {
            daoClients.update(client);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de la mise à jour en BDD du client.");
        }


    }

}
