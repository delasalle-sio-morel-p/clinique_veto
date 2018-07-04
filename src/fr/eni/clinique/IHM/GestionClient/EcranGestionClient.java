/*
 * Created by JFormDesigner on Mon Jul 02 14:40:04 CEST 2018
 */

package fr.eni.clinique.IHM.GestionClient;

import java.awt.*;
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
        table1 = new JTable();
        labelNom = new JLabel();
        labelPrenom = new JLabel();
        label4 = new JLabel();
        labelCodePostal = new JLabel();
        labelVille = new JLabel();
        buttonAjouterAnimal = new JButton();
        buttonSupprimerAnimal = new JButton();
        buttonEditerAnimal = new JButton();
        textFieldCodePostal = new JTextField();
        textFieldVille = new JTextField();
        textFieldAdresse2 = new JTextField();
        textFieldAdresse1 = new JTextField();
        textFieldPrenom = new JTextField();
        textFieldNom = new JTextField();
        textFieldCode = new JTextField();
        buttonBar = new JPanel();
        buttonRechercher = new JButton();
        buttonAjouter = new JButton();
        Supprimer = new JButton();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========

        setLayout(new BorderLayout());

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
                    scrollPane1.setViewportView(table1);
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
                buttonAjouterAnimal.setText("Ajouter");
                buttonAjouterAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add16px.png")));

                //---- buttonSupprimerAnimal ----
                buttonSupprimerAnimal.setText("Supprimer");
                buttonSupprimerAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete16px.png")));

                //---- buttonEditerAnimal ----
                buttonEditerAnimal.setText("Editer");
                buttonEditerAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/edit16px.png")));

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
                                    .addComponent(buttonAjouterAnimal)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonSupprimerAnimal)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonEditerAnimal))
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
                                .addComponent(buttonEditerAnimal)
                                .addComponent(buttonSupprimerAnimal)
                                .addComponent(buttonAjouterAnimal)))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- buttonRechercher ----
                buttonRechercher.setText("Rechercher");
                buttonRechercher.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/search16px.png")));

                //---- buttonAjouter ----
                buttonAjouter.setText("Ajouter");
                buttonAjouter.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add16px.png")));

                //---- Supprimer ----
                Supprimer.setText("Supprimer");
                Supprimer.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete16px.png")));

                //---- okButton ----
                okButton.setText("Valider");
                okButton.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/check16px.png")));

                //---- cancelButton ----
                cancelButton.setText("Annuler");
                cancelButton.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/reply16px.png")));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addComponent(buttonRechercher)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                            .addComponent(buttonAjouter, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Supprimer)
                            .addGap(89, 89, 89)
                            .addComponent(okButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelButton)
                            .addGap(86, 86, 86))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGroup(buttonBarLayout.createParallelGroup()
                                .addComponent(buttonRechercher)
                                .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(cancelButton)
                                    .addComponent(okButton)
                                    .addComponent(buttonAjouter)
                                    .addComponent(Supprimer)))
                            .addGap(12, 12, 12))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.NORTH);
        }
        add(dialogPane, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel labelCode;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel label4;
    private JLabel labelCodePostal;
    private JLabel labelVille;
    private JButton buttonAjouterAnimal;
    private JButton buttonSupprimerAnimal;
    private JButton buttonEditerAnimal;
    private JTextField textFieldCodePostal;
    private JTextField textFieldVille;
    private JTextField textFieldAdresse2;
    private JTextField textFieldAdresse1;
    private JTextField textFieldPrenom;
    private JTextField textFieldNom;
    private JTextField textFieldCode;
    private JPanel buttonBar;
    private JButton buttonRechercher;
    private JButton buttonAjouter;
    private JButton Supprimer;
    private JButton okButton;
    private JButton cancelButton;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
