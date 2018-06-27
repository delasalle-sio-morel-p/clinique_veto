package fr.eni.clinique.DAL.JDBC;

import fr.eni.clinique.DAL.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTools {

    private static String urldb;
    private static String userdb;
    private static String passworddb;

    //bloc d'initialisation statique
    static {
        try {
            Class.forName(Settings.getProperty("driverDb"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        urldb = Settings.getProperty("urlDb");
        userdb = Settings.getProperty("userDb");
        passworddb = Settings.getProperty("passwordDb");
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);

        return connection;
    }

}



