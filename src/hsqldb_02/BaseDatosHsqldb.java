package hsqldb_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BaseDatosHsqldb {
    
    //ATRIBUTOS CONEXION
    //1. ENTRADA
    String protocolo = "jdbc:hsqldb:file";
    String driver = "org.hsqldb.jdbc.JDBCDriver";
    String dataBase = "E:\\DATOSHSQLDB\\empresa.hsqldb";
    String user = "SA";
    String password = "";
    //2. SALIDA
    Connection conexion;

    public BaseDatosHsqldb() {
    }
    
    public Connection getConexion() {
        String url = this.protocolo + ":" + this.dataBase;
        try {
              Class.forName(driver);
              this.conexion = DriverManager.getConnection(url,this.user,this.password);
        }catch(ClassNotFoundException | SQLException e) {
           conexion = null; 
        }
        return conexion;
    }
    
    
    
    
    
    
    
}
