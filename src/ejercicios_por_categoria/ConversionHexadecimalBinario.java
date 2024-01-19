package ejercicios_por_categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConversionHexadecimalBinario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INGRESAR NUMERO HEXADECIMAL? ");
        String hexadecimal = sc.next().toUpperCase();
        int decimal = convertirHexadecimalDecimal(hexadecimal);
        List<Integer> binario = convertirDecimalBinario(decimal);
        System.out.println("Binario: " + Arrays.asList(binario));
    }

    public static int convertirHexadecimalDecimal(String hexa) {
        int valorLetra = 0, decimal = 0;
        char letra = ' ';
        //PROCESO
        for (int i = 0, j = hexa.length() - 1; i < hexa.length(); i++, j--) {
            letra = hexa.charAt(i);
            switch (letra) {
                case 'A':
                    valorLetra = 10;
                    break;
                case 'B':
                    valorLetra = 11;
                    break;
                case 'C':
                    valorLetra = 12;
                    break;
                case 'D':
                    valorLetra = 13;
                    break;
                case 'E':
                    valorLetra = 14;
                    break;
                case 'F':
                    valorLetra = 15;
                    break;
                default:
                    valorLetra = Integer.parseInt(letra + "");
            }
            decimal = decimal + valorLetra * (int) Math.pow(16, j);
        }
        return decimal;
    }

    public static List<Integer> convertirDecimalBinario(int n) {
        List<Integer> binario = new ArrayList<>();
        int m = n;
        int c, r;
        while (n >= 2) {
            c = n / 2;
            r = n % 2;
            binario.add(r);
            n = c;
        }
        binario.add(n);
        Collections.reverse(binario);
        return binario;
    }
}
