package postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String patron = "A[1-9]";
        String codigo;
        boolean correcto;
        do {
             System.out.print("Ingrese código del Alumno? ");// A1, A2, A3
             codigo = sc.next().toUpperCase();
             correcto = codigo.matches(patron);
             if(!correcto) {
                System.out.println("CODIGO NO VALIDO");
             }
        }while(!correcto);
        System.out.println(codigo);
        List<Alumno> alumnos_al = getListaAlumnos();
        Alumno alumno = buscarAlumno(alumnos_al,codigo);
        if(alumno != null) {
           System.out.println(alumno);
        }else {
           System.out.println("Ingrese nombre del alumno? " );
           String nombre = sc.next();
           int n = insertarAlumno(new Alumno(codigo,nombre));
           if(n == 1) {
               System.out.println("OK: INSERTAR ALUMNO");
           }else {
               System.out.println("ERROR: INSERTAR ALUMNO");
           }
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

    public static List<Alumno> getListaAlumnos() {
        List<Alumno> alumnos_al = new ArrayList<>();
        Connection conexion = getConexion();
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT * FROM Alumno";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String idAlumno = rs.getString(1);
                    String nombre = rs.getString(2);
                    Alumno alumno = new Alumno(idAlumno,nombre);
                    alumnos_al.add(alumno);
                }
                System.out.println("OK: SELECT");
            } catch (SQLException e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
        return alumnos_al;
    }
    
    public static Alumno buscarAlumno(List<Alumno> alumnos_al, String codigo) {
        for(Alumno alumno: alumnos_al) {
            if(codigo.equalsIgnoreCase(alumno.getIdAlumno())) {
               return alumno; //ENCONTRO
            }
        }
        return null; // NO ENCONTRADO
    }
    
    public static int insertarAlumno(Alumno alumno) {
        Connection conexion = getConexion();
        int n = 0;
        if(conexion != null) {
           String query = "INSERT INTO Alumno1 (id_alumno,nombre) VALUES (?,?)" ;
           try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1,alumno.getIdAlumno());
                ps.setString(2,alumno.getNombre());
                n = ps.executeUpdate();
           }catch(SQLException e) {
               System.out.println("ERROR: INSERT");
           }
        }else {
            System.out.println("ERROR: CONEXION");
        }
        return n;
    }

}
