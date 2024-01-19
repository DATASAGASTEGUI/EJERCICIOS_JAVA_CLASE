package postgresql;

public class Alumno {
    private String idAlumno;
    private String nombre;

    public Alumno() {
    }

    public Alumno(String idAlumno, String nombre) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + '}';
    }
    
}
