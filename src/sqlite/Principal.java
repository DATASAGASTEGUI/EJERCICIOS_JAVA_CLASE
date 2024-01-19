package sqlite;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {
        String basedatos = "C:\\CERTIFICADO\\PYTHON\\Ejemplo30\\tienda.sqlite";

        Connection conexion = BaseDatosSqlite.getConexion(basedatos);

        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT * FROM Trabajador";

            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String id_trabajador = rs.getString(1);
                    String nombre = rs.getString(2);
                    String apaterno = rs.getString(3);
                    int tipo_trabajador = rs.getInt(4);
                    String parametros_sueldo = rs.getString(5);
                    System.out.println(id_trabajador + ";" + nombre + ";"
                            + apaterno + ";" + tipo_trabajador + ";"
                            + parametros_sueldo);
                }
            } catch (Exception e) {
                System.out.println("ERROR: QUERY");
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

}
