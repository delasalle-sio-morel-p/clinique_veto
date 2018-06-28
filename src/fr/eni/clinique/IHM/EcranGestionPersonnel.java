/*
 * Created by JFormDesigner on Thu Jun 28 09:25:55 CEST 2018
 */

package fr.eni.clinique.IHM;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class EcranGestionPersonnel extends JFrame {
    public EcranGestionPersonnel() {
        this.setSize(500, 175);
        this.setTitle("Gestion du personnel");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        controleBarListeEmployes = new JPanel();
        Ajouter = new JButton();
        Supprimer = new JButton();
        Réinitialiser = new JButton();
        scrollBarListeEmployes = new JScrollPane();
        ListeEmployes = new JList();

        //======== this ========

        // JFormDesigner evaluation mark
//        setBorder(new javax.swing.border.CompoundBorder(
//            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== controleBarListeEmployes ========
        {
            controleBarListeEmployes.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]"));

            //---- Ajouter ----
            Ajouter.setText("Ajouter");
            controleBarListeEmployes.add(Ajouter, "cell 1 0");

            //---- Supprimer ----
            Supprimer.setText("Supprimer");
            controleBarListeEmployes.add(Supprimer, "cell 5 0");

            //---- Réinitialiser ----
            Réinitialiser.setText("R\u00e9inistialiser");
            controleBarListeEmployes.add(Réinitialiser, "cell 10 0");
        }
        add(controleBarListeEmployes, "cell 1 1");

        //======== scrollBarListeEmployes ========
        {
            scrollBarListeEmployes.setViewportView(ListeEmployes);
        }
        add(scrollBarListeEmployes, "cell 1 3 1 2");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JPanel controleBarListeEmployes;
    private JButton Ajouter;
    private JButton Supprimer;
    private JButton Réinitialiser;
    private JScrollPane scrollBarListeEmployes;
    private JList ListeEmployes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
