package fr.eni.clinique.AppliTest;

import fr.eni.clinique.IHM.ConnexionController;

import javax.swing.*;

public class AppliTestApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ConnexionController.get().startApp();
            }
        });

    }
}
