package fr.eni.clinique.AppliTest.Connexion;

import fr.eni.clinique.IHM.EcranAccueil;
import fr.eni.clinique.IHM.EcranConnexion;

import javax.swing.*;

public class AppliTestHMAccueil {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                EcranAccueil accueil = new EcranAccueil();
                accueil.setVisible(true);
            }
        });

    }
}
