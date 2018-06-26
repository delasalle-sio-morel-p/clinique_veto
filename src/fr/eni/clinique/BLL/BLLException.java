package fr.eni.clinique.BLL;

import java.util.ArrayList;

public class BLLException extends Exception {

    private ArrayList<Exception> exceptions = new ArrayList<>();

    public BLLException() {

    }

    public BLLException(String message) {
        super(message);
    }

    public void ajouterException(Exception e) {
        exceptions.add(e);
    }

    public boolean hasExceptions() {
        return exceptions.size() > 0;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage() + " " + System.lineSeparator();
        for(Exception e : exceptions) {
            message += e.getMessage() + " " + System.lineSeparator();
        }
        return message;
    }

}