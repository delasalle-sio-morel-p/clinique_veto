/*
 * Created by JFormDesigner on Thu Jun 28 10:59:55 CEST 2018
 */

package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.IHM.Connexion.ConnexionController;
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
    public EcranAccueil(GestionPersonnelController gestionPersonnelController) {
        this.gestionPersonnelController = gestionPersonnelController;
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
        menuItem2 = new JMenuItem();
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
        actionMenuGestionPersonnel();

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
                menuItem2.setText("Gestion des clients");
                menuRDV.add(menuItem2);
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
                    connexionController.deconnexion();
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
                    gestionPersonnelController.affichageEcranGestionPersonnel();
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JMenuBar menuBar;
    private JMenu menuFermer;
    private JMenuItem menuItemDeconnexion;
    private JMenuItem menuItemfermer;
    private JMenu menuRDV;
    private JMenuItem menuItemPriseRDV;
    private JMenuItem menuItem2;
    private JMenu menuAgenda;
    private JMenu menuGestionPersonnel;
    private ConnexionController connexionController;
    private GestionPersonnelController gestionPersonnelController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}