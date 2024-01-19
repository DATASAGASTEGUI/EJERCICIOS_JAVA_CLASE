package tarea_mysql_salud;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos("jdbc:mysql",
                "localhost",
                3306,
                "salud",
                "root",
                "12345678");
        Connection conexion = bd.getConexion();
        OperacionesCRUD crud = new OperacionesCRUD(conexion);
        do {
            cls();
            System.out.println("MENU PRINCIPAL");
            System.out.println("--------------");
            System.out.println("[1] MOSTRAR TODOS LOS MEDICOS DISTINTOS");
            System.out.println("[2] CUANTOS MEDICOS DISTINTOS EXISTEN");
            System.out.println("[3] MOSTRAR LOS DISTINTOS TIPOS DE PARTOS QUE EXISTEN");
            System.out.println("[4] MOSTRAR LAS CONSULTAS QUE FUERON LEGRADO Y TAMBIEN QUE CUENTE");
            System.out.println("[5] CUANTAS CONSULTAS HUBIERON EN EL AÑO 2015");
            System.out.println("[6] CREAR 3 TABLAS QUE CONTENDRAN POR SEPARADO INDUCCION, CESAREA, LEGRADO");
            System.out.println("[7] MOSTRAR CANTIDAD DE CONSULTAS POR TIPO DE PARTO");
            System.out.println("[8] MOSTRAR CANTIDAD DE CONSULTAS POR TIPO NOMBRE MEDICO");

            System.out.println("[0] SALIR");

            System.out.print("INGRESE OPCION? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    cls();
                    proceso1(conexion);
                    pause();
                    break;
                case "2":
                    cls();
                    proceso2(conexion);
                    pause();
                    break;
                case "3":
                    cls();
                    proceso3(conexion);
                    pause();
                    break;
                case "4":
                    cls();
                    proceso4(conexion);
                    pause();
                    break;
                case "5":
                    cls();
                    proceso5(conexion);
                    pause();
                    break;
                case "6":
                    cls();
                    submenu6(conexion);
                    break;
                case "7":
                    cls();
                    crud.mostrarConsultaAgrupamientoTipoParto();
                    pause();
                    break;
                case "8":
                    cls();
                    crud.mostrarConsultaAgrupamientoNombreMedico();
                    pause();
                    break;
                case "0":
                    cls();
                    System.out.println("GRACIAS POR SU VISITA");
                    pause();
                    System.exit(0);
            }
        } while (true);

    }

    public static void proceso1(Connection conexion) {
        System.out.println("[1] MOSTRAR TODOS LOS MEDICOS DISTINTOS");
        System.out.println("---------------------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT DISTINCT nombreMedico FROM Consulta ORDER BY nombreMedico";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String nombreMedico = rs.getString(1);
                    System.out.println(nombreMedico);
                }
            } catch (Exception e) {
                System.out.println("ERROR: SELECT");
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso2(Connection conexion) {
        System.out.println("[2] CUANTOS MEDICOS DISTINTOS EXISTEN");
        System.out.println("-------------------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT COUNT(DISTINCT nombreMedico) \n"
                    + "FROM Consulta\n"
                    + "ORDER BY nombreMedico";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cantidad = rs.getInt(1);
                    System.out.println("CANTIDAD MEDICOS DISTINTOS: " + cantidad);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso3(Connection conexion) {
        System.out.println("[3] MOSTRAR LOS DISTINTOS TIPOS DE PARTOS QUE EXISTEN");
        System.out.println("-----------------------------------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT DISTINCT deinpr FROM Consulta ORDER BY deinpr";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tipoParto = rs.getString(1);
                    System.out.println(tipoParto);
                }
            } catch (Exception e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso4(Connection conexion) {
        System.out.println("[4] MOSTRAR LAS CONSULTAS QUE FUERON LEGRADO Y TAMBIEN QUE CUENTE");
        System.out.println("-----------------------------------------------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query1 = "SELECT COUNT(*) FROM Consulta WHERE deinpr = 'LEGRADO';";
            String query2 = "SELECT * FROM Consulta WHERE deinpr = 'LEGRADO'";
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                //QUERY 1
                ps = conexion.prepareStatement(query1);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int cantidad = rs.getInt(1);
                    System.out.println("CANTIDAD LEGRADO: " + cantidad);
                }
                //QUERY 2
                ps = conexion.prepareStatement(query2);
                rs = ps.executeQuery();
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "NUMERO", "FECHA", "MEDICO", "TPARTO", "PROCEDENCIA");
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "------", "-----", "------", "------", "-----------");
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    String fecha = rs.getDate(2).toString();
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);
                    System.out.printf("%6d %-12s %-40s %-10s %-12s\n", Integer.parseInt(numeroConsulta), fecha, nombreMedico, deinpr, procedencia);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso5(Connection conexion) {
        System.out.println("[5] CUANTAS CONSULTAS HUBIERON EN EL AÑO 2015");
        System.out.println("---------------------------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT COUNT(*) FROM Consulta WHERE YEAR(fecha) = 2015";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cantidad = rs.getInt(1);
                    System.out.println("CANTIDAD CONSULTAS AÑO 2015: " + cantidad);
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void submenu6(Connection conexion) {
        boolean bandera = false;
        do {
            cls();
            System.out.println("SUBMENU: [6] CREAR 3 TABLAS QUE CONTENDRAN POR SEPARADO INDUCCION, CESAREA, LEGRADO");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("[1] CREAR TABLA INDUCCION");
            System.out.println("[2] CREAR TABLA CESAREA");
            System.out.println("[3] CREAR TABLA LEGRADO");
            System.out.println("[4] LLENAR TABLA INDUCCION");
            System.out.println("[5] LLENAR TABLA CESAREA");
            System.out.println("[6] LLENAR TABLA LEGRADO");
            System.out.println("[7] MOSTRAR TABLA INDUCCION");
            System.out.println("[8] MOSTRAR TABLA CESAREA");
            System.out.println("[9] MOSTRAR TABLA LEGRADO");
            System.out.println("[0] SALIR");

            System.out.print("INGRESE OPCION? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    cls();
                    proceso6_1(conexion);
                    pause();
                    break;
                case "2":
                    cls();
                    proceso6_2(conexion);
                    pause();
                    break;
                case "3":
                    cls();
                    proceso6_3(conexion);
                    pause();
                    break;
                case "4":
                    cls();
                    proceso6_4(conexion);
                    pause();
                    break;
                case "5":
                    cls();
                    proceso6_5(conexion);
                    pause();
                    break;
                case "6":
                    cls();
                    proceso6_6(conexion);
                    pause();
                    break;
                case "7":
                    cls();
                    proceso6_7(conexion);
                    pause();
                    break;
                case "8":
                    cls();
                    proceso6_8(conexion);
                    pause();
                    break;
                case "9":
                    cls();
                    proceso6_9(conexion);
                    pause();
                    break;
                case "0":
                    cls();
                    bandera = true;
            }
        } while (bandera != true);

    }

    public static void proceso6_1(Connection conexion) {
        System.out.println("[6.1] CREAR TABLA INDUCCION");
        System.out.println("---------------------------");
        if (conexion != null) {
            String querey = "CREATE TABLE IF NOT EXISTS Induccion (\n"
                    + "   numeroConsulta VARCHAR(10) NOT NULL PRIMARY KEY,\n"
                    + "   fecha          DATE        NOT NULL,\n"
                    + "   nombreMedico   VARCHAR(50) NOT NULL,\n"
                    + "   deinpr         VARCHAR(20) NOT NULL,\n"
                    + "   procedencia    VARCHAR(20) NOT NULL\n"
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

    public static void proceso6_2(Connection conexion) {
        System.out.println("[6.2] CREAR TABLA CESAREA");
        System.out.println("-------------------------");
        if (conexion != null) {
            String querey = "CREATE TABLE IF NOT EXISTS Cesarea (\n"
                    + "   numeroConsulta VARCHAR(10) NOT NULL PRIMARY KEY,\n"
                    + "   fecha          DATE        NOT NULL,\n"
                    + "   nombreMedico   VARCHAR(50) NOT NULL,\n"
                    + "   deinpr         VARCHAR(20) NOT NULL,\n"
                    + "   procedencia    VARCHAR(20) NOT NULL\n"
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

    public static void proceso6_3(Connection conexion) {
        System.out.println("[6.3] CREAR TABLA LEGRADO");
        System.out.println("-------------------------");
        if (conexion != null) {
            String querey = "CREATE TABLE IF NOT EXISTS Legrado (\n"
                    + "   numeroConsulta VARCHAR(10) NOT NULL PRIMARY KEY,\n"
                    + "   fecha          DATE        NOT NULL,\n"
                    + "   nombreMedico   VARCHAR(50) NOT NULL,\n"
                    + "   deinpr         VARCHAR(20) NOT NULL,\n"
                    + "   procedencia    VARCHAR(20) NOT NULL\n"
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

    public static void proceso6_4(Connection conexion) {
        System.out.println("[6.4] LLENAR TABLA INDUCCION");
        System.out.println("----------------------------");
        if (conexion != null) {
            String query1 = "SELECT * FROM CONSULTA WHERE DEINPR = 'INDUCCION'";
            String query2 = "INSERT INTO Induccion(numeroConsulta,fecha,nombreMedico,deinpr,procedencia)\n"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ps1, ps2;
            try {
                ps1 = conexion.prepareStatement(query1);
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    Date fecha = rs.getDate(2);
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);

                    ps2 = conexion.prepareStatement(query2);
                    ps2.setString(1, numeroConsulta);
                    ps2.setDate(2, fecha);
                    ps2.setString(3, nombreMedico);
                    ps2.setString(4, deinpr);
                    ps2.setString(5, procedencia);
                    ps2.executeUpdate();
                    System.out.println("OK: QUERY1 Y QUERY2");
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY1 Y QUERY2");
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso6_5(Connection conexion) {
        System.out.println("[6.5] LLENAR TABLA CESAREA");
        System.out.println("--------------------------");
        if (conexion != null) {
            String query1 = "SELECT * FROM CONSULTA WHERE DEINPR = 'CESAREA'";
            String query2 = "INSERT INTO Cesarea(numeroConsulta,fecha,nombreMedico,deinpr,procedencia)\n"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ps1, ps2;
            try {
                ps1 = conexion.prepareStatement(query1);
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    Date fecha = rs.getDate(2);
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);

                    ps2 = conexion.prepareStatement(query2);
                    ps2.setString(1, numeroConsulta);
                    ps2.setDate(2, fecha);
                    ps2.setString(3, nombreMedico);
                    ps2.setString(4, deinpr);
                    ps2.setString(5, procedencia);
                    ps2.executeUpdate();
                    System.out.println("OK: QUERY1 Y QUERY2");
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY1 Y QUERY2");
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso6_6(Connection conexion) {
        System.out.println("[6.6] LLENAR TABLA LEGRADO");
        System.out.println("--------------------------");
        if (conexion != null) {
            String query1 = "SELECT * FROM CONSULTA WHERE DEINPR = 'LEGRADO'";
            String query2 = "INSERT INTO Legrado(numeroConsulta,fecha,nombreMedico,deinpr,procedencia)\n"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ps1, ps2;
            try {
                ps1 = conexion.prepareStatement(query1);
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    Date fecha = rs.getDate(2);
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);

                    ps2 = conexion.prepareStatement(query2);
                    ps2.setString(1, numeroConsulta);
                    ps2.setDate(2, fecha);
                    ps2.setString(3, nombreMedico);
                    ps2.setString(4, deinpr);
                    ps2.setString(5, procedencia);
                    ps2.executeUpdate();
                    System.out.println("OK: QUERY1 Y QUERY2");
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY1 Y QUERY2");
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso6_7(Connection conexion) {
        System.out.println("[6.7] MOSTRAR TABLA INDUCCION");
        System.out.println("-----------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT * FROM Induccion ORDER BY numeroConsulta";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "NUMERO", "FECHA", "MEDICO", "TPARTO", "PROCEDENCIA");
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "------", "-----", "------", "------", "-----------");
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    String fecha = rs.getDate(2).toString();
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);
                    System.out.printf("%6d %-12s %-40s %-10s %-12s\n", Integer.parseInt(numeroConsulta), fecha, nombreMedico, deinpr, procedencia);
                }
            } catch (Exception e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso6_8(Connection conexion) {
        System.out.println("[6.8] MOSTRAR TABLA CESAREA");
        System.out.println("---------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT * FROM Cesarea ORDER BY numeroConsulta";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "NUMERO", "FECHA", "MEDICO", "TPARTO", "PROCEDENCIA");
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "------", "-----", "------", "------", "-----------");
                Object[] v = null;
                List<Object[]> registros_al = new ArrayList<>();
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    String fecha = rs.getDate(2).toString();
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);
                    v = new Object[5];
                    v[0] = numeroConsulta;
                    v[1] = nombreMedico;
                    v[2] = fecha;
                    v[3] = deinpr;
                    v[4] = procedencia;
                    registros_al.add(v);
                    System.out.printf("%6d %-12s %-40s %-10s %-12s\n", Integer.parseInt(numeroConsulta), fecha, nombreMedico, deinpr, procedencia);
                }
                for(Object[] v1: registros_al) {
                    System.out.println(Arrays.asList(v1));
                }
            } catch (Exception e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void proceso6_9(Connection conexion) {
        System.out.println("[6.9] MOSTRAR TABLA LEGRADO");
        System.out.println("---------------------------");
        if (conexion != null) {
            System.out.println("OK: CONEXION");
            String query = "SELECT * FROM Legrado ORDER BY numeroConsulta";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "NUMERO", "FECHA", "MEDICO", "TPARTO", "PROCEDENCIA");
                System.out.printf("%6s %-12s %-40s %-10s %-12s\n", "------", "-----", "------", "------", "-----------");
                while (rs.next()) {
                    String numeroConsulta = rs.getString(1);
                    String fecha = rs.getDate(2).toString();
                    String nombreMedico = rs.getString(3);
                    String deinpr = rs.getString(4);
                    String procedencia = rs.getString(5);
                    System.out.printf("%6d %-12s %-40s %-10s %-12s\n", Integer.parseInt(numeroConsulta), fecha, nombreMedico, deinpr, procedencia);
                }
            } catch (Exception e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void pause() {
        try {
            System.out.print("\nPresiona una tecla para continuar...");
            System.in.read();
        } catch (IOException e) {
        }
    }

    public static void cls() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
