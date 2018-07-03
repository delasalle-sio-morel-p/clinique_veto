package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.BLL.BLLException;
import fr.eni.clinique.BLL.GestionPersonnel.GestionPersonnelManager;
import fr.eni.clinique.BO.*;
import fr.eni.clinique.IHM.Connexion.AccueilController;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;
import java.util.List;

public class GestionPersonnelController {
    private EcranAccueil ecranAccueil;
    private EcranGestionPersonnel ecranGestionPersonnel;
    private AjouterPersonnel ajouterPersonnel;
    private SupprimerPersonnel supprimerPersonnel;
    private ReinitialiserMDP reinitialiserMDP;

    private GestionPersonnelManager manager;

    private List<Personnel> listePersonnels;
    private List<Role> listeRolesPersonnels;

    private static GestionPersonnelController instance;


    //Constructeur
    private GestionPersonnelController() {
        try {
            manager = GestionPersonnelManager.getInstance();

            //Initialisation du catalogue en mémoire
            listePersonnels = manager.getListePersonnels();
            listeRolesPersonnels = manager.getListeRolesPersonnels();

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public List<Personnel> getListePersonnels() {
        return listePersonnels;
    }

    public List<Role> getListeRolesPersonnels() {
        return listeRolesPersonnels;
    }

    //Méthodes
    public static synchronized GestionPersonnelController get() {
        if (instance == null) {
            instance = new GestionPersonnelController();
        }
        return instance;
    }

    public EcranGestionPersonnel affichageEcranGestionPersonnel() {
        if (ecranGestionPersonnel == null)
            ecranGestionPersonnel = new EcranGestionPersonnel(this);
        return ecranGestionPersonnel;
    }

    public void ajouter() {
        System.out.println("ajouter");
        ajouterPersonnel = new AjouterPersonnel(AccueilController.get().getEcranAccueil(),this);
        ajouterPersonnel.setVisible(true);
    }
    public void supprimer() {
        System.out.println("supprimer");
        supprimerPersonnel = new SupprimerPersonnel(AccueilController.get().getEcranAccueil(),this);
        supprimerPersonnel.setVisible(true);
    }

    public void reinitialiserMDP() {
        System.out.println("reinitialiserMDP");
        reinitialiserMDP = new ReinitialiserMDP(AccueilController.get().getEcranAccueil(),this);
        reinitialiserMDP.setVisible(true);
    }
    public void annuler() {
        if (ajouterPersonnel != null)
            ajouterPersonnel.setVisible(false);
        if (supprimerPersonnel != null)
            supprimerPersonnel.setVisible(false);
        if (reinitialiserMDP != null)
            reinitialiserMDP.setVisible(false);
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

        try {
            manager.addPersonnel(personne);
            ajouterPersonnel.setVisible(false);

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }
}