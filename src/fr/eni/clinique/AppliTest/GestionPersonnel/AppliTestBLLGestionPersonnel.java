package fr.eni.clinique.AppliTest.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnelManager;
import fr.eni.clinique.BO.Admin;
import fr.eni.clinique.BO.Personnel;
import fr.eni.clinique.BO.Secretaire;
import fr.eni.clinique.BO.Veterinaire;

public class AppliTestBLLGestionPersonnel {

    public static void main(String[] args) throws BLLException {
        //Instanciation du jeu d'essai
        Personnel a1 = new Admin("test","42", "ironman", "adm", false);
        Personnel s1 = new Secretaire("LEWINSKY", "Monica", "test", "sec", false);
        Personnel v1 = new Veterinaire("BARLERIN", "Laetitia", "test", "vet", false);


        GestionPersonnelManager manager;
        try {
            manager = GestionPersonnelManager.getInstance();
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
            ((Admin) a1).setNom("JARVIS");
            ((Admin) a1).setPrenom("Edwin");
            ((Admin) a1).setMotPasse("ironman");
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
