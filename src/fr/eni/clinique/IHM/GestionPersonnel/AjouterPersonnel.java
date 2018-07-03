/*
 * Created by JFormDesigner on Fri Jun 29 10:49:04 CEST 2018
 */

package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.IHM.Connexion.ConnexionController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Mathieu BOURVIC
 */
public class AjouterPersonnel extends JDialog {
    public AjouterPersonnel() {
        initComponents();
    }
    public AjouterPersonnel(GestionPersonnelController gestionPersonnelController) {
        this.gestionPersonnelController = gestionPersonnelController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelNom = new JLabel();
        textboxNom = new JTextField();
        labelPrenom = new JLabel();
        textFieldPrenom = new JTextField();
        labelRole = new JLabel();
        comboboxRole = new JComboBox();
        labelMotPasse = new JLabel();
        passwordFieldMDP = new JPasswordField();
        buttonBar = new JPanel();
        boutonOK = new JButton();
        boutonAnnuler = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- labelNom ----
                labelNom.setText("Nom");

                //---- labelPrenom ----
                labelPrenom.setText("Pr\u00e9nom");

                //---- labelRole ----
                labelRole.setText("R\u00f4le");

                //---- labelMotPasse ----
                labelMotPasse.setText("Mot de passe");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(textboxNom, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(textFieldPrenom))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(labelRole, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(comboboxRole))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(labelMotPasse)
                                    .addGap(5, 5, 5)
                                    .addComponent(passwordFieldMDP))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textboxNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelRole, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboboxRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelMotPasse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordFieldMDP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
                    gestionPersonnelController.ajouterPersonnel(textboxNom,textFieldPrenom,comboboxRole, passwordFieldMDP);
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
    private JLabel labelNom;
    private JTextField textboxNom;
    private JLabel labelPrenom;
    private JTextField textFieldPrenom;
    private JLabel labelRole;
    private JComboBox comboboxRole;
    private JLabel labelMotPasse;
    private JPasswordField passwordFieldMDP;
    private JPanel buttonBar;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private GestionPersonnelController gestionPersonnelController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
