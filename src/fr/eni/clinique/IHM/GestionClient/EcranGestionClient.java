/*
 * Created by JFormDesigner on Mon Jul 02 14:40:04 CEST 2018
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
public class EcranGestionClient extends JPanel {
    public EcranGestionClient() {
        initComponents();
    }

    public EcranGestionClient(GestionClientController gestionClientController) {
        this.gestionClientController = gestionClientController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelCode = new JLabel();
        scrollPane1 = new JScrollPane();
        tableAnimaux = new JTable();
        labelNom = new JLabel();
        labelPrenom = new JLabel();
        label4 = new JLabel();
        labelCodePostal = new JLabel();
        labelVille = new JLabel();
        boutonAjouterAnimal = new JButton();
        boutonSupprimerAnimal = new JButton();
        boutonModifierAnimal = new JButton();
        textFieldCodePostal = new JTextField();
        textFieldCodePostal.setEditable(false);
        textFieldVille = new JTextField();
        textFieldVille.setEditable(false);
        textFieldAdresse2 = new JTextField();
        textFieldAdresse2.setEditable(false);
        textFieldAdresse1 = new JTextField();
        textFieldAdresse1.setEditable(false);
        textFieldPrenom = new JTextField();
        textFieldPrenom.setEditable(false);
        textFieldNom = new JTextField();
        textFieldNom.setEditable(false);
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        panelButtonBar = new JPanel();
        boutonRechercherClient = new JButton();
        boutonAjouterClient = new JButton();
        boutonSupprimerClient = new JButton();
        boutonOK = new JButton();
        boutonAnnuler = new JButton();

        //======== this ========

        setLayout(new BorderLayout());

        //======== listener =======
        actionBtnRechercherClient();
        actionBtnAjouterClient();
        actionBtnSupprimerClient();
        actionBtnAjouterAnimal();
        actionBtnSupprimerAnimal();
        actionBtnModifierAnimal();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- labelCode ----
                labelCode.setText("Code");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(tableAnimaux);
                }

                //---- labelNom ----
                labelNom.setText("Nom");

                //---- labelPrenom ----
                labelPrenom.setText("Pr\u00e9nom");

                //---- label4 ----
                label4.setText("Adresse");

                //---- labelCodePostal ----
                labelCodePostal.setText("Code Postal");

                //---- labelVille ----
                labelVille.setText("Ville");

                //---- buttonAjouterAnimal ----
                boutonAjouterAnimal.setText("Ajouter");
                boutonAjouterAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add16px.png")));

                //---- buttonSupprimerAnimal ----
                boutonSupprimerAnimal.setText("Supprimer");
                boutonSupprimerAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete16px.png")));

                //---- buttonEditerAnimal ----
                boutonModifierAnimal.setText("Editer");
                boutonModifierAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/edit16px.png")));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(labelCodePostal, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(labelVille, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCode, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                    .addGap(5, 5, 5)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(boutonAjouterAnimal)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(boutonSupprimerAnimal)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(boutonModifierAnimal))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textFieldCodePostal, GroupLayout.Alignment.TRAILING)
                                        .addComponent(textFieldVille)
                                        .addComponent(textFieldAdresse2)
                                        .addComponent(textFieldAdresse1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                        .addComponent(textFieldPrenom, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                        .addComponent(textFieldNom, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                        .addComponent(textFieldCode, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
                            .addGap(87, 87, 87))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelCode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(5, 5, 5)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(5, 5, 5)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldAdresse1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldAdresse2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCodePostal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(5, 5, 5)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelVille, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(boutonModifierAnimal)
                                .addComponent(boutonSupprimerAnimal)
                                .addComponent(boutonAjouterAnimal)))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                panelButtonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- buttonRechercher ----
                boutonRechercherClient.setText("Rechercher");
                boutonRechercherClient.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/search16px.png")));

                //---- buttonAjouter ----
                boutonAjouterClient.setText("Ajouter");
                boutonAjouterClient.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add16px.png")));

                //---- Supprimer ----
                boutonSupprimerClient.setText("Supprimer");
                boutonSupprimerClient.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete16px.png")));

                //---- okButton ----
                boutonOK.setText("Valider");
                boutonOK.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/check16px.png")));

                //---- cancelButton ----
                boutonAnnuler.setText("Annuler");
                boutonAnnuler.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/reply16px.png")));

                GroupLayout buttonBarLayout = new GroupLayout(panelButtonBar);
                panelButtonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addComponent(boutonRechercherClient)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                            .addComponent(boutonAjouterClient, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(boutonSupprimerClient)
                            .addGap(89, 89, 89)
                            .addComponent(boutonOK)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boutonAnnuler)
                            .addGap(86, 86, 86))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGroup(buttonBarLayout.createParallelGroup()
                                .addComponent(boutonRechercherClient)
                                .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(boutonAnnuler)
                                    .addComponent(boutonOK)
                                    .addComponent(boutonAjouterClient)
                                    .addComponent(boutonSupprimerClient)))
                            .addGap(12, 12, 12))
                );
            }
            dialogPane.add(panelButtonBar, BorderLayout.NORTH);
        }
        add(dialogPane, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnRechercherClient() {
        boutonRechercherClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.afficherRechercherClient(textFieldCode, textFieldNom, textFieldPrenom, textFieldAdresse1, textFieldAdresse2, textFieldCodePostal, textFieldVille);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnAjouterClient() {
        boutonAjouterClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.afficherAjouterClient();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnSupprimerClient() {
        boutonSupprimerClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.afficherSupprimerClient(textFieldCode, textFieldNom, textFieldPrenom, textFieldAdresse1, textFieldAdresse2, textFieldCodePostal, textFieldVille);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnAjouterAnimal() {
        boutonAjouterAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.affichageEcranAjoutAnimal();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnSupprimerAnimal() {
        boutonSupprimerAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.affichageSupprimerAnimal(tableAnimaux);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void actionBtnModifierAnimal() {
        boutonModifierAnimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.affichageModifierAnimal(tableAnimaux);
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
    private JLabel labelCode;
    private JScrollPane scrollPane1;
    private JTable tableAnimaux;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel label4;
    private JLabel labelCodePostal;
    private JLabel labelVille;
    private JButton boutonAjouterAnimal;
    private JButton boutonSupprimerAnimal;
    private JButton boutonModifierAnimal;
    private JTextField textFieldCodePostal;
    private JTextField textFieldVille;
    private JTextField textFieldAdresse2;
    private JTextField textFieldAdresse1;
    private JTextField textFieldPrenom;
    private JTextField textFieldNom;
    private JTextField textFieldCode;
    private JPanel panelButtonBar;
    private JButton boutonRechercherClient;
    private JButton boutonAjouterClient;
    private JButton boutonSupprimerClient;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
