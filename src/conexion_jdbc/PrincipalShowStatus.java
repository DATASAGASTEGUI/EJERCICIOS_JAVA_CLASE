package conexion_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrincipalShowStatus {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/UNIVERSIDAD";
        String usuario = "root";
        String clave = "";
        
        String tabla = "ALUMNO";
        String query = "SHOW TABLE STATUS LIKE '" + tabla + "'";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String autoIncrement = rs.getString("Auto_increment");
                System.out.println("AUTO INCREMENT: " + autoIncrement);
            }
            System.out.println("OK: SHOW STATUS");
        } catch (Exception e) {
            System.out.println("ERROR: SHOW STATUS");
        }
    }

}
