package fr.eni.clinique.BO;

import java.util.List;

public class Espece {

    private String espece;
    private List<Race> races;

    public Espece() {
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public Espece(String espece) {
        super();
        this.espece = espece;
    }

    public Espece(String espece, List<Race> races) {
        super();
        this.espece = espece;
        this.races = races;
    }

    @Override
    public String toString() {
        return "Espèce " + getEspece();
    }




}