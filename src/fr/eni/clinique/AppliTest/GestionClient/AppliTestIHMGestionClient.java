package fr.eni.clinique.AppliTest.GestionClient;

import fr.eni.clinique.IHM.GestionClient.EcranGestionClient;
import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;

public class AppliTestIHMGestionClient {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                EcranAccueil ecranAccueil = new EcranAccueil();
                ecranAccueil.setVisible(true);

                EcranGestionClient gestionClient = new EcranGestionClient();
                ecranAccueil.setContentPane(gestionClient);

            }
        });

    }
}

