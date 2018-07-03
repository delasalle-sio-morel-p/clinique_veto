/*
 * Created by JFormDesigner on Fri Jun 29 11:17:42 CEST 2018
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
public class SupprimerPersonnel extends JDialog {
    public SupprimerPersonnel() {
        initComponents();
    }

    public SupprimerPersonnel(Frame owner, GestionPersonnelController gestionPersonnelController) {
        super(owner);
        this.gestionPersonnelController = gestionPersonnelController;
        initComponents();
    }

    public SupprimerPersonnel(Frame owner, JPanel contentPanel, GestionPersonnelController gestionPersonnelController) {
        super(owner);
        this.contentPanel = contentPanel;
        this.gestionPersonnelController = gestionPersonnelController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        boutonOk = new JButton();
        boutonAnnuler = new JButton();
        contentPanel = new JPanel();
        LblSupprimer = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== listener =======
        actionBtnAnnuler();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- boutonOk ----
                boutonOk.setText("OK");
                buttonBar.add(boutonOk, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- boutonAnnuler ----
                boutonAnnuler.setText("Annuler");
                buttonBar.add(boutonAnnuler, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== contentPanel ========
            {

                //---- LblSupprimer ----
                LblSupprimer.setText("\u00cates-vous s\u00fbr de vouloir supprimer cet utilisateur ?");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(LblSupprimer)
                            .addContainerGap(79, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(57, Short.MAX_VALUE)
                            .addComponent(LblSupprimer)
                            .addGap(18, 18, 18))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    private JPanel buttonBar;
    private JButton boutonOk;
    private JButton boutonAnnuler;
    private JPanel contentPanel;
    private JLabel LblSupprimer;
    private GestionPersonnelController gestionPersonnelController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
