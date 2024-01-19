package tarea_mysql_salud;

import java.sql.*;

public class OperacionesCRUD {
   
    //ATRIBUTO
    Connection conexion;

    public OperacionesCRUD(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void mostrarConsultaAgrupamientoTipoParto() {
       System.out.println("[7] MOSTRAR CANTIDAD DE CONSULTAS POR TIPO DE PARTO");
       System.out.println("---------------------------------------------------");
       if(this.conexion != null) {
          String query = "SELECT deinpr, COUNT(*) FROM Consulta GROUP BY deinpr";
          try {
               PreparedStatement ps = conexion.prepareStatement(query);
               ResultSet rs = ps.executeQuery(query);
               while(rs.next()) {
                   String cadena = rs.getString(1);
                   int numero = rs.getInt(2);
                   System.out.printf("%-10s %8d\n",cadena,numero);
               }
          }catch(SQLException e) {
              System.out.print("ERROR: SELECT");
          }
       }else {
           System.out.println("ERROR: CONEXION");
       }
    }

    public void mostrarConsultaAgrupamientoNombreMedico() {
       System.out.println("[8] MOSTRAR CANTIDAD DE CONSULTAS POR NOMBRE MEDICO");
       System.out.println("---------------------------------------------------");
       if(this.conexion != null) {
          String query = "SELECT nombreMedico, COUNT(*) FROM Consulta GROUP BY nombreMedico ORDER BY nombreMedico;";
          try {
               PreparedStatement ps = conexion.prepareStatement(query);
               ResultSet rs = ps.executeQuery(query);
               System.out.printf("%-40s %8s\n","NOMBRE MEDICO","NUMERO CONSULTAS");
               System.out.printf("%-40s %8s\n","-------------","----------------");
               while(rs.next()) {
                   String cadena = rs.getString(1);
                   int numero = rs.getInt(2);
                   System.out.printf("%-40s %8d\n",cadena,numero);
               }
          }catch(SQLException e) {
              System.out.print("ERROR: SELECT");
          }
       }else {
           System.out.println("ERROR: CONEXION");
       }
    }
    
    
    
    
}
