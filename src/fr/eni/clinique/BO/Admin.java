package fr.eni.clinique.BO;

public class Admin extends Personnel {


    public Admin() {
    }

    public Admin(int codePersonnel, String nom, String prenom, String motPasse, String role, boolean archive) {
        super(codePersonnel, nom, prenom, motPasse, role, archive);
    }

    public Admin(String nom, String prenom, String motPasse, String role, boolean archive) {
        super(nom, prenom, motPasse, role, archive);
    }

    @Override
    public String toString() {
        return super.getNom() + " " + super.getPrenom();
    }


}
