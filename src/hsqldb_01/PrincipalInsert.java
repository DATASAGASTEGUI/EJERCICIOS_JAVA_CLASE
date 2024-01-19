package hsqldb_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalInsert {

    public static void main(String[] args) throws ClassNotFoundException {
        //PARAMETROS CONEXION
        //1. ENTRADA
        String protocolo = "jdbc:hsqldb:file";
        String driver = "org.hsqldb.jdbc.JDBCDriver";
        String dataBase = "E:\\DATOSHSQLDB\\empresa.hsqldb";
        String user = "SA";
        String password = "";
        //2. SALIDA
        String url = protocolo + ":" + dataBase;
        Connection conexion = null;

        boolean bandera = true;

        try {
            Class.forName(driver); //Cargar driver
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("OK: CONEXION");
        } catch (SQLException e) {
            //System.out.println("ERROR: CONEXION");
            bandera = false;
        }

        if (bandera == true) {
            String query = "INSERT INTO Trabajador (id_trabajador,nombre,apaterno,tipo_trabajador,parametros_sueldo) VALUES ('T05','Arturo','Ruiz',1,'343')";
            try {
                System.out.println("LLEGO");
                PreparedStatement ps = conexion.prepareStatement(query);
                
                ps.executeUpdate();
                System.out.println("OK: INSERT");
                
                //CERRAR LA CONEXION
                //******************************
                Statement st = conexion.createStatement();
                st.executeUpdate("SHUTDOWN");
                st.close();
                conexion.close();
                conexion = null;
                //******************************
                
                
            } catch (SQLException ex) {
                System.out.println("ERROR: INSERT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

}
