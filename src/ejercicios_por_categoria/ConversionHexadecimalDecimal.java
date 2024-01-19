package ejercicios_por_categoria;

import java.util.Scanner;

public class ConversionHexadecimalDecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INGRESE NUMERO HEXADECIMAL? ");
        String hexa = sc.next();
        int valorLetra=0, decimal = 0;
        char letra = ' ';
        //PROCESO
        for(int i=0,j=hexa.length()-1;i<hexa.length(); i++,j--) {
            letra = hexa.charAt(i);
            switch(letra) {
                case 'A':  valorLetra = 10; break;
                case 'B':  valorLetra = 11; break;
                case 'C':  valorLetra = 12; break;
                case 'D':  valorLetra = 13; break;
                case 'E':  valorLetra = 14; break;
                case 'F':  valorLetra = 15; break;
                default: valorLetra = Integer.parseInt(letra+"");
            }
            decimal = decimal + valorLetra*(int)Math.pow(16, j);
        }
        System.out.println("Decimal: " + decimal);
    }
    
}
