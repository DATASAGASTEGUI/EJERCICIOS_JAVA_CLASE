package ejercicios_por_categoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConversionDecimalHexadecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //DECLARACION VARIABLES
        int decimal; //Entrada
        List<String> hexadecimales_al; //Salida
        int n, c, r;
        List<Integer> decimales_al = new ArrayList<>();
        //ENTRADA
        System.out.print("INGRESAR NUMERO ENTERO DECIMAL? ");
        decimal = sc.nextInt();
        //PROCESO
        n = decimal;
        while (n >= 16) {
            c = n / 16;
            r = n % 16;
            decimales_al.add(r);
            n = c;
        }
        decimales_al.add(n);
        Collections.reverse(decimales_al);
        System.out.println(decimales_al);

        hexadecimales_al = obtenerListaHexadecimales(decimales_al);
        System.out.println(hexadecimales_al);
    }

    public static String obtenerHexadecimal(int decimal) {
        String hexadecimal = "";
        switch (decimal) {
            case 10:
                hexadecimal = "A";
                break;
            case 11:
                hexadecimal = "B";
                break;
            case 12:
                hexadecimal = "C";
                break;
            case 13:
                hexadecimal = "D";
                break;
            case 14:
                hexadecimal = "E";
                break;
            case 15:
                hexadecimal = "F";
                break;
        }
        return hexadecimal;
    }

    public static List<String> obtenerListaHexadecimales(List<Integer> decimales_al) {
        List<String> hexadecimales_al = new ArrayList<>();
        for (int decimal : decimales_al) {
            hexadecimales_al.add(obtenerHexadecimal(decimal));
        }
        return hexadecimales_al;
    }
}
