/*
 * Created by JFormDesigner on Thu Jun 28 10:59:55 CEST 2018
 */

package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.IHM.GestionClient.GestionClientController;
import fr.eni.clinique.IHM.GestionPersonnel.GestionPersonnelController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * @author Mathieu BOURVIC
 */
public class EcranAccueil extends JFrame {
    public EcranAccueil() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }
    public EcranAccueil(ConnexionController connexionController) {
        this.connexionController = connexionController;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }
    public EcranAccueil(AccueilController accueilController) {
        this.accueilController = accueilController;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }
    public EcranAccueil(GestionPersonnelController gestionPersonnelController) {
        this.gestionPersonnelController = gestionPersonnelController;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }

    public EcranAccueil(GestionClientController gestionClientController) {
        this.gestionClientController = gestionClientController;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        menuBar = new JMenuBar();
        menuFermer = new JMenu();
        menuItemDeconnexion = new JMenuItem();
        menuItemfermer = new JMenuItem();
        menuRDV = new JMenu();
        menuItemPriseRDV = new JMenuItem();
        menuItemClient = new JMenuItem();
        menuAgenda = new JMenu();
        menuGestionPersonnel = new JMenu();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== listener =======
        actionBtnDeconnexion();
        actionBtnFermer();
        actionMenuGestionPersonnel();
        actionMenuClient();

        //======== menuBar ========
        {

            //======== menuFermer ========
            {
                menuFermer.setText("Fichier");
                menuFermer.setPreferredSize(new Dimension(100, 21));

                //---- Deconnexion ----
                menuItemDeconnexion.setText("D\u00e9connexion");
                menuFermer.add(menuItemDeconnexion);

                //---- Fermer ----
                menuItemfermer.setText("Fermer");
                menuFermer.add(menuItemfermer);
            }
            menuBar.add(menuFermer);

            //======== menuRDV ========
            {
                menuRDV.setText("Gestion des rendez-vous");
                menuRDV.setPreferredSize(new Dimension(160, 21));

                //---- PriseRDV ----
                menuItemPriseRDV.setText("Prise de rendez-vous");
                menuRDV.add(menuItemPriseRDV);

                //---- menuItem2 ----
                menuItemClient.setText("Gestion des clients");
                menuRDV.add(menuItemClient);
            }
            menuBar.add(menuRDV);

            //======== Agenda ========
            {
                menuAgenda.setText("Agenda");
            }
            menuBar.add(menuAgenda);

            //======== GestionPersonnel ========
            {
                menuGestionPersonnel.setText("Gestion du personnel");
            }
            menuBar.add(menuGestionPersonnel);
        }
        setJMenuBar(menuBar);
        pack();
        setLocationRelativeTo(getOwner());

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnDeconnexion() {
        menuItemDeconnexion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    accueilController.deconnexion();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnFermer(){
        menuItemfermer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    accueilController.fermerApplication();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionMenuGestionPersonnel() {
        menuGestionPersonnel.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                try {
                    System.out.println("menuSelected");
                    accueilController.callEcranGestionPersonnel();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                try {
                    System.out.println("menuDeselected");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");
            }
        });
    }

    private void actionMenuClient() {
        menuItemClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    accueilController.callEcranGestionClient();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }






    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JMenuBar menuBar;
    private JMenu menuFermer;
    private JMenuItem menuItemDeconnexion;
    private JMenuItem menuItemfermer;
    private JMenu menuRDV;
    private JMenuItem menuItemPriseRDV;
    private JMenuItem menuItemClient;
    private JMenu menuAgenda;
    private JMenu menuGestionPersonnel;
    private ConnexionController connexionController;
    private AccueilController accueilController;
    private GestionPersonnelController gestionPersonnelController;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
