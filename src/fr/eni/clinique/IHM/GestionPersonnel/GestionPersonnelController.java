package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnelManager;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import java.util.List;

public class GestionPersonnelController {
    private EcranAccueil ecranAccueil;
    private EcranGestionPersonnel ecranGestionPersonnel ;

    private int indexListe;

    private GestionPersonnelManager manager;

    private List<Personnel> listePersonnels;

    private static GestionPersonnelController instance;


    //Constructeur
    private GestionPersonnelController(){
        try {
            manager = GestionPersonnelManager.getInstance();

            //Initialisation du catalogue en mémoire
            listePersonnels = manager.getListePersonnels();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public List<Personnel> getListePersonnels() {
        return listePersonnels;
    }

    //Méthodes
    public static synchronized GestionPersonnelController get(){
        if(instance == null){
            instance = new GestionPersonnelController();
        }
        return instance;
    }

    public void affichageEcranAccueil() {
        ecranAccueil = new EcranAccueil(this);
        ecranAccueil.setVisible(true);
    }

    public void affichageEcranGestionPersonnel() {
        if(ecranGestionPersonnel == null)
            ecranGestionPersonnel = new EcranGestionPersonnel(this);
        ecranAccueil.add(ecranGestionPersonnel);

        ecranAccueil.revalidate();
    }
    public void ajouter() {
        System.out.println("ajouter");
//        ecranAccueil.remove(ecranGestionPersonnel);
//        ecranAccueil.add(ecranGestionPersonnel);

//        ecranAccueil.revalidate();
    }

}