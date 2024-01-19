package algoritmos;

import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int bandera = 1;
        double media = 0;
        int mayor = -999999, menor = 9999999;
        int suma = 0, cont = 0;
        do {

            System.out.print("Ingresar número? ");
            numero = sc.nextInt(); // 5 6 0
            if (bandera == 1 && numero == 0) {
                media = 0;
                mayor = 0;
                menor = 0;
                break;
            }
            bandera++;

            if (numero != 0) {
                if (numero > mayor) {
                    mayor = numero;
                }
                if (numero < menor) {
                    menor = numero;
                }
                suma = suma + numero;
                cont = cont + 1;
                media = suma / (float)cont;
            }

        } while (numero != 0); //Finaliza Falso

        System.out.println("Media: " + media);
        System.out.println("Media: " + mayor);
        System.out.println("Media: " + menor);

    }

}
