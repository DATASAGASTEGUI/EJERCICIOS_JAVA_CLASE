package postgresql;

import java.sql.*;

public class Principal1 {

    public static void main(String[] args) {
        Connection conexion = getConexion();
        if(conexion != null) {
           System.out.println("OK: CONEXION"); 
           String query = "SELECT * FROM Alumno";
           try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String idAlumno = rs.getString(1);
                    String nombre = rs.getString(2);
                    System.out.println(idAlumno+";"+nombre);
                }
                System.out.println("OK: SELECT");
           }catch(SQLException e) {
               System.out.println("ERROR: SELECT");
           }
        }else {
           System.out.println("ERROR: CONEXION"); 
        }
    }

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/academia";
            conexion = DriverManager.getConnection(url, "postgres", "12345678");
        } catch (ClassNotFoundException | SQLException ex) {
            conexion = null;
        }
        return conexion;
    }

}
