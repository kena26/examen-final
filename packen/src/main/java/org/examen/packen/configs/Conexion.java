package org.examen.packen.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    
    private static String user = "sa";

    private static String password = "12345";

    private static String bd = "Clinica_Veterinaria";

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName="+bd+";trustServerCertificate=true";

    private static Connection connection = null;

    public static Connection getConexion () throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}