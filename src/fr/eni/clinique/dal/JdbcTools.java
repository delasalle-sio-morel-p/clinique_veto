package fr.eni.clinique.dal;

public class JdbcTools {
    private static String urlDb;
    private static String userDb;
    private static String passwordDb;

    static{
        try{
            Class.forName(Settings.getProperty("driverDb"));

        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        urlDb = Settings.getProperty("urlDb");
        userDb = Settings.getProperty("userDb");
        passwordDb = Settings.getProperty("passwordDb");
    }

}
