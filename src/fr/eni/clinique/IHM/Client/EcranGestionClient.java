/*
 * Created by JFormDesigner on Mon Jul 02 14:40:04 CEST 2018
 */

package fr.eni.clinique.IHM.Client;

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
        textFieldCode = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        labelNom = new JLabel();
        textField2 = new JTextField();
        labelPrenom = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textFieldAdresse1 = new JTextField();
        textFieldAdresse2 = new JTextField();
        labelCodePostal = new JLabel();
        textFieldCodePostal = new JTextField();
        labelVille = new JLabel();
        textFieldVille = new JTextField();
        buttonAjouterAnimal = new JButton();
        buttonSupprimerAnimal = new JButton();
        buttonEditerAnimal = new JButton();
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
                buttonAjouterAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add.png")));

                //---- buttonSupprimerAnimal ----
                buttonSupprimerAnimal.setText("Supprimer");
                buttonSupprimerAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete.png")));

                //---- buttonEditerAnimal ----
                buttonEditerAnimal.setText("Editer");
                buttonEditerAnimal.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/edit.png")));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(labelCode, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(30, 30, 30)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(textFieldCode, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(30, 30, 30)
                                                        .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(labelCodePostal)
                                                                .addComponent(labelVille, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(30, 30, 30)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(textFieldVille, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                                .addComponent(textFieldCodePostal, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                                .addComponent(textFieldAdresse2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                                .addComponent(textFieldAdresse1, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addComponent(buttonAjouterAnimal)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(buttonSupprimerAnimal)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(buttonEditerAnimal)
                                                        .addGap(2, 2, 2)))
                                        .addGap(72, 72, 72))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelCode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldAdresse1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textFieldAdresse2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelCodePostal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelVille, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(buttonAjouterAnimal)
                                                .addComponent(buttonSupprimerAnimal)
                                                .addComponent(buttonEditerAnimal))
                                        .addGap(0, 104, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- buttonRechercher ----
                buttonRechercher.setText("Rechercher");
                buttonRechercher.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/search.png")));

                //---- buttonAjouter ----
                buttonAjouter.setText("Ajouter");
                buttonAjouter.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/add.png")));

                //---- Supprimer ----
                Supprimer.setText("Supprimer");
                Supprimer.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/delete.png")));

                //---- okButton ----
                okButton.setText("Valider");
                okButton.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/checked.png")));

                //---- cancelButton ----
                cancelButton.setText("Annuler");
                cancelButton.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/reply.png")));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                        buttonBarLayout.createParallelGroup()
                                .addGroup(buttonBarLayout.createSequentialGroup()
                                        .addComponent(buttonRechercher)
                                        .addGap(80, 80, 80)
                                        .addComponent(buttonAjouter, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Supprimer)
                                        .addGap(52, 52, 52)
                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63))
                );
                buttonBarLayout.setVerticalGroup(
                        buttonBarLayout.createParallelGroup()
                                .addGroup(buttonBarLayout.createSequentialGroup()
                                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(buttonRechercher)
                                                .addComponent(cancelButton)
                                                .addComponent(okButton)
                                                .addComponent(buttonAjouter)
                                                .addComponent(Supprimer))
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
    private JTextField textFieldCode;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel labelNom;
    private JTextField textField2;
    private JLabel labelPrenom;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textFieldAdresse1;
    private JTextField textFieldAdresse2;
    private JLabel labelCodePostal;
    private JTextField textFieldCodePostal;
    private JLabel labelVille;
    private JTextField textFieldVille;
    private JButton buttonAjouterAnimal;
    private JButton buttonSupprimerAnimal;
    private JButton buttonEditerAnimal;
    private JPanel buttonBar;
    private JButton buttonRechercher;
    private JButton buttonAjouter;
    private JButton Supprimer;
    private JButton okButton;
    private JButton cancelButton;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
