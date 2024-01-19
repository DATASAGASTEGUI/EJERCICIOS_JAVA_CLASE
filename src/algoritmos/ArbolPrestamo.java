package algoritmos;

import java.util.Scanner;

public class ArbolPrestamo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresos mensuales? ");
        double ingreso = sc.nextDouble();

        if (ingreso < 1500) {
            System.out.print("¿Antecedentes penales No-Si? ");
            String antecedentes = sc.next();
            if (antecedentes.equalsIgnoreCase("No")) {
                System.out.print("¿Años en el empleo actual? ");
                double anioempleo = sc.nextDouble();
                if (anioempleo < 1) {
                    System.out.print("¿Realiza pagos con la tarjeta de crédito No-Si? ");
                    String tarjeta = sc.next();
                    if (tarjeta.equalsIgnoreCase("Si")) {
                        System.out.println("Ofrecer préstamo");
                    } else {
                        System.out.println("No ofrecer préstamo");
                    }
                } else {
                    System.out.println("Ofrecer préstamo");
                }
            } else {
                System.out.println("No ofrecer préstamo");
            }

        } else {
            System.out.println("Años en el empleo actual? ");
            double aniosempleoactual = sc.nextDouble();
            if (aniosempleoactual < 1) {
                System.out.println("No ofrecer préstamo");
            } else {
                System.out.println("Ofrecer préstamo");
            }
        }
    }

}
