package algoritmos;

import java.util.Scanner;

public class ArbolFarmaco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Presion arterial Alta-Media-Baja?");
        String p1 = sc.next();

        if (p1.equalsIgnoreCase("Alta")) {
            System.out.print("Azucar en sangre Alto-Bajo?");
            String p2 = sc.next();
            if (p2.equalsIgnoreCase("Alto")) {
                System.out.print("Alergia a antibioticos Si-No?");
                String p4 = sc.next();
                if (p4.equalsIgnoreCase("Si")) {
                    System.out.print("Otras alergias Si-No?");
                    String p5 = sc.next();
                    if (p5.equalsIgnoreCase("Si")) {
                        System.out.println("No aplicar fármaco");
                    } else  {
                        System.out.println("Si aplicar fármaco");
                    }
                } else {
                    System.out.println("Si aplicar fármaco");
                }
            } else {
                System.out.println("Si aplicar fármaco");
            }
        } else if (p1.equalsIgnoreCase("Media")) {
            System.out.print("Indice de colesterola Alto-Bajo?");
            String p3 = sc.next();
            if (p3.equalsIgnoreCase("Alto")) {
                System.out.println("No aplicar fármaco");
            } else {
                System.out.println("Si aplica fármaco");
            }
        } else if (p1.equalsIgnoreCase("Baja")) {
            System.out.println("Si aplica fármaco");
        }
    }

}
