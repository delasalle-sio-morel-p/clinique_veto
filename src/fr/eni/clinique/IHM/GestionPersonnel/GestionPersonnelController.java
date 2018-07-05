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

    private boolean isPresent;
    private Personnel personneSelectionne;
    private TablePersonnelModel modele;


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

    public void afficherAjouterPersonnel(JTable tablePersonnels) {
        System.out.println("ajouter");
        ajouterPersonnel = new AjouterPersonnel(AccueilController.get().getEcranAccueil(), tablePersonnels, this);
        ajouterPersonnel.setVisible(true);
    }

    public void afficherSupprimerPersonnel(JTable tablePersonnels) {
        System.out.println("supprimer");
        supprimerPersonnel = new SupprimerPersonnel(AccueilController.get().getEcranAccueil(), tablePersonnels, this);
        supprimerPersonnel.setVisible(true);
    }

    public void afficherReinitialiserMDPPersonnel(JTable tablePersonnels) {
        System.out.println("reinitialiserMDP");
        reinitialiserMDP = new ReinitialiserMDP(AccueilController.get().getEcranAccueil(), tablePersonnels, this);
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

    public void ajouterPersonnel(JTable tablePersonnels, JTextField textboxNom, JTextField textFieldPrenom, JComboBox comboboxRole, JPasswordField passwordFieldMDP) {
        System.out.println("ajouterPersonnel");
        System.out.println(textboxNom.getText());
        System.out.println(textFieldPrenom.getText());
        System.out.println(comboboxRole.getSelectedItem());
        System.out.println(passwordFieldMDP.getText());
        Role role = (Role) comboboxRole.getSelectedItem();
        Personnel personneAjoute = null;

        switch (role.getLibelle()) {
            case "Administrateur":
                personneAjoute = new Admin(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(), "adm", false);
                break;
            case "Secrétaire":
                personneAjoute = new Secretaire(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(), "sec", false);
                break;
            default:
                personneAjoute = new Veterinaire(textboxNom.getText(), textFieldPrenom.getText(), passwordFieldMDP.getText(), "vet", false);
                break;
        }

        try {
            manager.addPersonnel(personneAjoute);
            System.out.println(personneAjoute + " ajouté à la base de donnée");
            ajouterPersonnel.setVisible(false);
            refreshTable(tablePersonnels);
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerPersonnel(JTable tablePersonnels) {
        int ligneSelectionne = tablePersonnels.getSelectedRow();
        if (ligneSelectionne != -1) {
            String nomSelectionne = (String) tablePersonnels.getValueAt(ligneSelectionne, 0);
            System.out.println(tablePersonnels.getValueAt(ligneSelectionne, 0));
            personneSelectionne = personneSelectionne(nomSelectionne);
            try {
                manager.deletePersonnel(personneSelectionne);
                System.out.println(personneSelectionne + " archivé");
                supprimerPersonnel.setVisible(false);
                refreshTable(tablePersonnels);
            } catch (BLLException e) {
                e.printStackTrace();
            }
        } else
            System.out.print("Pas de ligne sélectionnée");
    }

    public void reinitialiseMDPPersonnel(JTable tablePersonnels, String nouveauMDP) {
        int ligneSelectionne = tablePersonnels.getSelectedRow();
        if (ligneSelectionne != -1) {
            String nomSelectionne = (String) tablePersonnels.getValueAt(ligneSelectionne, 0);
            System.out.println(nomSelectionne);
            personneSelectionne = personneSelectionne(nomSelectionne);
            if (nouveauMDP != null) {
                personneSelectionne.setMotPasse(nouveauMDP);
                try {
                    manager.updatePersonnel(personneSelectionne);
                    System.out.println("Le mot de passe de " + personneSelectionne + " a été changé");
                    reinitialiserMDP.setVisible(false);
                    refreshTable(tablePersonnels);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else
                System.out.print("Pas de mot de passe");
        } else
            System.out.print("Pas de ligne sélectionnée");
    }

    public Personnel personneSelectionne(String nom) {
        isPresent = false;
        for (Personnel personne : listePersonnels) {

            if (personne.getNom().equals(nom)) {
                isPresent = true;
                personneSelectionne = personne;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Personne présente en base de donnée :");
            System.out.println(personneSelectionne);
            return personneSelectionne;
        } else
            System.out.println("Personne non présente en base de donnée");
        return null;
    }

    public void refreshTable(JTable table){
        System.out.println(getListePersonnels());
        System.out.println(listePersonnels);
        modele = new TablePersonnelModel(getListePersonnels());
        table.setModel(modele);
        modele.fireTableDataChanged();
    }
}