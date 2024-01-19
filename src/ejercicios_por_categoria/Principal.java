package ejercicios_por_categoria;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            cls();
            System.out.println("MENU PRINCIPAL");
            System.out.println("--------------");
            System.out.println("A. ESTRUCTURA SECUENCIAL");
            System.out.println("B. ESTRUCTURA CONDICIONA BINARIO");
            System.out.println("C. ESTRUCTURA CONDICIONAL MULTIPLE");
            System.out.println("D. ESTRUCTURA BUCLE PARA (FOR)");
            System.out.println("H. ARRAY UNIDIMENSIONAL (VECTOR)");
            System.out.println("J. FUNCION");
            System.out.println("0. SALIR");
            System.out.print("INGRESE OPCION? ");
            String opcion = sc.next();

            switch (opcion) {
                case "A":
                    cls();
                    submenuA();
                    pause();
                    break;
                case "B":
                    cls();
                    submenuB();
                    //pause();
                    break;
                case "C":
                    cls();
                    submenuC();
                    pause();
                    break;
                case "D":
                    cls();
                    submenuD();
                    pause();
                    break;
                case "H":
                    cls();
                    submenuH();
                    pause();
                    break;
                case "J":
                    cls();
                    submenuJ();
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

    //EJERCICIOS SUBMENU B: ESTRUCTURA CONDICIONAL BINARIA
    public static void ejercicio1B() {
        System.out.println("EJERCICIO 1");
        System.out.println("-----------");
        System.out.print("INGRESE NUMERO ENTERO POSITIVO? ");
        int numero = sc.nextInt();
        if ((numero % 2) == 0) {
            System.out.println("PAR");
        } else {
            System.out.println("IMPAR");
        }
    }

    public static void ejercicio2B() {
        System.out.println("EJERCICIO 2");
        System.out.println("-----------");
        System.out.print("INGRESE A? ");
        int a = sc.nextInt();
        System.out.print("INGRESE B? ");
        int b = sc.nextInt();
        double x = -b / (double) a;
        System.out.println("X:" + x);
    }

    public static void ejercicio3B() {
        System.out.println("EJERCICIO 3");
        System.out.println("-----------");
        System.out.println("INGRESE LOS MINUTOS HABLADOS? ");
        int minutos = sc.nextInt();
        int pago = 0;
        if (minutos <= 5) {
            pago = minutos * 1;
        } else {
            pago = (5 * 1) + (minutos - 5) * 2;
        }
        System.out.println("Pago: " + pago);
    }

    //EJERCICIOS SUBMENU C: ESTRUCTURA CONDICIONAL MULTIPLE
    public static void ejercicio1C() {
        System.out.println("EJERCICIO 1");
        System.out.println("-----------");
        System.out.print("INGRESE DIA DE LA SEMANA NUMERO ENTERO? ");
        String n = sc.next();
        switch (n) {
            case "1":
                System.out.println("DIA DE LA SEMANA LUNES");
                break;
            case "2":
                System.out.println("DIA DE LA SEMANA MARTES");
                break;
            case "3":
                System.out.println("DIA DE LA SEMANA MIERCOLES");
                break;
            case "4":
                System.out.println("DIA DE LA SEMANA JUEVES");
                break;
            case "5":
                System.out.println("DIA DE LA SEMANA VIERNES");
                break;
            case "6":
                System.out.println("DIA DE LA SEMANA SABADO");
                break;
            case "7":
                System.out.println("DIA DE LA SEMANA DOMINGO");
                break;
            default:
                System.out.println("DIA DE LA SEMANA NO EXISTE");
                break;
        }

    }

    //EJERCICIOS SUBMENU D: ESTRUCTURA BUCLE PARA (FOR)
    public static void ejercicio1D() {
        System.out.println("EJERCICIO 1");
        System.out.println("-----------");
        System.out.print("INGRESE FIN DE LA SERIE N? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "  ");
        }
    }

    public static void ejercicio4D() {
        System.out.println("EJERCICIO 4");
        System.out.println("-----------");
        System.out.print("INGRESE NUMERO ENTERO? ");
        int n = sc.nextInt(); //5 = 5 3 1
        if (n % 2 != 0) {
            for (int i = n; i >= 1; i = i - 2) {
                System.out.print(i + "   ");
            }
        } else {
            for (int i = n; i >= 2; i = i - 2) {
                System.out.print(i + "   ");
            }
        }
        System.out.println();
    }

    //EJERCICIOS SUBMENU H: ARRAY UNIDIMENSIONAL (VECTOR)
    public static void ejercicio1H() {
        System.out.println("EJERCICIO 1");
        System.out.println("-----------");
        System.out.print("INGRESE EL TAMAÑO DEL VECTOR? ");
        int n = sc.nextInt();
        int[] vector = new int[n]; //VECTOR DINAMICO SE CREA EN TIEMPO DE EJECUCION
        //LLENAR EL VECTOR DINAMICAMENTE
        for (int i = 0; i < vector.length; i++) {
            System.out.print("INGRESE UN NUMERO ENTERO? ");
            vector[i] = sc.nextInt();
        }
        //RECORRER EL VECTOR PARA MOSTRARLO
        for (int x : vector) {
            System.out.print(x + "   ");
        }
    }

    public static void ejercicio8H() {
        System.out.println("EJERCICIO 8");
        System.out.println("-----------");
        System.out.print("INGRESE EL TAMAÑO DEL VECTOR? ");
        int n = sc.nextInt();
        int[] vector = new int[n]; //VECTOR DINAMICO SE CREA EN TIEMPO DE EJECUCION
        for (int i = 0; i < vector.length; i++) {
            System.out.print("INGRESE UN NUMERO ENTERO? ");
            vector[i] = sc.nextInt();
        }
        //RECORRER EL VECTOR PARA MOSTRARLO
        int p = 0, q = 0;
        for (int x : vector) {
            if (x % 2 == 0) {
                p++; //p = p + 1;
            } else {
                q++;
            }
        }
        System.out.println("Cantidad Pares  : " + p);
        System.out.println("Cantidad Impares: " + q);

    }

    //EJERCICIOS SUBMENU J: FUNCION(METODO)
    public static void ejercicio2J() {
        System.out.println("EJERCICIO 2");
        System.out.println("-----------");
        try {
            System.out.print("INGRESE NUMERO REAL? ");
            double numeroReal = sc.nextDouble(); //12,5
            int cantidad = contarCantidadCaracteres(numeroReal); //SE LE INVOCA CON EL NOMBRE DEL METODO(FUNCION)
            System.out.println("CANTIDAD CARACTERES: " + cantidad);
        }catch(Exception e) {
            System.out.println("ENTRADA INCORRECTA");
        }
    }

    public static int contarCantidadCaracteres(double numeroReal) { // 12.5 ---> "12.5".length()
        String cadena = numeroReal + "";
        //String cadena = String.valueOf(numeroReal);
        return cadena.length();
    }
    
    public static void submenuA() {

    }

    public static void submenuB() {
        boolean bandera = false;

        do {
            cls();
            System.out.println("SUBMENU_B: ESTRUCTURA CONDICIONA BINARIO");
            System.out.println("----------------------------------------");

            System.out.println("1. DETERMINA SI UN NUMERO ES PAR O IMPAR");
            System.out.println("2. RESOLVER UNA ECUACIONDE PRIMER GRADO");
            System.out.println("3. CALCULAR EL PAGO DE LLAMADA TELEFONICA");
            System.out.println("0. SALIR SUBMENU B");

            System.out.print("INGRESE OPCION EJERCICIO? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    cls();
                    ejercicio1B();
                    pause();
                    break;
                case "2":
                    cls();
                    ejercicio2B();
                    pause();
                    break;
                case "3":
                    cls();
                    ejercicio3B();
                    pause();
                    break;
                case "0":
                    cls();
                    bandera = true;
                    break;
            }
        } while (bandera != true);

    }

    public static void submenuC() {
        boolean bandera = false;

        do {
            cls();
            System.out.println("SUBMENU_C: ESTRUCTURA CONDICIONA MULTIPLE");
            System.out.println("-----------------------------------------");

            System.out.println("1. DETERMINA EL DIA DE LA SEMANA A PARTIR DEL NUMERO DEL DIA");
            System.out.println("2. XXXXXXXXXXXXXXXXXX");
            System.out.println("3. XXXXXXXXXXXXXXXXXX");
            System.out.println("0. SALIR SUBMENU C");

            System.out.print("INGRESE OPCION EJERCICIO? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    cls();
                    ejercicio1C();
                    pause();
                    break;
                case "2":
                    //ejercicio2C();
                    break;
                case "3":
                    //ejercicio3C();
                    break;
                case "0":
                    cls();
                    bandera = true;
                    break;
            }
        } while (bandera != true);
    }

    public static void submenuD() {
        boolean bandera = false;

        do {
            System.out.println("SUBMENU_D: ESTRUCTURA BUCLE FOR");
            System.out.println("-------------------------------");

            System.out.println("1. GENERAR SERIE NATURAL 1...N");
            System.out.println("2. XXXXXXXXXXXXXXXXXX");
            System.out.println("3. XXXXXXXXXXXXXXXXXX");
            System.out.println("4. SERIE SI ES PAR DECREMENTA EN 2 HASTA 1 Y SI ES IMPAR DECREMENTA EN 2 HASTA 2");
            System.out.println("0. SALIR SUBMENU D");

            System.out.print("INGRESE OPCION EJERCICIO? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    ejercicio1D();
                    break;
                case "2":
                    //ejercicio2C();
                    break;
                case "3":
                    //ejercicio3C();
                    break;
                case "4":
                    ejercicio4D();
                    break;
                case "0":
                    bandera = true;
                    break;
            }
        } while (bandera != true);
    }

    public static void submenuH() {
        boolean bandera = false;

        do {
            System.out.println("\nSUBMENU_H: ARRAY UNIDIMENSIONAL (VECTOR)");
            System.out.println("----------------------------------------");

            System.out.println("1. LLENAR Y RECORRER UN VECTOR DE TAMAÑO N");
            System.out.println("2. XXXXXXXXXXXXXXXXXX");
            System.out.println("3. XXXXXXXXXXXXXXXXXX");
            System.out.println("8. LLENAR UN VECTOR DE TAMAÑO N Y DETERMINAR CUANTO SON PARES E IMPARES");

            System.out.println("0. SALIR SUBMENU H");

            System.out.print("INGRESE OPCION EJERCICIO? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    ejercicio1H();
                    break;
                case "2":
                    //ejercicio2H();
                    break;
                case "3":
                    //ejercicio3H();
                    break;
                case "8":
                    ejercicio8H();
                    break;
                case "10":
                    //ejercicio10H();
                    break;
                case "0":
                    bandera = true;
                    break;
            }
        } while (bandera != true);
    }

    public static void submenuJ() {
        boolean bandera = false;

        do {
            System.out.println("\nSUBMENU_J: FUNCION");
            System.out.println("--------------------");

            System.out.println("1. XXXXXXXXXXXXXXXXXX");
            System.out.println("2.  CONTAR EL NUMERO DE CARACTERES DE UN NUMERO REAL");
            System.out.println("3. XXXXXXXXXXXXXXXXXX");
            System.out.println("8. XXXXXXXXXXXXXXXXXX");

            System.out.println("0. SALIR SUBMENU J");

            System.out.print("INGRESE OPCION EJERCICIO? ");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    //ejercicio1H();
                    break;
                case "2":
                    ejercicio2J();
                    break;
                case "3":
                    //ejercicio3H();
                    break;
                case "8":
                    //ejercicio8H();
                    break;
                case "10":
                    //ejercicio10H();
                    break;
                case "0":
                    bandera = true;
                    break;
            }
        } while (bandera != true);
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
