package fr.eni.clinique.BLL.GestionPersonnel;

import java.util.ArrayList;
import java.util.List;


import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Role;
import fr.eni.clinique.BO.Veterinaire;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.PersonnelDAO;
import fr.eni.clinique.DAL.RoleDAO;

public class PersonnelManager {

    private PersonnelDAO daoPersonnels;
    private RoleDAO daoRoles;
    private List<Personnel> listePersonnels;
    private List<Role> listeRolesPersonnels;
    private static PersonnelManager instance = null;

    private PersonnelManager() throws BLLException {
        daoPersonnels = DAOFactory.getPersonnelDAO();
        daoRoles = DAOFactory.getRoleDAO();
        // Charger la liste de personnels
        try {
            listePersonnels = daoPersonnels.selectAll();
            listeRolesPersonnels = daoRoles.selectAll();
        } catch (DALException e) {
            throw new BLLException("Echec du chargement de la liste des personnels - ", e);
        }
    }

    public static PersonnelManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new PersonnelManager();
        }
        return instance;
    }

    public Personnel getPersonnel(int codePers) throws BLLException {

        return listePersonnels.get(codePers);
    }

    public List<Personnel> getListePersonnels() throws BLLException {
        return listePersonnels;
    }

    public List<Role> getListeRolesPersonnels() throws BLLException {
        return listeRolesPersonnels;
    }

    public void addPersonnel(Personnel personnel) throws BLLException {

        validerPersonnel(personnel);

        try {
            personnel.setNom(personnel.getNom().toUpperCase());
            daoPersonnels.insert(personnel);
            listePersonnels.add(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion en BDD du personnel.");
        }

    }

    public void updatePersonnel(Personnel personnel) throws BLLException {

        validerPersonnel(personnel);

        try {
            personnel.setNom(personnel.getNom().toUpperCase());
            daoPersonnels.update(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de la mise à jour en BDD du personnel.");
        }


    }
    public void deletePersonnel(Personnel personnel) throws BLLException {

        validerPersonnel(personnel);

        try {
            daoPersonnels.delete(personnel);
            listePersonnels.remove(personnel);
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'archivage en BDD du personnel.");
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