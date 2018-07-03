package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.Connexion.AccueilManager;
import fr.eni.clinique.IHM.GestionClient.GestionClientController;
import fr.eni.clinique.IHM.GestionPersonnel.EcranGestionPersonnel;
import fr.eni.clinique.IHM.GestionPersonnel.GestionPersonnelController;

public class AccueilController {
    private EcranConnexion ecranConnexion;
    private EcranAccueil ecranAccueil;
    private EcranGestionPersonnel ecranGestionPersonnel;

    private AccueilManager manager;

    private static AccueilController instance;

    private AccueilController() {
        try {
            manager = AccueilManager.getInstance();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized AccueilController get() {
        if (instance == null) {
            instance = new AccueilController();
        }
        return instance;
    }

    public void affichageEcranAccueil() {
        ecranAccueil = new EcranAccueil(this);
        ecranAccueil.setVisible(true);
    }

    public void callEcranGestionPersonnel() {
        ecranAccueil.add(GestionPersonnelController.get().affichageEcranGestionPersonnel());
        ecranAccueil.revalidate();
    }

    public void callEcranGestionClient() {
        ecranAccueil.add(GestionClientController.get().affichageEcranGestionClient());
        ecranAccueil.revalidate();
    }
}
