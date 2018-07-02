package fr.eni.clinique.BO;

public class Role {
    private int idRole;
    private String codeRole;
    private String libelle;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int newIdRole) {
        this.idRole = newIdRole;
    }

    public String getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(String newCodeRole) {
        this.codeRole = newCodeRole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String newLibelle) {
        this.libelle = newLibelle;
    }

    public Role() {
    }

    public Role(String codeRole, String libelle) {
        super();
        this.codeRole = codeRole;
        this.libelle = libelle;
    }

    public Role(String libelle) {
        super();
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Role : " + libelle;
    }
}
