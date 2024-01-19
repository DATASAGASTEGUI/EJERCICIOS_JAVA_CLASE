package tarea_mysql_salud;

import java.sql.*;

public class BaseDatos {
    //ATRIBUTO
    // ENTRADA
    String protocolo;
    String ip;
    int puerto;
    String database;
    String usuario;
    String clave;
    // SALIDA
    Connection conexion;

    public BaseDatos(String protocolo, String ip, int puerto, String database, String usuario, String clave) {
        this.protocolo = protocolo;
        this.ip = ip;
        this.puerto = puerto;
        this.database = database;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public Connection getConexion() {
        String url = protocolo + "://" + ip + ":" + puerto + "/" + database;
        try {
            this.conexion = DriverManager.getConnection(url, this.usuario, this.clave);
        } catch (SQLException ex) {
            this.conexion = null;
        }
        return this.conexion;
    }
}
