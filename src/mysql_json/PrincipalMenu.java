package mysql_json;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class PrincipalMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/world_x";
        String usuario = "root";
        String clave = "12345678";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            conexion = null;
        }

        do {
            cls();
            System.out.println("MENU PRINCIPAL");
            System.out.println("--------------");
            System.out.println("[1] MOSTRAR QUE FORMA GOBIERNO TIENE UN PAIS");
            System.out.println("[2] MOSTRAR LOS PAISES QUE TIEENEN UNA FORMA DE GOBIERNO DADA POR EL USUARIO");
            /*
            System.out.println("[3] MOSTRAR LOS DISTINTOS TIPOS DE PARTOS QUE EXISTEN");
            System.out.println("[4] MOSTRAR LAS CONSULTAS QUE FUERON LEGRADO Y TAMBIEN QUE CUENTE");
            System.out.println("[5] CUANTAS CONSULTAS HUBIERON EN EL AÑO 2015");
            System.out.println("[6] CREAR 3 TABLAS QUE CONTENDRAN POR SEPARADO INDUCCION, CESAREA, LEGRADO");
            System.out.println("[7] MOSTRAR CANTIDAD DE CONSULTAS POR TIPO DE PARTO");
            System.out.println("[8] MOSTRAR CANTIDAD DE CONSULTAS POR TIPO NOMBRE MEDICO");
             */
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
                    //proceso3(conexion);
                    pause();
                    break;
                case "4":
                    cls();
                    //proceso4(conexion);
                    pause();
                    break;
                case "5":
                    cls();
                    //proceso5(conexion);
                    pause();
                    break;
                case "6":
                    cls();
                    //submenu6(conexion);
                    break;
                case "7":
                    cls();
                    //crud.mostrarConsultaAgrupamientoTipoParto();
                    pause();
                    break;
                case "8":
                    cls();
                    //crud.mostrarConsultaAgrupamientoNombreMedico();
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
        System.out.println("[1] MOSTRAR QUE FORMA GOBIERNO TIENE UN PAIS");
        System.out.println("--------------------------------------------");
        if (conexion != null) {
            System.out.print("Ingrese nombre del pais? ");
            sc.nextLine();
            String pais = sc.nextLine();
            String query = "SELECT JSON_UNQUOTE(doc->'$.government.GovernmentForm') \n"
                    + "FROM countryinfo\n"
                    + "WHERE doc->'$.Name' = ?";

            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, pais);
                ResultSet rs = ps.executeQuery();
                String gobierno = "";
                while (rs.next()) {
                    gobierno = rs.getString(1);
                }
                if (!gobierno.equalsIgnoreCase("")) {
                    System.out.println("Pais          : " + pais);
                    System.out.println("Forma Gobierno: " + gobierno);
                } else {
                    System.out.println("No existe el pais ingresado");
                }
            } catch (SQLException e) {

            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }
        
    public static void proceso2(Connection conexion) {
        System.out.println("[2] MOSTRAR LOS PAISES QUE TIEENEN UNA FORMA DE GOBIERNO DADA POR EL USUARIO");
        System.out.println("----------------------------------------------------------------------------");
        if (conexion != null) {
            mostrarTodasFomasGobierno(conexion);
            System.out.print("Ingrese una forma de gobierno a buscar? ");
            sc.nextLine(); //Limpia el buffer de entrada
            String gobierno = sc.nextLine();
            String query = "SELECT JSON_UNQUOTE(doc->'$.Name') \n" +
                           "FROM countryinfo \n" +
                           "WHERE doc->'$.government.GovernmentForm' = ?";

            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, gobierno);
                ResultSet rs = ps.executeQuery();
                String pais = "";
                while (rs.next()) {
                    pais = rs.getString(1);
                    System.out.println(pais);
                }
            } catch (SQLException e) {

            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void mostrarTodasFomasGobierno(Connection conexion) {
        if (conexion != null) {
            String query = "SELECT DISTINCT JSON_UNQUOTE(doc->'$.government.GovernmentForm')\n"
                    + "FROM countryinfo";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String gobierno = rs.getString(1);
                    System.out.println(gobierno);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: QUERY");
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
