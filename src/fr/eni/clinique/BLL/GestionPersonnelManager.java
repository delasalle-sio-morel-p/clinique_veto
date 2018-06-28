package fr.eni.clinique.BLL;

import java.util.ArrayList;
import java.util.List;


import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Veterinaire;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.PersonnelDAO;

public class GestionPersonnelManager {

    private PersonnelDAO daoPersonnels;
    private List<Personnel> listePersonnels;
    private static GestionPersonnelManager instance = null;

    private GestionPersonnelManager() throws BLLException {
        daoPersonnels = DAOFactory.getPersonnelDAO();
        // Charger la liste de personnels
        try {
            listePersonnels = daoPersonnels.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des personnels - ", e);
        }
    }

    public static GestionPersonnelManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new GestionPersonnelManager();
        }
        return instance;
    }

    public Personnel getPersonnel(int codePers) throws BLLException {

        return listePersonnels.get(codePers);
    }

    public List<Personnel> getListePersonnels() throws BLLException {
        return listePersonnels;
    }

    public void addPersonnel(Personnel personnel) throws BLLException {

        validerPersonnel(personnel);

        try {
            daoPersonnels.insert(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion en BDD du personnel.");
        }

    }

    public void updatePersonnel(Personnel personnel) throws BLLException {

        validerPersonnel(personnel);

        try {
            daoPersonnels.update(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de la mise à jour en BDD du personnel.");
        }


    }

    public List<Veterinaire> getListeVeto() throws BLLException {
        List<Veterinaire> listeVeterinaires = new ArrayList<>();
        List<Personnel> listePersonnels = getListePersonnels();

        for (Personnel personnel : listePersonnels) {
            if (personnel instanceof Veterinaire) {
                listeVeterinaires.add((Veterinaire) personnel);
            }
        }
        return listeVeterinaires;

    }

    private void validerPersonnel(Personnel pers) throws BLLException {

        verificationNomPersonnel(pers);

        verificationMotPasse(pers);

        verificationRole(pers);

    }

    private void verificationNomPersonnel(Personnel personnel) throws BLLException {
        if (personnel.getNom() == null || personnel.getNom().trim().isEmpty()) {
            throw new BLLException("Le nom est obligatoire");
        } else if (personnel.getNom().length() > 30) {
            throw new BLLException("Le nom ne doit pas dépasser 30 caractères.");
        }
    }

    private void verificationRole(Personnel personnel) throws BLLException {
        if (personnel.getRole() == null || personnel.getRole().trim().isEmpty()) {
            throw new BLLException("Il est obligatoire d'attribuer un rôle au nouveau salarié : sec, vet ou adm.");
        } else if (!(personnel.getRole().equals("sec") || personnel.getRole().equals("adm") || personnel.getRole().equals("vet"))) {

            throw new BLLException("Les rôles disponible pour un nouveau salarié sont : sec, vet ou adm.");
        }
    }

    private void verificationMotPasse(Personnel personnel) throws BLLException {
        if (personnel.getMotPasse() == null || personnel.getMotPasse().trim().isEmpty()) {
            throw new BLLException("Le mot de passe est obligatoire");
        } else if (personnel.getMotPasse().length() > 10) {
            throw new BLLException("Le mot de passe ne peut contenir que 10 caractères.");
        }
    }

}