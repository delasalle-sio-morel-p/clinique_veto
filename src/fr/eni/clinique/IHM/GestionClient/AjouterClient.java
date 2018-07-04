/*
 * Created by JFormDesigner on Mon Jul 02 15:00:15 CEST 2018
 */

package fr.eni.clinique.IHM.GestionClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Mathieu BOURVIC
 */
public class AjouterClient extends JDialog {
    public AjouterClient(Frame owner) {
        super(owner);
        initComponents();
    }

    public AjouterClient(Frame owner, GestionClientController gestionClientController) {
        super(owner);
        this.gestionClientController = gestionClientController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelNom = new JLabel();
        labelPrénom = new JLabel();
        labelAdresse = new JLabel();
        labelCodePostal = new JLabel();
        Ville = new JLabel();
        buttonBar = new JPanel();
        boutonOK = new JButton();
        boutonAnnuler = new JButton();
        labelTelephone = new JLabel();
        labelAssurance = new JLabel();
        labelMail = new JLabel();
        textFieldNom = new JTextField();
        textFieldPrenom = new JTextField();
        textFieldAdresse1 = new JTextField();
        textFieldAdresse2 = new JTextField();
        textFieldCodePostal = new JTextField();
        textFieldVille = new JTextField();
        textFieldNumTel = new JTextField();
        textFieldAssurance = new JTextField();
        textFieldEmail = new JTextField();

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

                //---- labelPrénom ----
                labelPrénom.setText("Pr\u00e9nom");

                //---- labelAdresse ----
                labelAdresse.setText("Adresse");

                //---- labelCodePostal ----
                labelCodePostal.setText("Code Postal");

                //---- Ville ----
                Ville.setText("Ville");

                //======== buttonBar ========
                {
                    buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                    buttonBar.setLayout(new GridBagLayout());
                    ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                    ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                    //---- boutonOK ----
                    boutonOK.setText("Valider");
                    boutonOK.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/check16px.png")));
                    buttonBar.add(boutonOK, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- boutonAnnuler ----
                    boutonAnnuler.setText("Annuler");
                    boutonAnnuler.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/reply16px.png")));
                    buttonBar.add(boutonAnnuler, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }

                //---- labelTelephone ----
                labelTelephone.setText("N\u00b0T\u00e9l\u00e9phone");

                //---- labelAssurance ----
                labelAssurance.setText("Assurance");

                //---- labelMail ----
                labelMail.setText("Email");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPrénom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelAdresse, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCodePostal)
                                        .addComponent(Ville, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelAssurance)
                                        .addComponent(labelMail)
                                        .addComponent(labelTelephone, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textFieldAdresse2, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldCodePostal, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldAdresse1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldPrenom, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldNom, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldVille, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldNumTel, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldAssurance, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                            .addContainerGap(64, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPrénom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAdresse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldAdresse1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldAdresse2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCodePostal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Ville, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldNumTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTelephone))
                            .addGap(9, 9, 9)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAssurance)
                                .addComponent(textFieldAssurance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelMail))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
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
                    gestionClientController.ajouterClient(textFieldNom.getText(), textFieldPrenom.getText(), textFieldAdresse1.getText(), textFieldCodePostal.getText(), textFieldVille.getText());
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
    private JLabel labelNom;
    private JLabel labelPrénom;
    private JLabel labelAdresse;
    private JLabel labelCodePostal;
    private JLabel Ville;
    private JPanel buttonBar;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private JLabel labelTelephone;
    private JLabel labelAssurance;
    private JLabel labelMail;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldAdresse1;
    private JTextField textFieldAdresse2;
    private JTextField textFieldCodePostal;
    private JTextField textFieldVille;
    private JTextField textFieldNumTel;
    private JTextField textFieldAssurance;
    private JTextField textFieldEmail;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
