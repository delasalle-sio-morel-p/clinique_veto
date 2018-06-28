package fr.eni.clinique.IHM;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnelMgt;
import fr.eni.clinique.BO.Personnel;

import java.util.List;

public class GestionPersonnelController {
    private EcranGestionPersonnel ecranGestionPersonnel ;
    private int indexListe;

    private GestionPersonnelMgt manager;

    private List<Personnel> listePersonnels;

    private static GestionPersonnelController instance;

    //Constructeur
    private GestionPersonnelController(){
        try {
            manager = GestionPersonnelMgt.getInstance();

            //Initialisation du catalogue en mémoire
            listePersonnels = manager.getListePersonnels();


        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    //Méthodes
    public static synchronized GestionPersonnelController get(){
        if(instance == null){
            instance = new GestionPersonnelController();
        }
        return instance;
    }

    public void startApp(){
//        ecrArticle = new EcranArticle();
//
//        afficherPremierArticle();
//        ecrArticle.setVisible(true);

        ecranGestionPersonnel = new EcranGestionPersonnel();
        ecranGestionPersonnel.setVisible(true);
    }

//    public void nouveau() {
//        indexListe = listePersonnels.size();
//        ecranGestionPersonnel.afficherNouveau();
//
//    }

    public List<Personnel> getListePersonnels() {
        return listePersonnels;
    }


}