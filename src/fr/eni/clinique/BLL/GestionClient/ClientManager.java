package fr.eni.clinique.BLL.GestionClient;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.DAL.ClientDAO;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.DAOFactory;

import java.util.List;

public class ClientManager {

    private ClientDAO daoClients;
    private List<Client> listeClients;
    private static ClientManager instance = null;

    private ClientManager() throws BLLException {
        daoClients = DAOFactory.getClientDAO();
        // Charger la liste de personnels
        try {
            listeClients = daoClients.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des personnels - ", e);
        }
    }

    public static ClientManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new ClientManager();
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
            client.setNomClient(client.getNomClient().toUpperCase());
            client.setVille(client.getVille().toUpperCase());
            daoClients.insert(client);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion en BDD du client.");
        }

    }

    public void updateClient(Client client) throws BLLException {
        try {
            client.setNomClient(client.getNomClient().toUpperCase());
            client.setVille(client.getVille().toUpperCase());
            daoClients.update(client);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de la mise à jour en BDD du client.");
        }
    }

    private void validerClient(Client client) throws BLLException {
        verifierNomClient(client);
        verifierPrenomClient(client);
        verifierMail(client);
        verifierNumTel(client);
        verifierAdresse1(client);
        verifierAdresse2(client);
        verifierCP(client);
        verifierVille(client);
        verifierAssurance(client);
    }

    private void verifierNomClient(Client client) throws BLLException {
        if (client.getNomClient() == null || client.getNomClient().trim().isEmpty()) {
            throw new BLLException("Le Nom doit être renseigné.");
        } else if (client.getNomClient().length() > 20) {
            throw new BLLException("Le nom ne doit pas dépasser 20 caractères");
        }
    }

    private void verifierPrenomClient(Client client) throws BLLException {
        if (client.getPrenomClient() == null || client.getPrenomClient().trim().isEmpty()) {
            throw new BLLException("Le Prénom du GestionClient doit être renseigné.");
        } else if (client.getPrenomClient().length() > 20) {
            throw new BLLException("Le prénom ne doit pas dépasser 20 caractères");
        }
    }

    private void verifierMail(Client client) throws BLLException {
        if (client.getEmail().length() > 50) {
            throw new BLLException("L'email ne doit pas dépasser 50 caractères");
        }
    }

    private void verifierNumTel(Client client) throws BLLException {
        if (client.getNumTel().length() > 15) {
            throw new BLLException("Le num de tel ne doit pas dépasser 15 caractères");
        }
    }

    private void verifierAdresse1(Client client) throws BLLException {
        if (client.getAdresse1().length() > 30) {
            throw new BLLException("L'adresse ne doit pas dépasser 30 caractères");
        }
    }

    private void verifierAdresse2(Client client) throws BLLException {
        if (client.getAdresse2().length() > 30) {
            throw new BLLException("L'adresse ne doit pas dépasser 30 caractères");
        }
    }

    private void verifierCP(Client client) throws BLLException {
        if (client.getCodePostal().length() > 6) {
        }
    }

    private void verifierVille(Client client) throws BLLException {
        if (client.getVille().length() > 25) {
            throw new BLLException("La ville ne doit pas dépasser 25 caractères");
        }
    }

    private void verifierAssurance(Client client) throws BLLException {
        if (client.getAssurance().length() > 30) {
            throw new BLLException("L'assurance ne doit pas dépasser 30 caractères");
        }
    }

}
