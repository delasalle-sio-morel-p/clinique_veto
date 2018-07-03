package fr.eni.clinique.IHM.GestionClient;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionClient.GestionClientManager;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import java.util.List;

public class GestionClientController {
    private EcranAccueil ecranAccueil;
    private EcranGestionClient ecranGestionClient;
    private AjouterClient ajouterClient;

    private GestionClientManager manager;

    private List<Client> listeClients;

    private static GestionClientController instance;


    //Constructeur
    private GestionClientController() {
        try {
            manager = GestionClientManager.getInstance();

            //Initialisation du catalogue en mémoire
            listeClients = manager.getListeClients();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    //Méthodes
    public static synchronized GestionClientController get() {
        if (instance == null) {
            instance = new GestionClientController();
        }
        return instance;
    }

    public void affichageEcranGestionClient() {
        if (ecranGestionClient == null)
            ecranGestionClient = new EcranGestionClient(this);
        ecranAccueil.add(ecranGestionClient);
        ecranAccueil.revalidate();
    }
}