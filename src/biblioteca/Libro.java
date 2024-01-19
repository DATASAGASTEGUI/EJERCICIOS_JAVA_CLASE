package biblioteca;

public class Libro {
   private String id_libro;
   private String iban;
   private String titulo;
   private String editorial;
   private int numero_paginas;
   private String fecha_publicacion;
   private double precio;
   private String id_tematica;

    public Libro(String id_libro, String iban, String titulo, String editorial, int numero_paginas, String fecha_publicacion, double precio, String id_tematica) {
        this.id_libro = id_libro;
        this.iban = iban;
        this.titulo = titulo;
        this.editorial = editorial;
        this.numero_paginas = numero_paginas;
        this.fecha_publicacion = fecha_publicacion;
        this.precio = precio;
        this.id_tematica = id_tematica;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getId_tematica() {
        return id_tematica;
    }

    public void setId_tematica(String id_tematica) {
        this.id_tematica = id_tematica;
    }
    
    public String getCadenaCsv() {
        return this.id_libro + ";" +
               this.iban + ";" +
               this.titulo + ";" +
               this.editorial + ";" +
               this.numero_paginas + ";" +
               this.fecha_publicacion + ";" +
               this.precio + ";" +
               this.id_tematica;
    }
}
