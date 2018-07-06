package fr.eni.clinique.BLL;


import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.BO.Animal;
import fr.eni.clinique.BO.Espece;
import fr.eni.clinique.BO.Race;
import fr.eni.clinique.DAL.AnimalDAO;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.EspeceDAO;

public class AnimalManager {

    /* ******* SINGLETON ******* */

    private AnimalDAO daoAnimal;
    private EspeceDAO daoEspece;
    private List<Animal> listeAnimaux;
    private List<Espece> listeEspeces;
    private List<String> listeSexes = new ArrayList<String>(){{ add("F"); add("M"); add("H"); }};
    private static AnimalManager instance = null;

    private AnimalManager() throws BLLException {

        daoAnimal = DAOFactory.getAnimalDAO();
        daoEspece = DAOFactory.getEspeceDAO();
        try {
            listeAnimaux = daoAnimal.selectAll();
            listeEspeces = daoEspece.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des animaux et des especes - ", e);
        }
    }

    public static AnimalManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new AnimalManager();
        }
        return instance;
    }

    /* ******* METHODES DU MANAGER ******* */

    public List<Animal> getListeAnimaux() throws BLLException {
        return listeAnimaux;
    }

    public List<Espece> getListeEspeces() throws BLLException {
        return listeEspeces;
    }

    public List<String> getListeSexe() throws BLLException{
        return listeSexes;
    }
    public void addAnimal(Animal animal) throws BLLException {
        this.validerAnimal(animal);

        try {
            daoAnimal.insert(animal);
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("L'Animal n'a pas pu être ajouté");
        }

    }

    /**
     * Méthode qui renvoie la liste des animaux appartenant à un client
     *
     * @param codeClient
     * @throws BLLException
     */
    public List<Animal> selectAnimaux(int codeClient) throws BLLException {
        List<Animal> animauxDuClient;

        try {
            animauxDuClient = daoAnimal.selectAnimauxByClient(codeClient);
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("Erreur d'accès aux données.");
        }

        return animauxDuClient;
    }

    public void updateAnimal(Animal animal) throws BLLException {

        this.validerAnimal(animal);

        try {
            daoAnimal.update(animal);
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException("Les informations de l'animal n'ont pas pu être mises à jour.");
        }
    }

    public void deleteAnimal(Animal animal) throws BLLException {

        validerAnimal(animal);

        try {
            daoAnimal.delete(animal);
            //listePersonnels.remove(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'archivage en BDD du personnel.");
        }


    }

    private void validerAnimal(Animal animal) throws BLLException {
        verificationNomAnimal(animal);
        verificationCouleur(animal);
        verificationSexe(animal);
        verificationEspece(animal);
        verificationRace(animal);
        verificationTatouage(animal);
    }

    private void verificationNomAnimal(Animal animal) throws BLLException {
        if (animal.getNomAnimal() == null || animal.getNomAnimal().trim().isEmpty()) {
            throw new BLLException("Le Nom de l'animal doit être renseigné.");
        } else if (animal.getNomAnimal().length() > 30) {
            throw new BLLException("Le Nom de l'animal ne doit pas excéder 30 caractères");
        }
    }

    private void verificationCouleur(Animal animal) throws BLLException {
        if (animal.getCouleur().length() > 20) {
            throw new BLLException("La couleur de l'animal ne doit pas excéder 20 caractères");
        }
    }

    private void verificationSexe(Animal animal) throws BLLException {
        if (animal.getSexe() == null || animal.getSexe().trim().isEmpty()) {
            throw new BLLException("Le sexe de l'animal doit être renseigné.");
        } else if ((animal.getSexe().length() > 1)) {
            throw new BLLException("A.Le sexe de l'animal doit être M pour un mâle, F pour une femelle et H pour un hermaphrodite.");
        } else if (('H' != animal.getSexe().charAt(0)) && ('M' != animal.getSexe().charAt(0)) && ('F' != animal.getSexe().charAt(0))) {

            throw new BLLException("B.Le sexe de l'animal doit être M pour un mâle, F pour une femelle et H pour un hermaphrodite.");
        }
    }

    private void verificationEspece(Animal animal) throws BLLException {
        if (animal.getEspece() == null || animal.getEspece().trim().isEmpty()) {
            throw new BLLException("L'espèce de l'animal doit être renseignée.");
        } else if (animal.getEspece().length() > 20) {
            throw new BLLException("L'espèce de l'animal ne doit pas excéder 20 caractères");
        }
    }

    private void verificationRace(Animal animal) throws BLLException {
        if (animal.getRace() == null || animal.getRace().trim().isEmpty()) {
            throw new BLLException("La race de l'animal doit être renseignée.");
        } else if (animal.getRace().length() > 20) {
            throw new BLLException("La race de l'animal ne doit pas excéder 20 caractères");
        }
    }

    private void verificationTatouage(Animal animal) throws BLLException {
        if (animal.getTatouage() != null && animal.getTatouage().length() > 10) {
            throw new BLLException("Le tatouage de l'animal ne doit pas excéder 10 caractères");
        }
    }

}