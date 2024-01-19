package mariadb_01;

import java.sql.*;

public class PrincipalSelect {


    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos("jdbc:mysql",
                "localhost",
                3306,
                "empresa",
                "root",
                ""
        );
        Connection conexion = bd.getConexion();
        //mostrarTodosRegistros(conexion);
        crearTabla(conexion);
        
    }
    
    public static void mostrarTodosRegistros(Connection conexion) {
        if (conexion != null) {
            String query = "SELECT * FROM TRABAJADOR";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String idTrabajador = rs.getString(1);
                    String nombre = rs.getString(2);
                    String apaterno = rs.getString(3);
                    int tipoTrabajador = rs.getInt(4);
                    String parametrosSueldo = rs.getString(5);
                    System.out.println(idTrabajador + ";"
                            + nombre + ";"
                            + apaterno + ";"
                            + tipoTrabajador + ";"
                            + parametrosSueldo);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }
    
        public static void crearTabla(Connection conexion) {
        if (conexion != null) {
            String querey = "CREATE TABLE Trabajador1 (\n"
                    + "idTrabjador        VARCHAR(6)  NOT NULL PRIMARY KEY,\n"
                    + "nombre             VARCHAR(20) NOT NULL,\n"
                    + "apaterno           VARCHAR(30) NOT NULL,\n"
                    + "tipo_trabajador    INT         NOT NULL,\n"
                    + "parametros_sueldo  VARCHAR(15) NOT NULL \n"
                    + ")";
            try {
                PreparedStatement ps = conexion.prepareStatement(querey);
                ps.execute();
                System.out.println("OK: CREAR TABLA");
            } catch (SQLException ex) {
                System.out.println("ERROR: CREAR TABLA");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }
    
}
