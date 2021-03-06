package fr.eni.clinique.AppliTest.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnel.PersonnelManager;
import fr.eni.clinique.BO.Admin;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Secretaire;
import fr.eni.clinique.BO.Veterinaire;

public class AppliTestBLLGestionPersonnel {

    public static void main(String[] args) throws BLLException {
        //Instanciation du jeu d'essai
        Personnel a1 = new Admin("test","42", "toto", "adm", false);
        Personnel s1 = new Secretaire("DE JEU", "Odette", "test", "sec", false);
        Personnel v1 = new Veterinaire("MALALANICH", "Melanie", "test", "vet", false);


        PersonnelManager manager;
        try {
            manager = PersonnelManager.getInstance();
        } catch (BLLException e1) {
            e1.printStackTrace();
            return;
        }

        //Ajout d'un membre personnel à la liste
        try {
            manager.addPersonnel(a1);

            manager.addPersonnel(s1);

            manager.addPersonnel(v1);

        } catch (BLLException e) {
            e.printStackTrace();
        }
        System.out.println(manager.getListePersonnels());

        //Modification d'un article
        try {
            ((Admin) a1).setNom("BOSAPIN");
            ((Admin) a1).setPrenom("Edmond");
            ((Admin) a1).setMotPasse("test");
            manager.updatePersonnel(a1);
            System.out.println("Membre du Personnel après modification  : " + a1.toString() );
        } catch (BLLException e) {
            e.printStackTrace();
        }

        //Suppression d'un membre du personnel
//        try {
//            manager.removePersonnel(0);
//            System.out.println(manager.getListePersonnels());
//        } catch (BLLException e) {
//            e.printStackTrace();
//        }
    }

}
