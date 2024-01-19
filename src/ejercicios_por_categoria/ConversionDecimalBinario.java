package ejercicios_por_categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConversionDecimalBinario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número entero decimal? ");
        List<Integer> binario = new ArrayList<>();
        int n = sc.nextInt(); //5
        int m = n;
        int c, r;
        while (n >= 2) {
            c = n / 2; //2 1 1
            r = n % 2; //1 0
            binario.add(r);
            n = c;
        }
        binario.add(n);
        System.out.println("Binario: " + Arrays.asList(binario));
        Collections.reverse(binario);
        System.out.println("Binario Algoritmo: " + Arrays.asList(binario));
        System.out.println("Binario Funcion  : " + Integer.toBinaryString(m));
    }

}
