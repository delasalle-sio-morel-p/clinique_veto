package fr.eni.clinique.BLL;

import java.util.ArrayList;
import java.util.List;


import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Veterinaire;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.PersonnelDAO;

public class GestionPersonnelMgt {

    private PersonnelDAO daoPers;
    // private VerifChamps verif = VerifChamps.getInstance();

    /* ******* SINGLETON ******* */
    private static GestionPersonnelMgt instance = null;

    private GestionPersonnelMgt() {
        daoPers = DAOFactory.getPersonnelDAO();

    }

    public static GestionPersonnelMgt getInstance() {
        if (instance == null) {
            instance = new GestionPersonnelMgt();
        }
        return instance;
    }

    public void addPersonnel(Personnel pers) throws BLLException {

        validerPersonnel(pers);

        try {
            daoPers.insert(pers);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion en BDD du personnel.");
        }

    }

    public void updatePersonnel(Personnel pers) throws BLLException {

        validerPersonnel(pers);

        try {
            daoPers.update(pers);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de la mise à jour en BDD du personnel.");
        }


    }

    public List<Personnel> getListePersonnel() throws BLLException {

        List<Personnel> listePersonnels = new ArrayList<>();

        try {
            listePersonnels = daoPers.selectAll();
        } catch (DALException e) {
            throw new BLLException("Erreur accès données : la liste du personnel n'est pas récupérable");
        }


        return listePersonnels;


    }

    public Personnel getPersonnel(int codePers) throws BLLException {

        Personnel pers = null;

        try {
            pers = daoPers.selectById(codePers);
        } catch (DALException e) {
            throw new BLLException("Erreur accès données : Problème lors de l'accès aux données ");
        }

        return pers;
    }

    public List<Veterinaire> getListeVeto() throws BLLException {
        List<Veterinaire> listeVetos = new ArrayList<>();
        List<Personnel> listePersonnels = getListePersonnel();

        for (Personnel personnel : listePersonnels) {
            if (personnel instanceof Veterinaire) {
                listeVetos.add((Veterinaire) personnel);

            }

        }

        return listeVetos;

    }

    private void validerPersonnel(Personnel pers) throws BLLException {

        verificationNomPersonnel(pers);

        verificationMotPasse(pers);

        verificationRole(pers);

    }

    private void verificationNomPersonnel(Personnel pers) throws BLLException {
        if (pers.getNom() == null || pers.getNom().trim().isEmpty()) {
            throw new BLLException("Le nom est obligatoire");
        } else if (pers.getNom().length() > 30) {
            throw new BLLException("Le nom ne doit pas dépasser 30 caractères.");
        }
    }

    private void verificationRole(Personnel pers) throws BLLException {
        if (pers.getRole() == null || pers.getRole().trim().isEmpty()) {
            throw new BLLException("Il est obligatoire d'attribuer un rôle au nouveau salarié : sec, vet ou adm.");
        } else if (!(pers.getRole().equals("sec") || pers.getRole().equals("adm") || pers.getRole().equals("vet"))) {

            throw new BLLException("Les rôles disponible pour un nouveau salarié sont : sec, vet ou adm.");
        }
    }

    private void verificationMotPasse(Personnel pers) throws BLLException {
        if (pers.getMotPasse() == null || pers.getMotPasse().trim().isEmpty()) {
            throw new BLLException("Le mot de passe est obligatoire");
        } else if (pers.getMotPasse().length() > 10) {
            throw new BLLException("Le mot de passe ne peut contenir que 10 caractères.");
        }
    }

}