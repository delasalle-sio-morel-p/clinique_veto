package fr.eni.clinique.AppliTest;

import fr.eni.clinique.BO.Admin;

public class AppliTestBOConnexion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Admin a1 = new Admin("MOREL Patrick", "PIN", "adm", false);
        Admin a2 = new Admin("BOURVIC Mathieu", "NOIX", "adm", false);

        System.out.println(a1);
        System.out.println("\r");
        System.out.println(a2);
        System.out.println("\r");
    }

}
