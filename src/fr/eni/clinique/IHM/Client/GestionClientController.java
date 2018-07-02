package fr.eni.clinique.IHM.Client;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionClientManager;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;
import fr.eni.clinique.IHM.GestionPersonnel.EcranGestionPersonnel;

import java.util.List;

public class GestionClientController {
    private EcranAccueil ecranAccueil;
    private EcranClient ecranClient;
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

    public void affichageEcranClient() {
        if (ecranClient == null)
            ecranClient = new EcranClient(this);
        ecranAccueil.add(ecranClient);
        ecranAccueil.revalidate();
    }
}