package fr.eni.clinique.IHM;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.ConnexionManager;

import javax.swing.*;

public class ConnexionController {
    private EcranConnexion ecranConnexion;
    private EcranAccueil ecranAccueil;

    private int indexListe;

    private ConnexionManager manager;

    private static ConnexionController instance;

    //Constructeur
    private ConnexionController() {
        try {
            manager = ConnexionManager.getInstance();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnexionController get(){
        if(instance == null){
            instance = new ConnexionController();
        }
        return instance;
    }

    public void startApp(){
        ecranConnexion = new EcranConnexion(this);
        ecranConnexion.setVisible(true);
    }


    public void connexion(JTextField txtNom, JPasswordField mdp) {
//        GestionPersonnelManager.verificationMotPasse();
        System.out.println(txtNom.getText());
        System.out.println(mdp.getPassword());

        ecranAccueil = new EcranAccueil();
        ecranAccueil.setVisible(true);
        ecranConnexion.setVisible(false);
    }
}
