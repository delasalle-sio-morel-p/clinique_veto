/*
 * Created by JFormDesigner on Wed Jul 04 13:41:01 CEST 2018
 */

package fr.eni.clinique.IHM.Animaux;

import fr.eni.clinique.IHM.GestionClient.GestionClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Mathieu BOURVIC
 */
public class SupprimerAnimal extends JDialog {
    public SupprimerAnimal(Frame owner) {
        super(owner);
        initComponents();
    }
    public SupprimerAnimal(Frame owner, JTable tableAnimaux, GestionClientController gestionClientController) {
        super(owner);
        this.gestionClientController = gestionClientController;
        this.tableAnimaux = tableAnimaux;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelSupprimerAnimal = new JLabel();
        panelButtonBar = new JPanel();
        boutonOK = new JButton();
        boutonAnnuler = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== listener =======
        actionBtnOK();
        actionBtnAnnuler();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- labelSupprimerAnimal ----
                labelSupprimerAnimal.setText("\u00cates-vous s\u00fbr de vouloir supprimer cet animal ?");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(labelSupprimerAnimal, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(29, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(35, Short.MAX_VALUE)
                            .addComponent(labelSupprimerAnimal)
                            .addGap(34, 34, 34))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                panelButtonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                panelButtonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)panelButtonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)panelButtonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                boutonOK.setText("OK");
                panelButtonBar.add(boutonOK, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                boutonAnnuler.setText("Cancel");
                panelButtonBar.add(boutonAnnuler, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(panelButtonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnOK() {
        boutonOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.supprimerAnimal(tableAnimaux);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnAnnuler() {
        boutonAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.annuler();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel labelSupprimerAnimal;
    private JPanel panelButtonBar;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private JTable tableAnimaux;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
