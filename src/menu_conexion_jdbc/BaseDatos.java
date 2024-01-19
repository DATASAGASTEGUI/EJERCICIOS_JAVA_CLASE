package menu_conexion_jdbc;

import java.sql.*;

/*
    ENTRADA
      PROTOCOLO
      NOMBRE SERVIDOR
      PUERTO
      NOMBRE BASE DATOS
    SALIA
      CONEXION
 */
public class BaseDatos {
    //ATRIBUTOS
    //ENTRADA
    String protocolo;
    String ip;
    int puerto;
    String dataBase;
    String usuario;
    String clave;
    //SALIDA
    Connection conexion;

    public BaseDatos() {
    }

    public BaseDatos(String protocolo, String ip, int puerto, String dataBase, String usuario, String clave) {
        this.protocolo = protocolo;
        this.ip = ip;
        this.puerto = puerto;
        this.dataBase = dataBase;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Connection getConexion() {
        String url = this.protocolo + "://"
                + this.ip + ":"
                + this.puerto + "/"
                + this.dataBase;
        try {
            this.conexion = DriverManager.getConnection(url, this.usuario, this.clave);
        } catch (SQLException e) {
            return null;
        }
        return this.conexion;
    }
}
