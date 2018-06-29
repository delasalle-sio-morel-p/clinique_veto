package fr.eni.clinique.BO;

public class Veterinaire extends Personnel {

    public Veterinaire() {
    }


    public Veterinaire(int codePersonnel, String nom, String prenom, String motPasse, String role, boolean archive) {
        super(codePersonnel, nom, prenom, motPasse, role, archive);
    }


    public Veterinaire(String nom, String prenom, String motPasse, String role, boolean archive) {
        super(nom, prenom,  motPasse, role, archive);
    }
    @Override
    public String toString() {
        return super.getNom() + " " + super.getPrenom();
    }

}
