package conexion_jdbc;

import java.sql.*;

public class PrincipalShowTables {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/UNIVERSIDAD";
        String usuario = "root";
        String clave = "";
        
        String query = "SHOW TABLES";
        
        try {
            Connection conexion = DriverManager.getConnection(url,usuario,clave);
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               String tabla = rs.getString("Tables_in_universidad");
               System.out.println("Tabla: " + tabla);
            }
            System.out.println("OK: SHOW TABLES");
        }catch(Exception e) {
            System.out.println("ERROR: SHOW TABLES");
        }
        
        
        
        
        
    }
    
}
