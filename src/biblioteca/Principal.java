package biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class Principal {

    public static void main(String[] args) {
        // (1) CONEXION
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String clave = "12345678";
        Connection conexion;
        try {
              conexion = DriverManager.getConnection(url, usuario, clave);
        }catch(SQLException e) {
            conexion = null;
        }
        
        // (2) EJECUTAR QUERY
        if(conexion != null) {
           // 2.1 QUERY TEMATICA
           String query = "SELECT * FROM Tematica";
           List<Tematica> tematica_al = new ArrayList<>();
             try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String id_tematica = rs.getString(1);
                    String descripcion = rs.getString(2);
                    //System.out.println(id_tematica + ";" + descripcion);
                    Tematica t = new Tematica(id_tematica,descripcion);
                    tematica_al.add(t);
                }
           }catch(SQLException e) {
               System.out.println("ERROR: QUERY");
           }
           // 2.2 QUERY LIBRO
           String query1 = "SELECT * FROM Libro";
           List<Libro> libro_al = new ArrayList<>();
             try {
                PreparedStatement ps = conexion.prepareStatement(query1);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    String id_libro = rs.getString(1);
                    String iban = rs.getString(2);
                    String titulo = rs.getString(3);
                    String editorial = rs.getString(4);
                    int numero_paginas = rs.getInt(5);
                    String fecha_publicacion = rs.getString(6);
                    double precio = rs.getDouble(7);
                    String id_tematica = rs.getString(8);
                    //System.out.println(id_libro + ";" + titulo);
                    Libro l = new Libro(id_libro,iban,titulo,editorial,numero_paginas,
                                        fecha_publicacion,precio,id_tematica);
                    libro_al.add(l);
                }
           }catch(SQLException e) {
               System.out.println("ERROR: QUERY");
           }
           //PROCESAR LAS COLECCIONES
           //1. CREAR UN ARCHIVO CSV DE LIBROS
           for(Libro libro: libro_al) {
               crearArchivoLibroCsv(libro);
           }
           System.out.println("OK: CREAR ARCHIVO CSV");
           System.out.println("OK: CONEXION");
        }else {
           System.out.println("ERROR: CONEXION");
        }
    }
    
    public static void crearArchivoLibroCsv(Libro libro) {
        String nra = "data/biblioteca.csv";
        String cadenacsv = libro.getCadenaCsv();
        File f;
        FileWriter fw;
        BufferedWriter bw;
        try {
              f = new File(nra);
              fw = new FileWriter(f, true);//Añadir
              bw = new BufferedWriter(fw);
              
              bw.write(cadenacsv + "\n");
              bw.flush();
        }catch(Exception e) {
            System.out.println("ERROR: ESCRIBIR");
        }
        
    }
}
