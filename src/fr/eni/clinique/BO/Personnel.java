package fr.eni.clinique.BO;

public abstract class Personnel {

    private int codePersonnel;
    private String nom;
    private String prenom;
    private String motPasse;
    private String role;
    private boolean archive;

    // Getters/Setters

    public int getCodePersonnel() {
        return codePersonnel;
    }

    public void setCodePersonnel(int codePersonnel) {
        this.codePersonnel = codePersonnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    // Constructeurs

    public Personnel() {
        // TODO Auto-generated constructor stub
    }

    public Personnel(int codePersonnel, String nom, String prenom, String motPasse, String role, boolean archive) {
        super();
        this.codePersonnel = codePersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.motPasse = motPasse;
        this.role = role;
        this.archive = archive;
    }


    public Personnel(String nom, String prenom, String motPasse, String role, boolean archive) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.motPasse = motPasse;
        this.role = role;
        this.archive = archive;
    }

    @Override
    public String toString() {
        return "Personnel : " + nom;
    }


}
