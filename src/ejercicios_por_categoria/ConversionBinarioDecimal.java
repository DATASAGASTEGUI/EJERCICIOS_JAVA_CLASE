package ejercicios_por_categoria;

import java.util.Scanner;

public class ConversionBinarioDecimal {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Ingrese número binario? ");
       int n = sc.nextInt();
       String cadena = n + "";
       int a = 0;
       for(int i=0, j=cadena.length()-1; i<cadena.length(); i++,j--) {
           a = a + Integer.parseInt(cadena.charAt(i)+"")*(int)Math.pow(2,j);
       }
       System.out.println("Decimal: " + a);
       
       
       
       
       System.out.println();
       for(int i=cadena.length()-1; i>=0; i--) {
           System.out.print(cadena.charAt(i));
       }
       
    }
    
}
