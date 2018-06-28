package fr.eni.clinique.AppliTest.GestionPersonnel;

import fr.eni.clinique.IHM.EcranGestionPersonnel;

import javax.swing.*;

public class AppliTestIHMGestionPersonnel {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                EcranGestionPersonnel gestionPersonnel = new EcranGestionPersonnel();
                gestionPersonnel.setVisible(true);

            }
        });

    }
}
