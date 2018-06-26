package fr.eni.clinique.AppliTest.Connexion;

import fr.eni.clinique.IHM.EcranConnexion;

import javax.swing.*;

public class AppliTestIHMConnexion {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                EcranConnexion connexion = new EcranConnexion();
                connexion.setVisible(true);

            }
        });

    }
}
