package fr.eni.clinique.IHM;

import javax.swing.*;
import java.awt.*;

public class EcranGestionPersonnel extends JFrame{

    private JButton btn1;


    public EcranGestionPersonnel(){
        this.setSize(800, 800);
        this.setTitle("Gestion du Personnel");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initIhm();
    }

    private void initIhm() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5 , 5,5,5);

        gbc.gridy = 0;
        gbc.gridx = 0;

        panelPrincipal.add(new JLabel("Nom Prénom :"), gbc);
        panelPrincipal.add(new JLabel("Nom Prénom :"), gbc);
        gbc.gridy = 0;
        gbc.gridx = 2;
        panelPrincipal.add(new JLabel("Rôle :"), gbc);
        gbc.gridy = 0;
        gbc.gridx = 4;
        panelPrincipal.add(new JLabel("Mot de passe :"), gbc);


        setContentPane(panelPrincipal);

    }
}
