package fr.eni.clinique.AppliTest.GestionPersonnel;

import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Veterinaire;
import fr.eni.clinique.DAL.DALException;
import fr.eni.clinique.DAL.DAOFactory;
import fr.eni.clinique.DAL.PersonnelDAO;

import java.util.List;

public class AppliTestDALGestionPersonnel {

    public static void main(String[] args) {
        PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();

        Personnel v1 = new Veterinaire("AIMONE", "Anne", "mdp", "vet", false);
        Personnel v2 = new Veterinaire(5, "Le","CONNARD", "fdp", "vet", false);

        try{
            Personnel v = personnelDAO.selectById(1);
            System.out.println("Personne trouvée : " + v.getNom());
//            personnelDAO.insert(v2);
//            System.out.println("Veto ajouté dans la base : " + v2.getNom());

            List<Personnel> listPersonne = personnelDAO.selectAll();
            System.out.println("Personne présente dans la base : " );
            for (Personnel personne :listPersonne) {
                System.out.println("- " + personne.getNom());
            }

            v2.setNom("TOURNE");
            v2.setPrenom("Sylvain");
            personnelDAO.update(v2);
            System.out.println(v2.getCodePersonnel());
            System.out.println("Personne mise à jour -> nom : "  + v2.getNom());
//@Patrick
//            personnelDAO.delete(v2);
//            System.out.println("Veto suppr de la base : " + v2.getNom());

        }
        catch(DALException e)
        {
            e.printStackTrace();
        }
    }
}
