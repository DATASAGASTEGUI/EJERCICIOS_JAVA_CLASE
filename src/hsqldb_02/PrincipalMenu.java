package hsqldb_02;

import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class PrincipalMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseDatosHsqldb bdh = new BaseDatosHsqldb();
        Connection conexion = bdh.getConexion();
        OperacionesCRUD crud = new OperacionesCRUD(conexion);
        do {
            cls();
            System.out.println("MENU");
            System.out.println("----");
            System.out.println("[1] MOSTRAR TODOS LOS REGISTROS");
            
            
            System.out.println("[2] MOSTRAR TODAS LAS COLUMNAS DE LA TABLA");
            System.out.println("[3] LISTAR TODAS LAS BASES DE DATOS EN EL SERVIDOR");
            System.out.println("[4] MIGRAR ARCHIVO CSV TO MYSQL");
            System.out.println("[5] CREAR TABLA");
            System.out.println("[6] CUANTOS NOMBRES DISTINTOS EXISTEN EN LA TABLA");
            System.out.println("[7] MOSTRAR TODOS LOS NOMBRES DISTINTOS");
            System.out.println("[0] SALIR");

            System.out.print("INGRESE OPCION? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    cls();
                    System.out.println("[1] MOSTRAR TODOS LOS REGISTROS");
                    System.out.println("-------------------------------");
                    crud.mostrarTodosRegistros();
                    pause();
                    break;
                case "2":
                    cls();
                    System.out.println("[2] MOSTRAR TODAS LAS COLUMNAS DE LA TABLA");
                    System.out.println("------------------------------------------");
                    //crud.mostrarTodasColumnaTabla();
                    pause();
                    break;
                case "3":
                    cls();
                    System.out.println("[3] LISTAR TODAS LAS BASES DE DATOS EN EL SERVIDOR");
                    System.out.println("--------------------------------------------------");
                    //crud.mostrarTodasBaseDatosServidor();
                    pause();
                    break;
                case "4":
                    cls();
                    System.out.println("[4] MIGRAR ARCHIVO CSV TO MYSQL");
                    System.out.println("-------------------------------");
                    //crud.migrarCsvToSql();
                    pause();
                    break;
                case "5":
                    cls();
                    System.out.println("[5] CREAR TABLA");
                    System.out.println("---------------");
                    //crud.crearTabla();
                    pause();
                    break;
                case "6":
                    cls();
                    System.out.println("[6] CUANTOS NOMBRES DISTINTOS EXISTEN EN LA TABLA");
                    System.out.println("-------------------------------------------------");
                    //crud.contarNombresDistintosTabla();
                    pause();
                    break;
                case "7":
                    cls();
                    System.out.println("[7] MOSTRAR TODOS LOS NOMBRES DISTINTOS");
                    System.out.println("---------------------------------------");
                    //crud.mostrarTodosNombresDistintos();
                    pause();
                    break;

                case "0":
                    System.out.println("GRACIAS POR SI VISITA");
                    System.exit(0);
            }
        } while (true);

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
