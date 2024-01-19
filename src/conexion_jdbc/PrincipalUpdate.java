package conexion_jdbc;

import java.sql.*;

public class PrincipalUpdate {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/UNIVERSIDAD";
        String usuario = "root";
        String clave = "12345678";
        
        String query = "UPDATE ALUMNO SET apaterno = ?, es_casado = ? WHERE id_alumno = ?";//PARAMETRICA
        
        try {
            Connection conexion = DriverManager.getConnection(url,usuario,clave);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, "Zuñiga");
            ps.setBoolean(2, true);
            ps.setInt(3, 3);
            ps.executeUpdate();
            System.out.println("OK: UPDATE");
        }catch(SQLException e) {
            System.out.println("ERROR: UPDATE");
        }
        
        
        
        
        
    }
    
}
