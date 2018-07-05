package fr.eni.clinique.AppliTest.GestionClient;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionClient.ClientManager;
import fr.eni.clinique.BO.*;

import java.util.ArrayList;
import java.util.List;

public class AppliTestBLLGestionClient {

    public static void main(String[] args) throws BLLException {
        //Instanciation du jeu d'essai
        List<Animal> listeAnimaux = new ArrayList<>();
        Client c1 = new Client("Lampion", "Gérard", "21 rue de la paix",
                "", "35000", "Rennes", "0235353535", "", "test@mail.fr", false, listeAnimaux);
        Client c2 = new Client("Lenclume", "Robert", "12 boulevard de la résistance",
                "", "1000", "Bourg-en-brès", "0310101010", "", "test@mail.fr", false, listeAnimaux);


        ClientManager manager;
        try {
            manager = ClientManager.getInstance();
        } catch (BLLException e1) {
            e1.printStackTrace();
            return;
        }

        //Ajout d'un membre personnel à la liste
        try {
            manager.addClient(c1);

            manager.addClient(c2);

        } catch (BLLException e) {
            e.printStackTrace();
        }
        System.out.println(manager.getListeClients());

        //Modification d'un article
        try {
            c1.setNomClient("BOSAPIN");
            c1.setPrenomClient("Edmond");
            manager.updateClient(c1);
            System.out.println("Membre du Personnel après modification  : " + c1.toString());
        } catch (BLLException e) {
            e.printStackTrace();
        }

        //Suppression d'un article
//        try {
//
//            System.out.println("Membre du Personnel après modification  : " + c1.toString());
//        } catch (BLLException e) {
//            e.printStackTrace();
//        }
    }
}
