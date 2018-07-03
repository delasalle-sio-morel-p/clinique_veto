package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnel.GestionPersonnelManager;
import fr.eni.clinique.BO.*;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;
import java.util.List;

public class GestionPersonnelController {
    private EcranAccueil ecranAccueil;
    private EcranGestionPersonnel ecranGestionPersonnel;
    private AjouterPersonnel ajouterPersonnel;

    private GestionPersonnelManager manager;

    private List<Personnel> listePersonnels;
    private List<Role> listRolesPersonnels;

    private static GestionPersonnelController instance;


    //Constructeur
    private GestionPersonnelController() {
        try {
            manager = GestionPersonnelManager.getInstance();

            //Initialisation du catalogue en mémoire
            listePersonnels = manager.getListePersonnels();
            listRolesPersonnels = manager.getListeRolesPersonnels();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public List<Personnel> getListePersonnels() {
        return listePersonnels;
    }

    public List<Role> getListeRolesPersonnels() {
        return listRolesPersonnels;
    }

    //Méthodes
    public static synchronized GestionPersonnelController get() {
        if (instance == null) {
            instance = new GestionPersonnelController();
        }
        return instance;
    }

    public void affichageEcranAccueil() {
        ecranAccueil = new EcranAccueil(this);
        ecranAccueil.setVisible(true);
    }

    public void affichageEcranGestionPersonnel() {
        if (ecranGestionPersonnel == null)
            ecranGestionPersonnel = new EcranGestionPersonnel(this);
        ecranAccueil.add(ecranGestionPersonnel);
        System.out.println(listRolesPersonnels);
        ecranAccueil.revalidate();
    }

    public void ajouter() {
        System.out.println("ajouter");
        ajouterPersonnel = new AjouterPersonnel(this);
        ecranAccueil.add(ajouterPersonnel);

        ecranAccueil.revalidate();
    }

    public void ajouterPersonnel(JTextField textboxNom, JTextField textFieldPrenom, JComboBox comboboxRole, JPasswordField passwordFieldMDP) {
        System.out.println("ajouterPersonnel");
        System.out.println(textboxNom.getText());
        System.out.println(textFieldPrenom.getText());
        System.out.println(comboboxRole.getSelectedItem());
        System.out.println(passwordFieldMDP.getText());
        Role role = (Role) comboboxRole.getSelectedItem();
        Personnel personne = null;

        switch (role.getLibelle()) {
            case "Administrateur":
                personne = new Admin(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(),"adm", false);
                break;
            case "Secrétaire":
                personne = new Secretaire(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(),"sec", false);
                break;
            default:
                personne = new Veterinaire(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(),"vet", false);
                break;
        }

//        try {
//            manager.addPersonnel(personne);
//
//        } catch (BLLException e) {
//            e.printStackTrace();
//        }

        ecranAccueil.remove(ajouterPersonnel);
        ecranAccueil.remove(ecranGestionPersonnel);
        ecranAccueil.add(ecranGestionPersonnel);

        ecranAccueil.revalidate();

    }
}