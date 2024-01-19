package conexion_jdbc;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PrincipalInsert {

    public static void main(String[] args) throws ParseException {
        String url = "jdbc:mysql://127.0.0.1:3306/universidad";
        String usuario = "root";
        String clave = "";
        String query = "INSERT INTO ALUMNO(nombre,apaterno,amaterno,fecha_nacimiento,estatura,es_casado) VALUE (?,?,?,?,?,?)";//PARAMETRICA
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, "Arturo");
            ps.setString(2, "Zuñiga");
            ps.setString(3, "Vazquez");
            ps.setDate(4, obtenerObjetoDateSql("1997-11-15"));
            ps.setDouble(5, 1.72);
            ps.setBoolean(6, true);
            ps.executeUpdate();
            System.out.println("OK: INSERT");
        } catch (SQLException e) {
            System.out.println("ERROR: INSERT");
        }

    }
    
    public static java.sql.Date obtenerObjetoDateSql(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaNacimiento1 = null;        
        try {
            fechaNacimiento1 = sdf.parse(fecha);
        } catch (ParseException ex) {
            return null;
        }
        java.sql.Date fechaNacimiento2 = new java.sql.Date(fechaNacimiento1.getTime());
        return fechaNacimiento2;
    }

}
