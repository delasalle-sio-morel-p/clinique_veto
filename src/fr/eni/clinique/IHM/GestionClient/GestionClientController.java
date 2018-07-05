package fr.eni.clinique.IHM.GestionClient;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionClient.GestionClientManager;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.IHM.Animaux.AjouterAnimal;
import fr.eni.clinique.IHM.Animaux.SupprimerAnimal;
import fr.eni.clinique.IHM.Connexion.AccueilController;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;
import fr.eni.clinique.IHM.GestionPersonnel.TablePersonnelModel;

import javax.swing.*;
import java.util.List;

public class GestionClientController {
    private EcranAccueil ecranAccueil;
    private EcranGestionClient ecranGestionClient;
    private ResultatRechercheClient rechercherClient;
    private AjouterClient ajouterClient;
    private AjouterAnimal ajoutAnimal;
    private SupprimerClient supprimerClient;
    private boolean isPresent;
    private Client clientSelectionne;
    private TablePersonnelModel modele;

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

    public EcranGestionClient affichageEcranGestionClient() {
        if (ecranGestionClient == null)
            ecranGestionClient = new EcranGestionClient(this);
        return ecranGestionClient;
    }

    public void afficherRechercherClient() {
        System.out.println("rechercher client");
        rechercherClient = new ResultatRechercheClient(AccueilController.get().getEcranAccueil(), this);
        rechercherClient.setVisible(true);
    }

    public void afficherAjouterClient() {
        System.out.println("rechercher client");
        ajouterClient = new AjouterClient(AccueilController.get().getEcranAccueil(), this);
        ajouterClient.setVisible(true);
    }

    public void afficherSupprimerClient() {
        System.out.println("rechercher client");
        supprimerClient = new SupprimerClient(AccueilController.get().getEcranAccueil(), this);
        supprimerClient.setVisible(true);
    }

    public void rechercherClient(String nom) {
//        modele = new TablePersonnelModel(getListeClients());
        System.out.println(clientSelectionne(nom));
    }
    public void annuler() {
        if (ajouterClient != null)
            ajouterClient.setVisible(false);
        if (supprimerClient != null)
            supprimerClient.setVisible(false);
    }

    public Client clientSelectionne(String nom) {
        isPresent = false;
        for (Client client : listeClients) {
            if (client.getNomClient().startsWith(nom.toUpperCase())) {
                isPresent = true;
                clientSelectionne = client;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Personne présente en base de donnée :");
            System.out.println(clientSelectionne);
            return clientSelectionne;
        } else
            System.out.println("Personne non présente en base de donnée");
        return null;
    }

    public void ajouterClient(String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville, String noTel, String assurance, String email) {
        System.out.println("ajouterClient");
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(adresse1);
        System.out.println(codePostal);
        System.out.println(ville);
        System.out.println(noTel);
        System.out.println(assurance);
        System.out.println(email);
        Client client = null;

        client = new Client(nom, prenom, adresse1, adresse2, codePostal, ville, noTel, assurance, email,  false);

        try {
            manager.addClient(client);
            System.out.println(client + " ajouté à la base de donnée");
            ajouterClient.setVisible(false);
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public void affichageEcranAjoutAnimal() {
        ajoutAnimal = new AjouterAnimal(AccueilController.get().getEcranAccueil(), this);
        ajoutAnimal.setVisible(true);
    }

    public void affichageSupprimerAnimal(JTable tableAnimaux) {
//        supprimerAnimal = new SupprimerAnimal(AccueilController.get().getEcranAccueil(), this);
//        supprimerAnimal.setVisible(true);
    }

    public void affichageModifierAnimal(JTable tableAnimaux) {
//        supprimerAnimal = new SupprimerAnimal(AccueilController.get().getEcranAccueil(), this);
//        supprimerAnimal.setVisible(true);
    }


}