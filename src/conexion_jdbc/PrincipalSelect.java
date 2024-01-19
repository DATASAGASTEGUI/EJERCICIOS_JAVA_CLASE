package conexion_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/*
       PARTES DE UNA CONEXION JDBC
       ---------------------------
       PROTOCOLO:       jdbc:mysql
       IP DEL SERVIDOR: 127.0.0.1 = localhost
       PUERTO:          3306
       NOMBRE DATABASE: universidad
 */

public class PrincipalSelect {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/universidad";
        String usuario = "root";
        String clave = "12345678";
        String query = "SELECT * FROM ALUMNO";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            if (conexion != null) {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idAlumno = rs.getInt(1);//rs.getInt("id_alumno");
                    String nombre = rs.getString(2);
                    String apaterno = rs.getString(3);
                    String amaterno = rs.getString(4);
                    Date fechaNacimiento = rs.getDate(5);
                    double estatura = rs.getDouble(6);
                    boolean esCasado = rs.getBoolean(7);
                    //FORMATEAR LA FECHA
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(idAlumno + ";"
                            + nombre + ";"
                            + apaterno + ";"
                            + amaterno + ";"
                            + sdf.format(fechaNacimiento) + ";" // 15/10/1998
                            + estatura + ";"
                            + esCasado + ";"
                            + edad(fechaNacimiento));
                }
            } else {
                System.out.println("ERROR CONEXION");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SINTAXIS QUERY");
        }

    }

    public static int edad(Date fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] parte = sdf.format(fechaNacimiento).split("-");
        // Supongamos que tienes una fecha de nacimiento
        LocalDate nacimiento = LocalDate.of(Integer.parseInt(parte[0]),
                Integer.parseInt(parte[1]),
                Integer.parseInt(parte[2]));
        // Obtén la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Calcula la diferencia entre la fecha actual y la fecha de nacimiento
        Period periodo = Period.between(nacimiento, fechaActual);
        // Obtén la edad a partir del periodo
        int edad = periodo.getYears();
        return edad;
    }

}
