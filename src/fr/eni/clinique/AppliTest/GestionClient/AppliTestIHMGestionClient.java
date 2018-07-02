package fr.eni.clinique.AppliTest.GestionClient;

import fr.eni.clinique.IHM.Client.EcranClient;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;

public class AppliTestIHMGestionClient {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                EcranAccueil ecranAccueil = new EcranAccueil();
                ecranAccueil.setVisible(true);

                EcranClient gestionClient = new EcranClient();
                ecranAccueil.setContentPane(gestionClient);

            }
        });

    }
}

