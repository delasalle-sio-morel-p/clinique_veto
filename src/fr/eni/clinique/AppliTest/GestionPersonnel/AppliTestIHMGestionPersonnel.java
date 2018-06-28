package fr.eni.clinique.AppliTest.GestionPersonnel;

import javax.swing.*;

import fr.eni.clinique.IHM.AjouterPersonnel;
import fr.eni.clinique.IHM.EcranGestionPersonnel;
import fr.eni.clinique.IHM.ReinitialiserMDP;
import fr.eni.clinique.IHM.SupprimerPersonnel;

public class AppliTestIHMGestionPersonnel {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                EcranGestionPersonnel gestionPersonnel = new EcranGestionPersonnel();
                gestionPersonnel.setVisible(true);

                AjouterPersonnel addPersonnel = new AjouterPersonnel(gestionPersonnel);
                addPersonnel.setVisible(true);

                SupprimerPersonnel suppPersonnel = new SupprimerPersonnel(gestionPersonnel);
                suppPersonnel.setVisible(true);

                ReinitialiserMDP reinitMDP = new ReinitialiserMDP(gestionPersonnel);
                reinitMDP.setVisible(true);

            }
        });

    }
}
