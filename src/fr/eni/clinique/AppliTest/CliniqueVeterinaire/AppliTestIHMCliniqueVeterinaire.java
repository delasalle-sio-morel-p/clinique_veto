package fr.eni.clinique.AppliTest.CliniqueVeterinaire;

import fr.eni.clinique.IHM.Connexion.EcranAccueil;

import javax.swing.*;

public class AppliTestIHMCliniqueVeterinaire {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                EcranAccueil global = new EcranAccueil();
                global.setVisible(true);

            }
        });

    }
}
