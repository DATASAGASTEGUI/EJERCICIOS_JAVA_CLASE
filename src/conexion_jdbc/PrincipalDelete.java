package conexion_jdbc;

import java.sql.*;

public class PrincipalDelete {

    public static void main(String[] args) {
       String url = "jdbc:mysql://localhost:3306/universidad";
       String usuario = "root";
       String clave = "12345678";
       
       String query = "DELETE FROM ALUMNO WHERE ID_ALUMNO = ?";//PARAMETRICA
       
       try {
           Connection conexion = DriverManager.getConnection(url,usuario,clave);
           PreparedStatement ps = conexion.prepareStatement(query);
           ps.setInt(1, 7);
           ps.executeUpdate();
           System.out.println("OK: DELETE");
       }catch(SQLException e) {
           System.out.println("ERROR: DELETE");
       }
        
        
        
    }
    
}
