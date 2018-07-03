/*
 * Created by JFormDesigner on Fri Jun 29 11:11:02 CEST 2018
 */

package fr.eni.clinique.IHM.GestionPersonnel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Mathieu BOURVIC
 */
public class ReinitialiserMDP extends JDialog {
    public ReinitialiserMDP() {
        initComponents();
    }

    public ReinitialiserMDP(Frame owner, GestionPersonnelController gestionPersonnelController) {
        super(owner);
        this.gestionPersonnelController = gestionPersonnelController;
        initComponents();
    }
    public ReinitialiserMDP(Frame owner, JTable tablePersonnels, GestionPersonnelController gestionPersonnelController) {
        super(owner);
        this.gestionPersonnelController = gestionPersonnelController;
        this.table = tablePersonnels;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelNouveauMDP = new JLabel();
        textboxNouveauMDP = new JTextField();
        buttonBar = new JPanel();
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

                //---- LabelNouveauMDP ----
                labelNouveauMDP.setText("Nouveau mot de passe : ");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(labelNouveauMDP)
                            .addGap(5, 5, 5)
                            .addComponent(textboxNouveauMDP, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelNouveauMDP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textboxNouveauMDP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- boutonOK ----
                boutonOK.setText("OK");
                buttonBar.add(boutonOK, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- boutonAnnuler ----
                boutonAnnuler.setText("Annuler");
                buttonBar.add(boutonAnnuler, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
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
                    gestionPersonnelController.reinitialiseMDPPersonnel(table, textboxNouveauMDP.getText());

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
                    gestionPersonnelController.annuler();
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
    private JLabel labelNouveauMDP;
    private JTextField textboxNouveauMDP;
    private JPanel buttonBar;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private JTable table;
    private GestionPersonnelController gestionPersonnelController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
