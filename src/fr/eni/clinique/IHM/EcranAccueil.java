/*
 * Created by JFormDesigner on Thu Jun 28 10:59:55 CEST 2018
 */

package fr.eni.clinique.IHM;

import java.awt.*;
import javax.swing.*;

/**
 * @author Mathieu BOURVIC
 */
public class EcranAccueil extends JFrame {
    public EcranAccueil() {
        this.setSize(500, 175);
        this.setTitle("Clinique vétérinaire");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        Menu = new JToolBar();
        Fichier = new JButton();
        GestionRDV = new JButton();
        Agenda = new JButton();
        GestionPersonnel = new JButton();
        vSpacer1 = new JPanel(null);
        vSpacer4 = new JPanel(null);
        vSpacer3 = new JPanel(null);
        vSpacer5 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        Connexion = new JToolBar(null, JToolBar.VERTICAL);
        Deconnexion = new JButton();
        vSpacer6 = new JPanel(null);
        Fermer = new JButton();
        Gestion = new JToolBar(null, JToolBar.VERTICAL);
        PriseRDV = new JButton();
        GestionClients = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== Menu ========
        {

            //---- Fichier ----
            Fichier.setText("Fichier");
            Menu.add(Fichier);

            //---- GestionRDV ----
            GestionRDV.setText("Gestion des rendez vous");
            Menu.add(GestionRDV);

            //---- Agenda ----
            Agenda.setText("Agenda");
            Menu.add(Agenda);

            //---- GestionPersonnel ----
            GestionPersonnel.setText("Gestion du personnel");
            Menu.add(GestionPersonnel);
        }
        contentPane.add(Menu, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(vSpacer1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(vSpacer4, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(vSpacer3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(vSpacer5, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(hSpacer1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== Connexion ========
        {

            //---- Deconnexion ----
            Deconnexion.setText("D\u00e9connexion");
            Connexion.add(Deconnexion);
            Connexion.add(vSpacer6);

            //---- Fermer ----
            Fermer.setText("Fermer");
            Connexion.add(Fermer);
        }
        contentPane.add(Connexion, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== Gestion ========
        {

            //---- PriseRDV ----
            PriseRDV.setText("Prise de rendez-vous");
            Gestion.add(PriseRDV);

            //---- GestionClients ----
            GestionClients.setText("Gestion des clients");
            Gestion.add(GestionClients);
        }
        contentPane.add(Gestion, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JToolBar Menu;
    private JButton Fichier;
    private JButton GestionRDV;
    private JButton Agenda;
    private JButton GestionPersonnel;
    private JPanel vSpacer1;
    private JPanel vSpacer4;
    private JPanel vSpacer3;
    private JPanel vSpacer5;
    private JPanel hSpacer1;
    private JToolBar Connexion;
    private JButton Deconnexion;
    private JPanel vSpacer6;
    private JButton Fermer;
    private JToolBar Gestion;
    private JButton PriseRDV;
    private JButton GestionClients;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
