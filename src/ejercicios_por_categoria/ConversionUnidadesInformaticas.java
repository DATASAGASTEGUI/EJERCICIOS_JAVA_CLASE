package ejercicios_por_categoria;

import java.util.Scanner;

public class ConversionUnidadesInformaticas {

    public static void main(String[] args) {
        //DATOS
        String[] unidadesInformaticas = {"BYTE","KILO BYTE","MEGA BYTE","GIGA BYTE",
                                         "TERA BYTE","PENTA BYTE","EXA BYTE","ZETTA BYTE",
                                         "YOTTA BYTE"};
        int[] conversion = {0,10,20,30,40,50,60,70,80};
        
        Scanner sc = new Scanner(System.in);
        System.out.println("ORIGNE");
        System.out.println("------");
        mostrarUnidades();
        System.out.print("INGRESE ORIGENE? ");
        int origen = sc.nextInt();
        System.out.print("CANTIDAD ORIGEN? ");
        int cantidadOrigen = sc.nextInt();
        System.out.println("DESTINO");
        System.out.println("------");
        mostrarUnidades();        
        System.out.print("INGRESE DESTINO? ");
        int destino = sc.nextInt();
        //PROCESO
        int exponente = origen - destino; //3 - 2 = 1
        double resultado = 0;
        if(exponente > 0) {
           resultado = cantidadOrigen * Math.pow(2,Math.abs(exponente)*10);
        }else {
           resultado = cantidadOrigen / Math.pow(2,Math.abs(exponente)*10);
        }
        System.out.println("CONVERSION: " + unidadesInformaticas[origen] + " TO " +
                            unidadesInformaticas[destino]);
        System.out.println(resultado);
    }
    
    public static void mostrarUnidades() {
        System.out.println("0. BYTE");
        System.out.println("1. KILO  BYTE");
        System.out.println("2. MEGA  BYTE");
        System.out.println("3. GIGA  BYTE");
        System.out.println("4. TERA  BYTE");
        System.out.println("5. PENTA BYTE");
        System.out.println("6. EXA   BYTE");
        System.out.println("7. ZETTA BYTE");
        System.out.println("8. YOTTA BYTE");
    }
    
}
