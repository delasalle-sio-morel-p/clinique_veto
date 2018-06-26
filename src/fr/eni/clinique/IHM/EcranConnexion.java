package fr.eni.clinique.IHM;

import javax.swing.*;
import java.awt.*;

public class EcranConnexion extends JFrame {
    private JTextField txtNom, txtMdp;
    private JButton btnValider;

    public EcranConnexion() {
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
        panelPrincipal.add(getTxtMdp(), gbc);

        setContentPane(panelPrincipal);
    }

    private JTextField getTxtNom() {
        if (txtNom == null) {
            txtNom = new JTextField(30);
        }
        return txtNom;
    }

    private JTextField getTxtMdp() {
        if (txtMdp == null) {
            txtMdp = new JTextField(30);
        }
        return txtMdp;
    }
}
