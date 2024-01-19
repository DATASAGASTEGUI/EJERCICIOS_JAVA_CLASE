package hsqldb_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal_CreateTable_Insert_Select {

    public static void main(String[] args) throws ClassNotFoundException {
        //PARAMETROS CONEXION
        //1. ENTRADA
        String protocolo = "jdbc:hsqldb:file";
        String driver = "org.hsqldb.jdbc.JDBCDriver";
        String dataBase = "C:\\hsqldb-2.7.2\\hsqldb\\data\\EMPRESA\\empresa";
        String user = "SA";
        String password = "12345678";
        //2. SALIDA
        String url = protocolo + ":" + dataBase;
        Connection conexion = null;

        boolean bandera = true;

        try {
            Class.forName(driver); //Cargar driver
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("OK: CONEXION");
        } catch (SQLException e) {
            bandera = false;
        }
        if (bandera == true) {
            PreparedStatement ps = null;
            
            String query1 = "CREATE TABLE Trabajador (\n"
                    + "   id_trabajador     VARCHAR(6)  NOT NULL PRIMARY KEY,\n"
                    + "   nombre            VARCHAR(20) NOT NULL,\n"
                    + "   apaterno          VARCHAR(30) NOT NULL,\n"
                    + "   tipo_trabajador   INT         NOT NULL,\n"
                    + "   parametros_sueldo VARCHAR(15) NOT NULL\n"
                    + ") ";
            String query2 = "INSERT INTO Trabajador (id_trabajador,nombre,apaterno,tipo_trabajador,parametros_sueldo) VALUES (?,?,?,?,?)";
            String query3 = "SELECT * FROM Trabajador";

            try {
                ps = conexion.prepareStatement(query1);//CREATE TABLE
                ps.execute();
                System.out.println("OK: CREATE TABLE");
                
                ps = conexion.prepareStatement(query2);//INSERT
                ps.setString(1,"T05");
                ps.setString(2, "Artguro");
                ps.setString(3, "Ruiz");
                ps.setInt(4, 1);
                ps.setString(5, "343");
                ps.executeUpdate();
                System.out.println("OK: INSERT");
                
                ps = conexion.prepareStatement(query3);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String idTrabajador = rs.getString(1);
                    String nombre = rs.getString(2);
                    String apaterno = rs.getString(3);
                    int tipoTrabajador = rs.getInt(4);
                    String parametrosSueldo = rs.getString(5);
                    System.out.println(idTrabajador+";"+nombre+";"+apaterno+";"+tipoTrabajador+";"+parametrosSueldo);
                }
                System.out.println("OK: SELECT");
            } catch (SQLException ex) {
                System.out.println("ERROR: CREATE TABLE");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }
}
