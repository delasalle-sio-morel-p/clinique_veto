package fr.eni.clinique.BO;

public class Admin extends Personnel {


    public Admin() {
    }

    public Admin(int codePersonnel, String nom, String motPasse, String role, boolean archive) {
        super(codePersonnel, nom, motPasse, role, archive);
    }

    public Admin(String nom, String motPasse, String role, boolean archive) {
        super(nom, motPasse, role, archive);
    }

    @Override
    public String toString() {
        return "Administrateur : " + super.getNom();
    }


}
