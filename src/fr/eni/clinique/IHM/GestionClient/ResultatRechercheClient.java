/*
 * Created by JFormDesigner on Mon Jul 02 15:11:20 CEST 2018
 */

package fr.eni.clinique.IHM.GestionClient;

import java.awt.*;
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
        buttonBar = new JPanel();
        toolBar1 = new JToolBar();
        textFieldRechercher = new JTextField();
        buttonRechercher = new JButton();

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
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

                //---- textFieldRechercher ----
                textFieldRechercher.setText("Rechercher");
                toolBar1.add(textFieldRechercher);

                //---- buttonRechercher ----
                buttonRechercher.setText("Rechercher");
                buttonRechercher.setIcon(new ImageIcon(getClass().getResource("/fr/eni/clinique/IHM/resources/search16px.png")));
                toolBar1.add(buttonRechercher);
            }
            dialogPane.add(toolBar1, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mathieu BOURVIC
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel buttonBar;
    private JToolBar toolBar1;
    private JTextField textFieldRechercher;
    private JButton buttonRechercher;
    private GestionClientController gestionClientController;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
