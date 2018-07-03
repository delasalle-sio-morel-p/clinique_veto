/*
 * Created by JFormDesigner on Fri Jun 29 10:29:00 CEST 2018
 */

package fr.eni.clinique.IHM.GestionPersonnel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 * @author Mathieu BOURVIC
 */
public class EcranGestionPersonnel extends JPanel {
    public EcranGestionPersonnel() {
        initComponents();
    }
    public EcranGestionPersonnel(GestionPersonnelController gestionPersonnelController) {
        this.gestionPersonnelController = gestionPersonnelController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        menuGestionPersonnel = new JToolBar();
        boutonAjouter = new JButton();
        separator1 = new JSeparator();
        boutonSupprimer = new JButton();
        separator2 = new JSeparator();
        boutonReinitialiserMDP = new JButton();
        scrollPane1 = new JScrollPane();
        modele = new TablePersonnelModel(gestionPersonnelController.getListePersonnels());
        tableauEmployes = new JTable(modele);

        //======== this ========

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== listener =======
        actionBtnAjouter();
        actionBtnSupprimer();
        actionBtnReinitialiserMDP();

        //======== menuGestionPersonnel ========
        {

            //---- boutonAjouter ----
            boutonAjouter.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add.png")));
            boutonAjouter.setText("Ajouter");
            menuGestionPersonnel.add(boutonAjouter);
            menuGestionPersonnel.addSeparator();
            menuGestionPersonnel.add(separator1);

            //---- boutonSupprimer ----
            boutonSupprimer.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete.png")));
            boutonSupprimer.setText("Supprimer");
            menuGestionPersonnel.add(boutonSupprimer);
            menuGestionPersonnel.add(separator2);
            menuGestionPersonnel.addSeparator();

            //---- boutonReinitialiserMDP ----
            boutonReinitialiserMDP.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/padlock.png")));
            boutonReinitialiserMDP.setText("R\u00e9inialiser MDP");
            menuGestionPersonnel.add(boutonReinitialiserMDP);
        }
        add(menuGestionPersonnel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableauEmployes);
        }
        add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnAjouter() {
        boutonAjouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionPersonnelController.ajouter();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnSupprimer() {
        boutonSupprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionPersonnelController.supprimer();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnReinitialiserMDP() {
        boutonReinitialiserMDP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionPersonnelController.reinitialiserMDP();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JToolBar menuGestionPersonnel;
    private JButton boutonAjouter;
    private JSeparator separator1;
    private JButton boutonSupprimer;
    private JSeparator separator2;
    private JButton boutonReinitialiserMDP;
    private JScrollPane scrollPane1;
    private JTable tableauEmployes;
    private GestionPersonnelController gestionPersonnelController;
    private TablePersonnelModel modele;
//    private GestionPersonnelController gestionPersonnelController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
