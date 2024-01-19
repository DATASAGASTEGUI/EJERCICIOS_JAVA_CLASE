package hsqldb_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class OperacionesCRUD {

    Connection conexion;

    public OperacionesCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public void mostrarTodosRegistros() {
        if (this.conexion != null) {
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

}
