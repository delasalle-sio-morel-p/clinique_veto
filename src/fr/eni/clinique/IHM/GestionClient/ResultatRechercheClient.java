/*
 * Created by JFormDesigner on Mon Jul 02 15:11:20 CEST 2018
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
public class ResultatRechercheClient extends JDialog {
    public ResultatRechercheClient(Frame owner) {
        super(owner);
        initComponents();
    }

    public ResultatRechercheClient(Frame owner, GestionClientController gestionClientController) {
        super(owner);
        this.gestionClientController = gestionClientController;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        boutonSelectionner = new JButton();
        buttonBar = new JPanel();
        toolBar1 = new JToolBar();
        textFieldRechercher = new JTextField();
        boutonRechercher = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //---- boutonSelectionner ----
                boutonSelectionner.setText("S\u00e9lectionner");
                boutonSelectionner.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/check16px.png")));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 562, Short.MAX_VALUE)
                            .addComponent(boutonSelectionner))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                            .addComponent(boutonSelectionner)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== toolBar1 ========
            {
                toolBar1.add(textFieldRechercher);

                //---- buttonRechercher ----
                boutonRechercher.setText("Rechercher");
                boutonRechercher.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/search16px.png")));
                toolBar1.add(boutonRechercher);
            }
            dialogPane.add(toolBar1, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void actionBtnSupprimerClient() {
        boutonRechercher.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionClientController.rechercherClient();
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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton boutonSelectionner;
    private JPanel buttonBar;
    private JToolBar toolBar1;
    private JTextField textFieldRechercher;
    private JButton boutonRechercher;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
