package fr.eni.clinique.IHM.Animaux;

import fr.eni.clinique.BLL.AnimalManager;
import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BO.Animal;
import fr.eni.clinique.BO.Espece;
import fr.eni.clinique.BO.Race;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import java.util.List;

public class GestionAnimalController {

    private EcranAccueil ecranAccueil;
    private AjouterAnimal ajouterAnimal;
    private SupprimerAnimal supprimerAnimal;

    private AnimalManager animalManager;

    private List<Animal> listeAnimaux;
    private List<Espece> listeEspeces;
    private List<String> listeSexes;

    private static GestionAnimalController instance;

    //private TableAnimalModel modele;


    //Constructeur
    private GestionAnimalController() {
        try {
            animalManager = AnimalManager.getInstance();

            //Initialisation du catalogue en mémoire
            listeAnimaux = animalManager.getListeAnimaux();
            listeEspeces = animalManager.getListeEspeces();
            listeSexes = animalManager.getListeSexe();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public List<Espece> getListeEspeces() {
        return listeEspeces;
    }

    public List<String> getListeSexes() {
        return listeSexes;
    }


    //Méthodes
    public static synchronized GestionAnimalController get() {
        if (instance == null) {
        }
        return instance;
    }


}
