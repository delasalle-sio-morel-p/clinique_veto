/*
 * Created by JFormDesigner on Wed Jul 04 11:17:28 CEST 2018
 */

package fr.eni.clinique.IHM.GestionClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Mathieu BOURVIC
 */
public class SupprimerClient extends JDialog {
    public SupprimerClient(Frame owner) {
        super(owner);
        initComponents();
    }

    public SupprimerClient(Frame owner, GestionClientController gestionClientController) {
        super(owner);
        this.gestionClientController = gestionClientController;
        initComponents();
    }

    public SupprimerClient(Frame owner, JTextField textFieldCode, JTextField textFieldNom, JTextField textFieldPrenom, JTextField textFieldAdresse1, JTextField textFieldAdresse2, JTextField textFieldCodePostal, JTextField textFieldVille, GestionClientController gestionClientController) {
        super(owner);
        this.gestionClientController = gestionClientController;
        this.textFieldCode = textFieldCode;
        this.textFieldNom = textFieldNom;
        this.textFieldPrenom = textFieldPrenom;
        this.textFieldAdresse1 = textFieldAdresse1;
        this.textFieldAdresse2 = textFieldAdresse2;
        this.textFieldCodePostal = textFieldCodePostal;
        this.textFieldVille = textFieldVille;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        labelSupprimerClient = new JLabel();
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

                //---- labelSupprimerClient ----
                labelSupprimerClient.setText("\u00cates-vous s\u00fbr de vouloir supprimer ce client ?");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(labelSupprimerClient, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(45, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(48, Short.MAX_VALUE)
                            .addComponent(labelSupprimerClient)
                            .addGap(46, 46, 46))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                boutonOK.setText("OK");
                buttonBar.add(boutonOK, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
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
                    gestionClientController.supprimerClient(textFieldCode, textFieldNom, textFieldPrenom, textFieldAdresse1, textFieldAdresse2, textFieldCodePostal, textFieldVille);;
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
    private JLabel labelSupprimerClient;
    private JPanel buttonBar;
    private JButton boutonOK;
    private JButton boutonAnnuler;
    private JTextField textFieldCodePostal;
    private JTextField textFieldVille;
    private JTextField textFieldAdresse2;
    private JTextField textFieldAdresse1;
    private JTextField textFieldPrenom;
    private JTextField textFieldNom;
    private JTextField textFieldCode;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
