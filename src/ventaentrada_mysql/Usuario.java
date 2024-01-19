package ventaentrada_mysql;

public class Usuario {
    private String idUsuario ;
    private String nombre;   
    private int edad;
    private String direccion;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre, int edad, String direccion, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", contrasena=" + contrasena + '}';
    }


    
    
}
