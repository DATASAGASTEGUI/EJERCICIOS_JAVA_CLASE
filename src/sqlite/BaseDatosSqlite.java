package sqlite;

import java.sql.*;

public class BaseDatosSqlite {

    // ATRIBUTOS ENTRADA
    private static String driver = "org.sqlite.JDBC";
    private static String protocolo = "jdbc:sqlite";
    private static String database;
    private static String usuario = "";
    private static String clave = "";
    // ATRIBUTO SALIDA
    private static Connection conexion;

    public static Connection getConexion(String basedatos) {
        try {
            String url = protocolo + ":" + basedatos;
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            System.out.println("ERROR CONEXION");
        }
        return conexion;
    }

}
