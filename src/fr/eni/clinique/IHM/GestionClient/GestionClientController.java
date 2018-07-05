package fr.eni.clinique.IHM.GestionClient;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionClient.ClientManager;
import fr.eni.clinique.BO.Client;
import fr.eni.clinique.IHM.Animaux.AjouterAnimal;
import fr.eni.clinique.IHM.Connexion.AccueilController;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GestionClientController {
    private EcranAccueil ecranAccueil;
    private EcranGestionClient ecranGestionClient;
    private ResultatRechercheClient rechercherClient;
    private AjouterClient ajouterClient;
    private AjouterAnimal ajoutAnimal;
    private SupprimerClient supprimerClient;
    private TableClientModel modele;

    private ClientManager manager;

    private List<Client> listeClients;
    private ArrayList<Client> listeClientsSelectionne;
    private Client clientSelectionne;
    private  boolean isPresent;

    private static GestionClientController instance;


    //Constructeur
    private GestionClientController() {
        try {
            manager = ClientManager.getInstance();

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

    public void afficherRechercherClient(JTextField textFieldCode, JTextField textFieldNom, JTextField textFieldPrenom, JTextField textFieldAdresse1, JTextField textFieldAdresse2, JTextField textFieldCodePostal, JTextField textFieldVille) {
        System.out.println("rechercher client");
        rechercherClient = new ResultatRechercheClient(AccueilController.get().getEcranAccueil(), textFieldCode, textFieldNom, textFieldPrenom, textFieldAdresse1, textFieldAdresse2, textFieldCodePostal, textFieldVille, this);
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

    public void rechercherClient(String nom, JTable table) {
        listeClientsSelectionne = new ArrayList<>();
        listeClientsSelectionne = selectionListeClients(nom);
        modele = new TableClientModel(listeClientsSelectionne);
        table.setModel(modele);
        modele.fireTableDataChanged();
        System.out.println(listeClientsSelectionne);
    }

    public Client selectionnerClient( JTable tableClients, JTextField textFieldCode, JTextField textFieldNom, JTextField textFieldPrenom, JTextField textFieldAdresse1, JTextField textFieldAdresse2, JTextField textFieldCodePostal, JTextField textFieldVille) {
        clientSelectionne = new Client();
        int ligneSelectionne = tableClients.getSelectedRow();
        System.out.println("selectionner client");
        if (ligneSelectionne != -1) {
            String nomSelectionne = (String) tableClients.getValueAt(ligneSelectionne, 0);
            String prenomSelectionne = (String) tableClients.getValueAt(ligneSelectionne, 1);
            System.out.println(nomSelectionne + " " + prenomSelectionne);

            clientSelectionne = selectionClient(nomSelectionne, prenomSelectionne);
            textFieldCode.setText(String.valueOf(clientSelectionne.getCodeClient()));
            textFieldNom.setText(clientSelectionne.getNomClient());
            textFieldPrenom.setText(clientSelectionne.getPrenomClient());
            textFieldAdresse1.setText(clientSelectionne.getAdresse1());
            textFieldAdresse2.setText(clientSelectionne.getAdresse2());
            textFieldCodePostal.setText(clientSelectionne.getCodePostal());
            textFieldVille.setText(clientSelectionne.getVille());
            System.out.println(clientSelectionne);
            rechercherClient.setVisible(false);
            return clientSelectionne;
        }
        return clientSelectionne;
    }
    public void annuler() {
        if (ajouterClient != null)
            ajouterClient.setVisible(false);
        if (supprimerClient != null)
            supprimerClient.setVisible(false);
    }

    public ArrayList<Client> selectionListeClients(String nom) {
        listeClientsSelectionne = new ArrayList<>();
        for (Client client : listeClients) {
            if (client.getNomClient().startsWith(nom.toUpperCase())) {
                listeClientsSelectionne.add(client);
            }
        }
        if (! listeClientsSelectionne.isEmpty()) {
            System.out.println("Personne(s) présente(s) en base de donnée :");
            System.out.println(listeClientsSelectionne);
            return listeClientsSelectionne;
        } else
            System.out.println("Personne non présente en base de donnée");
        return null;
    }

    public Client selectionClient(String nom, String prenom) {
        isPresent = false;
        for (Client client : listeClients) {

            if (client.getNomClient().equals(nom) && client.getPrenomClient().equals(prenom)) {
                isPresent = true;
                clientSelectionne = client;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Client présent en base de donnée :");
            System.out.println(clientSelectionne);
            return clientSelectionne;
        } else
            System.out.println("Client non présent en base de donnée");
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