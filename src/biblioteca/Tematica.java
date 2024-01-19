package biblioteca;

public class Tematica {
    private String id_tematica;
    private String descripcion;

    public Tematica(String id_tematica, String descripcion) {
        this.id_tematica = id_tematica;
        this.descripcion = descripcion;
    }

    public String getId_tematica() {
        return id_tematica;
    }

    public void setId_tematica(String id_tematica) {
        this.id_tematica = id_tematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
