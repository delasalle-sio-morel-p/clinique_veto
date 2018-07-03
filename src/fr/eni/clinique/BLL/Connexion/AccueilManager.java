package fr.eni.clinique.BLL.Connexion;

import fr.eni.clinique.BLL.BLLException;

public class AccueilManager {
    private static AccueilManager instance = null;

    public static AccueilManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new AccueilManager();
        }
        return instance;
    }
}
