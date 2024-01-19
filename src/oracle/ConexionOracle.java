package oracle;

import java.sql.*;

public class ConexionOracle {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
        String usuario = "dbinstituto";
        String clave = "12345678";
        Connection conexion;
        try {
              conexion = DriverManager.getConnection(url,usuario,clave);
              System.out.println("OK: CONEXION");
        }catch(SQLException e) {
              conexion = null;
        }
        
        if(conexion != null) {
           String query = "SELECT d.nombre, COUNT(a.nombre) AS CANTIDAD\n" +
                          "FROM Departamento d\n" +
                          "INNER JOIN Alumno a ON d.id_departamento = a.id_departamento\n" +
                          "GROUP BY d.nombre\n" +
                          "ORDER BY d.nombre";
           try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                   String nombre = rs.getString(1);
                   int cantidad = rs.getInt(2);
                   System.out.println(nombre + ";" + cantidad);
                }
           }catch(SQLException e) {
               System.out.println("ERROR: QUERY");
           }
        }else {
           System.out.println("ERROR: CONEXION");
        }
        
        
        
    }
}
