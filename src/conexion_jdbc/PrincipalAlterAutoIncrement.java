package conexion_jdbc;

import java.sql.*;


public class PrincipalAlterAutoIncrement {

    public static void main(String[] args) {
       String url = "jdbc:mysql://localhost:3306/UNIVERSIDAD";
       String usuario = "root";
       String clave = "";
       
       String tabla = "ALUMNO";
       int inicio = 11;
       
       String query = "ALTER TABLE " + tabla + " AUTO_INCREMENT = " + inicio;
       
       try {
           Connection conexion = DriverManager.getConnection(url,usuario,clave);
           Statement statement = conexion.createStatement();
           statement.executeUpdate(query);
           System.out.println("OK: ALTER AUTO_INCREMENT");
       }catch(Exception e) {
           System.out.println("ERROR: ALTER AUTO_INCREMENT");
       }
    }
    
}
