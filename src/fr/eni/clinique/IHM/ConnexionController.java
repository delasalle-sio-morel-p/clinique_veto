package fr.eni.clinique.IHM;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.ConnexionManager;
import fr.eni.clinique.BO.Personnel;

import javax.swing.*;
import java.util.List;

public class ConnexionController {
    private EcranConnexion ecranConnexion;
    private EcranAccueil ecranAccueil;

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

            ecranAccueil = new EcranAccueil();
            ecranAccueil.setVisible(true);
            ecranConnexion.setVisible(false);
        }else
            throw new BLLException("Identifiant ou mot de passe incorrect") ;
    }
}
