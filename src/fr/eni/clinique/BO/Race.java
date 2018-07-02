package fr.eni.clinique.BO;


public class Race {

    private String race;

    public Race() {
        // TODO Auto-generated constructor stub
    }


    public Race(String race) {
        super();
        this.race = race;
    }



    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Race " + getRace();
    }




}
