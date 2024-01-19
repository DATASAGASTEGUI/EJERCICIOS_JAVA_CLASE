package arraylist_object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {


    public static void main(String[] args) {
       List<String> nombres_al = new ArrayList<>();
       nombres_al.add("Luis");
       nombres_al.add("Miguel");

       List<Object> objetos_al = new ArrayList<>();
       objetos_al.add(1);
       objetos_al.add("Carlos");
       objetos_al.add(1.73);
       objetos_al.add(23);
       objetos_al.add(true);
       System.out.println(Arrays.asList(objetos_al));
    
       List<int[]> vectores_al = new ArrayList<>();
       int[] v1 = {1, 2, 3};
       int[] v2 = {5, 2, 8};
       int[] v3 = {0, 4, 3};
       vectores_al.add(v1);
       vectores_al.add(v2);
       vectores_al.add(v3);
       
       List<int[][]> matrices_al = new ArrayList<>();
       int[][] m1 = {
                      {1, 2, 3},
                      {5, 8, 3}
                    };
       matrices_al.add(m1);
       
       List<Object[]> registros_al = new ArrayList<>();
       Object[] r1 = {"A1","Miguel",23,1.72};
       Object[] r2 = {"A2","Carlos",24,1.71};
       registros_al.add(r1);
       registros_al.add(r2);
       for(Object[] v: registros_al) {
           System.out.println(Arrays.asList(v));
       }
       
       
    }
    
}
