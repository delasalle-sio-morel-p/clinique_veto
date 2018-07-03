package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.Connexion.ConnexionManager;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.IHM.GestionPersonnel.GestionPersonnelController;

import javax.swing.*;
import java.util.List;

public class ConnexionController {
    private EcranConnexion ecranConnexion;
    private EcranAccueil ecranAccueil;

    private ConnexionManager manager;

    private List<Personnel> listePersonnels;

    private static ConnexionController instance;

    private boolean isPresent;

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
                break;
            }
        }
        if (isPresent) {
            System.out.println("ok");
            callEcranAccueil();
            ecranConnexion.setVisible(false);
        } else
            System.out.println("wrong credentials");
    }

    public void deconnexion() {
        ecranConnexion = new EcranConnexion(this);
        ecranAccueil.setVisible(false);
        ecranConnexion.setVisible(true);
    }

    public void callEcranAccueil(){
        GestionPersonnelController.get().affichageEcranAccueil();
    }
}
