package menu_conexion_jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.text.SimpleDateFormat;

public class OperacionesCRUD {

    Connection conexion;

    public OperacionesCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public void mostrarTodosRegistros() {
        if (this.conexion != null) {
            String query = "SELECT * FROM ALUMNO";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                cabecera();
                while (rs.next()) {
                    int idAlumno = rs.getInt(1);//rs.getInt("id_alumno");
                    String nombre = rs.getString(2);
                    String apaterno = rs.getString(3);
                    String amaterno = rs.getString(4);
                    java.util.Date fechaNacimiento = rs.getDate(5);
                    double estatura = rs.getDouble(6);
                    boolean casado = rs.getBoolean(7);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    cuerpo(idAlumno, nombre, apaterno, amaterno, sdf.format(fechaNacimiento),
                            estatura, casado);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY");
            }
            System.out.println("OK CONEXION");
        } else {
            System.out.println("ERROR CONEXION");
        }
    }

    public void cabecera() {
        System.out.printf("%10s %-10s %-10s %-10s %-10s %10s %-10s\n", "IDALUMNO", "NOMBRE", "APATERNO", "AMATERNO", "NACIMIENTO", "ESTATURA", "CASADO");
        System.out.printf("%10s %-10s %-10s %-10s %-10s %10s %-10s\n", "--------", "------", "--------", "--------", "----------", "--------", "------");
    }

    public void cuerpo(int idAlumno, String nombre, String apaterno,
            String amaterno, String nacimiento, double estatura,
            boolean casado) {
        System.out.printf("%10d %-10s %-10s %-10s %-10s %10.2f %-10s\n", idAlumno, nombre, apaterno, amaterno, nacimiento, estatura, casado);

    }

    public void mostrarTodasColumnaTabla() {
        if (this.conexion != null) {
            String query = "SHOW COLUMNS FROM ALUMNO";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                System.out.printf("%-24s %-12s\n", "FIELD", "TYPE");
                System.out.printf("%-24s %-12s\n", "-----", "----");
                while (rs.next()) {
                    String field = rs.getString("Field");
                    String type = rs.getString("Type");
                    System.out.printf("%-24s %-12s\n", field, type);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY");
            }
            System.out.println("OK CONEXION");
        } else {
            System.out.println("ERROR CONEXION");
        }
    }

    public void mostrarTodasBaseDatosServidor() {
        if (this.conexion != null) {
            String query = "SHOW DATABASES";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                System.out.printf("%-24s\n", "DATABASE");
                System.out.printf("%-24s\n", "--------");
                while (rs.next()) {
                    String database = rs.getString("Database");
                    System.out.printf("%-24s\n", database);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY");
            }
            System.out.println("OK CONEXION");
        } else {
            System.out.println("ERROR CONEXION");
        }
    }

    public void crearTabla() {
        if (this.conexion != null) {
            String querey = "CREATE TABLE Trabajador (\n"
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

    public void migrarCsvToSql() {
        String fila = "";
        String[] p;
        File f;
        FileReader fr;
        BufferedReader br;

        try {
            f = new File("data/trabajador.csv");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((fila = br.readLine()) != null) {
                p = fila.split(";");
                String idTrabajador = p[0];
                String nombre = p[1];
                String apaterno = p[2];
                int tipoTrabajador = Integer.parseInt(p[3]);
                String parametrosCalculoSueldo = p[4];
                insertarRegistro(idTrabajador, nombre, apaterno, tipoTrabajador, parametrosCalculoSueldo);
            }
        } catch (Exception e) {
            System.out.println("ERROR: LECTURA");
        }
    }

    public void insertarRegistro(String idTrabajador,
            String nombre,
            String apaterno,
            int tipoTrabajador,
            String parametrosCalculoSueldo) {
        if (this.conexion != null) {
            String query = "INSERT INTO Trabajador (idTrabajador,nombre,apaterno,tipo_trabajador,parametros_sueldo) VALUE (?,?,?,?,?)";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, idTrabajador);
                ps.setString(2, nombre);
                ps.setString(3, apaterno);
                ps.setInt(4, tipoTrabajador);
                ps.setString(5, parametrosCalculoSueldo);
                ps.executeUpdate();
                System.out.println("OK: INSERT");
            } catch (SQLException ex) {
                System.out.println("ERROR: INSERT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public void contarNombresDistintosTabla() {
        if (this.conexion != null) {
            String query = "SELECT COUNT(DISTINCT nombre) AS CANTIDAD FROM Trabajador";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cantidad = rs.getInt("CANTIDAD");
                    //int cantidad = rs.getInt(1);
                    System.out.println("CANTIDAD NOMBRES DISTINTOS: " + cantidad);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public void mostrarTodosNombresDistintos() {
        if (this.conexion != null) {
            String query = "SELECT DISTINCT nombre FROM Trabajador ORDER BY nombre ASC";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    String nombre = rs.getString(1);
                    System.out.printf("%5d %4s %-15s\n",(i+1), "   " ,nombre);
                    i++;
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

}
