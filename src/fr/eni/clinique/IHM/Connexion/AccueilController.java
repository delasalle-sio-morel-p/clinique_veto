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

    public void affichageEcranAccueil(String role) {
        ecranAccueil = new EcranAccueil(this, role);
        ecranAccueil.setVisible(true);
    }

    public void callEcranGestionPersonnel() {
        if (GestionClientController.get().affichageEcranGestionClient() != null) {
            ecranAccueil.remove(GestionClientController.get().affichageEcranGestionClient());
            ecranAccueil.repaint();
            ecranAccueil.revalidate();
        }
        ecranAccueil.add(GestionPersonnelController.get().affichageEcranGestionPersonnel());
        ecranAccueil.revalidate();
    }

    public void callEcranGestionClient() {
        if (GestionPersonnelController.get().affichageEcranGestionPersonnel() != null) {
            ecranAccueil.remove(GestionPersonnelController.get().affichageEcranGestionPersonnel());
            ecranAccueil.repaint();
            ecranAccueil.revalidate();
        }
        ecranAccueil.add(GestionClientController.get().affichageEcranGestionClient());
        ecranAccueil.revalidate();
    }

    public EcranAccueil getEcranAccueil() {
        if (ecranAccueil == null)
            ecranAccueil = new EcranAccueil(this);
        return ecranAccueil;
    }
}
