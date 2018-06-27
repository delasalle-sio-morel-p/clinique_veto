package fr.eni.clinique.AppliTest.GestionPersonnel;

import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Veterinaire;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.PersonnelDAO;

public class AppliTestDALGestionPersonnel {

    public static void main(String[] args) {
        PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();

        Personnel v1 = new Veterinaire("Gérard Boulier", "mdp", "vet", false);

        System.out.println("Ajout d'un veto : ");

        try{
            Personnel v = personnelDAO.selectById(1);
            System.out.println("Veto trouvé : " + v.getNom());
           // personnelDAO.insert(v1);
//            System.out.println("Veto ajouté dans la base : " + v1.getNom());

        }
        catch(DALException e)
        {
            e.printStackTrace();
        }
    }
}
