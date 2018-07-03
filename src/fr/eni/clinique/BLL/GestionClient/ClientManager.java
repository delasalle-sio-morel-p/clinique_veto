package fr.eni.clinique.BLL.GestionClient;


import java.util.List;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.DAL.ClientDAO;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;

public class ClientManager {

    private static ClientManager instance = null;

    private ClientDAO daoClient;

    private ClientManager() {
        daoClient = DAOFactory.getClientDAO();
    }

    public static ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager();
        }
        return instance;
    }

    public List<Client> getListeClients() throws BLLException {
        List<Client> listeClients;
        try {
            listeClients = daoClient.selectAll();
        } catch (DALException e) {
            throw new BLLException("Erreur accès données : La liste des clients n'est pas récupérable");
        }
        return listeClients;
    }

    public List<Client> getListeClientsMotsCles(String motcle) throws BLLException {
        List<Client> listeClients;
        try {
            listeClients = daoClient.selectByMotCle(motcle);
        } catch (DALException e) {
            throw new BLLException("Erreur accès données : La liste des clients n'est pas récupérable");
        }
        return listeClients;
    }

    public Client getClient(int codeClient) throws BLLException {
        Client client = new Client();
        try {
            client = daoClient.selectById(codeClient);
        } catch (DALException e) {
            throw new BLLException("Le client n'a pas été trouvé");
        }
        return client;
    }

    public void addClient(Client client) throws BLLException {

        this.validerClient(client);

        try {
            daoClient.insert(client);
        } catch (DALException e) {
            throw new BLLException("Le GestionClient n'a pas pu être inséré dans la base");
        }
    }

    public void updateClient(Client client) throws BLLException {
        this.validerClient(client);

        try {
            daoClient.update(client);
        } catch (DALException e) {
            throw new BLLException("Les informations n'ont pas pu être mise à jour");
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