package algoritmos;

public class DibujarEscalones {

    public static void main(String[] args) {
       
        for(int i=0,k=0; i<4; i++,k=k+6) {
            for(int p=1; p<=k; p++) {
                System.out.print(" ");
            }
            for(int j=1; j<=6; j++) {
                System.out.print("*");
            }
            for(int x=0; x<=3; x++) {
                
                System.out.println("*");
            }
            
            System.out.println();
            
        }
        
    }
    
}
