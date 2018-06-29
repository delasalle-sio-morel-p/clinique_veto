package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnelManager;
import fr.eni.clinique.BO.Personnel;

import java.util.List;

public class GestionPersonnelController {
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

}