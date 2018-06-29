package fr.eni.clinique.AppliTest.GestionPersonnel;

import javax.swing.*;

import fr.eni.clinique.IHM.Connexion.EcranAccueil;
import fr.eni.clinique.IHM.GestionPersonnel.AjouterPersonnel;
import fr.eni.clinique.IHM.GestionPersonnel.EcranGestionPersonnel;
import fr.eni.clinique.IHM.GestionPersonnel.ReinitialiserMDP;
import fr.eni.clinique.IHM.GestionPersonnel.SupprimerPersonnel;

public class AppliTestIHMGestionPersonnel {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                EcranAccueil ecranAccueil = new EcranAccueil();
                ecranAccueil.setVisible(true);

                EcranGestionPersonnel gestionPersonnel = new EcranGestionPersonnel();
                ecranAccueil.setContentPane(gestionPersonnel);

                AjouterPersonnel addPersonnel = new AjouterPersonnel();
//                ecranAccueil.setContentPane(addPersonnel);

                SupprimerPersonnel suppPersonnel = new SupprimerPersonnel();
//                ecranAccueil.setContentPane(suppPersonnel);

                ReinitialiserMDP reinitMDP = new ReinitialiserMDP();
//                ecranAccueil.setContentPane(reinitMDP);

            }
        });

    }
}
