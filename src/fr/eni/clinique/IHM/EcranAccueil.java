/*
 * Created by JFormDesigner on Thu Jun 28 10:59:55 CEST 2018
 */

package fr.eni.clinique.IHM;

import fr.eni.clinique.BLL.BLLException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        menuBar = new JMenuBar();
        menuFermer = new JMenu();
        Deconnexion = new JMenuItem();
        Fermer = new JMenuItem();
        menuRDV = new JMenu();
        PriseRDV = new JMenuItem();
        menuItem2 = new JMenuItem();
        Agenda = new JMenu();
        GestionPersonnel = new JMenu();
        ecranGestionPersonnel = new EcranGestionPersonnel();
        ajouterPersonnel = new AjouterPersonnel();
        reinitialiserMDP = new ReinitialiserMDP();
        supprimerPersonnel = new SupprimerPersonnel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== menuBar ========
        {

            //======== menuFermer ========
            {
                menuFermer.setText("Fichier");
                menuFermer.setPreferredSize(new Dimension(100, 21));

                //---- Deconnexion ----
                Deconnexion.setText("D\u00e9connexion");
                menuFermer.add(Deconnexion);
                actionBtnDeconnexion();
                //---- Fermer ----
                Fermer.setText("Fermer");
                menuFermer.add(Fermer);
            }
            menuBar.add(menuFermer);

            //======== menuRDV ========
            {
                menuRDV.setText("Gestion des rendez-vous");
                menuRDV.setPreferredSize(new Dimension(160, 21));

                //---- PriseRDV ----
                PriseRDV.setText("Prise de rendez-vous");
                menuRDV.add(PriseRDV);

                //---- menuItem2 ----
                menuItem2.setText("Gestion des clients");
                menuRDV.add(menuItem2);
            }
            menuBar.add(menuRDV);

            //======== Agenda ========
            {
                Agenda.setText("Agenda");
            }
            menuBar.add(Agenda);

            //======== GestionPersonnel ========
            {
                GestionPersonnel.setText("Gestion du personnel");
            }
            menuBar.add(GestionPersonnel);
        }
        setJMenuBar(menuBar);
        pack();
        setLocationRelativeTo(getOwner());

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnDeconnexion() {
        Deconnexion.addActionListener(new ActionListener() {

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JMenuBar menuBar;
    private JMenu menuFermer;
    private JMenuItem Deconnexion;
    private JMenuItem Fermer;
    private JMenu menuRDV;
    private JMenuItem PriseRDV;
    private JMenuItem menuItem2;
    private JMenu Agenda;
    private JMenu GestionPersonnel;
    private JPanel ecranGestionPersonnel;
    private JPanel ajouterPersonnel;
    private JPanel reinitialiserMDP;
    private JPanel supprimerPersonnel;
    private ConnexionController connexionController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
