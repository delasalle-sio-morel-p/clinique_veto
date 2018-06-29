/*
 * Created by JFormDesigner on Fri Jun 29 10:29:00 CEST 2018
 */

package fr.eni.clinique.IHM;

import java.awt.*;
import javax.swing.*;

/**
 * @author Mathieu BOURVIC
 */
public class EcranGestionPersonnel extends JPanel {
    public EcranGestionPersonnel() {
        initComponents();
    }
    public EcranGestionPersonnel(ConnexionController connexionController) {
        this.connexionController = connexionController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        menuGestionPersonnel = new JToolBar();
        Ajouter = new JButton();
        separator1 = new JSeparator();
        Supprimer = new JButton();
        separator2 = new JSeparator();
        ReinitialiserMDP = new JButton();
        scrollPane1 = new JScrollPane();
        ListeEmployes = new JTable();

        //======== this ========

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== menuGestionPersonnel ========
        {

            //---- Ajouter ----
            Ajouter.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add.png")));
            Ajouter.setText("Ajouter");
            menuGestionPersonnel.add(Ajouter);
            menuGestionPersonnel.addSeparator();
            menuGestionPersonnel.add(separator1);

            //---- Supprimer ----
            Supprimer.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete.png")));
            Supprimer.setText("Supprimer");
            menuGestionPersonnel.add(Supprimer);
            menuGestionPersonnel.add(separator2);
            menuGestionPersonnel.addSeparator();

            //---- ReinitialiserMDP ----
            ReinitialiserMDP.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/padlock.png")));
            ReinitialiserMDP.setText("R\u00e9inialiser MDP");
            menuGestionPersonnel.add(ReinitialiserMDP);
        }
        add(menuGestionPersonnel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(ListeEmployes);
        }
        add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JToolBar menuGestionPersonnel;
    private JButton Ajouter;
    private JSeparator separator1;
    private JButton Supprimer;
    private JSeparator separator2;
    private JButton ReinitialiserMDP;
    private JScrollPane scrollPane1;
    private JTable ListeEmployes;
    private ConnexionController connexionController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
