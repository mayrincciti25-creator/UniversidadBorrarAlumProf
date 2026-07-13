package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/universidad";
    private static final String usuario = "root";
    private static final String password = "Fresita19//@";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a MySQL");
        }
        catch (SQLException err){
            System.out.println("Error a conectarse a MySQL "+err);
        }


        return conexion;
    }
}
