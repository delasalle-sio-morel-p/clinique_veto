package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.ConnexionManager;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.IHM.GestionPersonnel.EcranGestionPersonnel;
import fr.eni.clinique.IHM.GestionPersonnel.GestionPersonnelController;

import javax.swing.*;
import java.util.List;

public class ConnexionController {
    private EcranConnexion ecranConnexion;
    private EcranAccueil ecranAccueil;
    private JPanel ecranGestionPersonnel;

    private int indexListe;

    private ConnexionManager manager;

    private List<Personnel> listePersonnels;

    private static ConnexionController instance;

    private boolean isPresent;

    private Personnel persoConnected;

    //Constructeur
    private ConnexionController() {
        try {
            manager = ConnexionManager.getInstance();

            //Initialisation du catalogue en mémoire
            listePersonnels = manager.getListePersonnels();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnexionController get() {
        if (instance == null) {
            instance = new ConnexionController();
        }
        return instance;
    }

    public void startApp() {
        ecranConnexion = new EcranConnexion(this);
        ecranConnexion.setVisible(true);
    }


    public void connexion(JTextField txtNom, JPasswordField mdp) throws BLLException {
//        GestionPersonnelManager.verificationMotPasse();
        System.out.println("Tentative de connexion");
        System.out.println(txtNom.getText());
        System.out.println(mdp.getText());

        isPresent = false;
        for (Personnel personne : listePersonnels) {

            if (personne.getNom().equals(txtNom.getText()) && personne.getMotPasse().equals(mdp.getText())) {
                isPresent = true;
                persoConnected = personne;
                break;
            }
        }
        if (isPresent) {
            System.out.println("ok");

            ecranAccueil = new EcranAccueil(this);
            ecranAccueil.setVisible(true);
            ecranConnexion.setVisible(false);
        } else
            System.out.println("wrong credentials");
    }

    public void deconnexion() {
        ecranConnexion = new EcranConnexion(this);
        ecranAccueil.setVisible(false);
        ecranConnexion.setVisible(true);
    }

    public void affichageEcranGestionPersonnel() {
        if(ecranGestionPersonnel == null)
            ecranGestionPersonnel = new EcranGestionPersonnel();
        ecranAccueil.add(ecranGestionPersonnel);

        ecranAccueil.revalidate();
    }
}
