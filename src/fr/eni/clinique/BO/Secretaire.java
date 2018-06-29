package fr.eni.clinique.BO;

public class Secretaire extends Personnel {


    public Secretaire() {
    }

    public Secretaire(int codePersonnel, String nom, String prenom, String motPasse, String role, boolean archive) {
        super(codePersonnel, nom, prenom, motPasse, role, archive);
    }

    public Secretaire(String nom, String prenom, String motPasse, String role, boolean archive) {
        super(nom, prenom, motPasse, role, archive);
    }
    @Override
    public String toString() {
        return super.getNom() + " " + super.getPrenom();
    }

}
