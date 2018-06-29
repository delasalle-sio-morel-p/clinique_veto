package fr.eni.clinique.AppliTest.Connexion;

import fr.eni.clinique.BO.Admin;
import fr.eni.clinique.BO.Secretaire;
import fr.eni.clinique.BO.Veterinaire;

public class AppliTestBOConnexion {

    public static void main(String[] args) {

        Admin a1 = new Admin("BOSAPIN", "Edmond", "test", "adm", false);
        Admin a2 = new Admin("DE CAJOU", "Benoît", "test", "adm", false);

        System.out.println(a1);
        System.out.println("\r");
        System.out.println(a2);
        System.out.println("\r");

        Secretaire s1 = new Secretaire("DE JEU", "Odette", "PIN", "sec", false);
        Secretaire s2 = new Secretaire("ABONDIEU", "Elisabeth", "NOIX", "sec", false);
        Secretaire s3 = new Secretaire("HISSON", "Marie Paule", "NOIX", "sec", false);

        System.out.println(s1);
        System.out.println("\r");

        System.out.println(s2);
        System.out.println("\r");

        System.out.println(s3);
        System.out.println("\r");

        Veterinaire v1 = new Veterinaire("MALALANICH", "Melanie", "test", "vet", false);
        Veterinaire v2 = new Veterinaire("AIMONE", "Anne", "test", "vet", false);
        Veterinaire v3 = new Veterinaire("TOURNE", "Sylvain", "test", "vet", false);

        System.out.println(v1);
        System.out.println("\r");
        System.out.println(v2);
        System.out.println("\r");
        System.out.println(v3);
        System.out.println("\r");
    }

}
