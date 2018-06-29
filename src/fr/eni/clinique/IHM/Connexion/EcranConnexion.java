package fr.eni.clinique.IHM.Connexion;

import fr.eni.clinique.BLL.BLLException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranConnexion extends JFrame {
    private JTextField txtNom;
    private JPasswordField mdp;
    private JButton btnValider;
    private ConnexionController connexionController;

    public EcranConnexion() {
        this.setSize(500, 175);
        this.setTitle("Connexion");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initIhm();

    }

    public EcranConnexion(ConnexionController connexionController) {
        this.connexionController = connexionController;
        this.setSize(500, 175);
        this.setTitle("Connexion");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initIhm();

    }

    private void initIhm() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        // Nom
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Nom"), gbc);

        gbc.gridx = 1;
        panelPrincipal.add(getTxtNom(), gbc);

        // Mot de passe
        gbc.gridy = 1;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Mot de passe"), gbc);

        gbc.gridx = 1;
        panelPrincipal.add(getMdp(), gbc);

        // Mot de passe
        gbc.gridy = 2;
        gbc.gridx = 0;
        panelPrincipal.add(getBtnValider(), gbc);

        actionBtnValider();

        setContentPane(panelPrincipal);
    }

    private JTextField getTxtNom() {
        if (txtNom == null) {
            txtNom = new JTextField(30);
        }
        return txtNom;
    }

    private JPasswordField getMdp() {
        if (mdp == null) {
            mdp = new JPasswordField(30);
        }
        return mdp;
    }

    private JButton getBtnValider() {
        if (btnValider == null) {
            btnValider = new JButton("Valider");
        }
        return btnValider;

    }
    private void actionBtnValider() {
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connexionController.connexion(txtNom, mdp);
                } catch (BLLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }



}
