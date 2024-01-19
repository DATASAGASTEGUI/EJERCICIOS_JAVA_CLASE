package postgresql;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/academia";
            conexion = DriverManager.getConnection(url, "postgres", "12345678");
            System.out.println("OK: CONEXION");
        } catch (ClassNotFoundException | SQLException  ex) {
            System.out.println("ERROR: CONEXION");
        }
    }
}
