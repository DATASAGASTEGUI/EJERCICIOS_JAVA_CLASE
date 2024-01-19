package ventaentrada_mysql;

import java.sql.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario, clave;
        Connection conexion = getConexion();
        if (conexion != null) {
            System.out.println("ACCESO:");
            System.out.print("Ingrese usuario? ");
            usuario = sc.next();
            Usuario u = buscarUsuario(usuario);
            if (u == null) {
                System.out.println("REGISTRARSE");
                System.out.print("Ingrese nombre (alias) de su usuario: ");
                String idUsuario = sc.next();
                sc.nextLine(); // Consumir el salto de línea pendiente

                System.out.print("Ingrese nombre completo de su usuario: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese su edad: ");
                int edad = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea pendiente

                System.out.print("Ingrese su dirección: ");
                String direccion = sc.nextLine();

                System.out.print("Ingrese su clave: ");
                String contrasena = sc.nextLine();
                Usuario u1 = new Usuario(idUsuario, nombre, edad, direccion, contrasena);
                int n = insertarUsuario(u1);
                if (n == 1) {
                    System.out.println("Ingrese número de entradas a comprar? ");
                    int nentradas = sc.nextInt();
                    String[] vectorentradas = generarCodigoEntradas(nentradas);
                    guardarEntradasPorUsuario(vectorentradas, idUsuario);

                } else {
                    System.out.println("ERROR: AL INSERTAR");
                }
            } else {
                boolean correcto;
                do {
                    System.out.print("Ingrese su clave? ");
                    clave = sc.next();
                    correcto = verificarClaveUsuario(usuario, clave);
                    if (correcto) {
                        System.out.println("Ingrese número de entradas a comprar? ");
                        int nentradas = sc.nextInt();
                        String[] vectorentradas = generarCodigoEntradas(nentradas);
                        guardarEntradasPorUsuario(vectorentradas, usuario);
                    } else {
                        System.out.println("ERROR: CLAVE INCORRECTA VUELVA A INGRESAR SU CLAVE");
                    }
                } while (!correcto);
            }

        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static Usuario buscarUsuario(String usuario) {
        Connection conexion = getConexion();
        Usuario u = null;
        if (conexion != null) {
            String query = "SELECT * FROM Usuario WHERE idUsuario = ?";//
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String idUsuario = rs.getString(1);
                    String nombre = rs.getString(2);
                    int edad = rs.getInt(3);
                    String direccion = rs.getString(4);
                    String clave = rs.getString(5);
                    u = new Usuario(idUsuario, nombre, edad, direccion, clave);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
        return u;
    }

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ventaentrada";
            conexion = DriverManager.getConnection(url, "root", "12345678");
        } catch (SQLException ex) {
            conexion = null;
        }
        return conexion;
    }

    public static int insertarUsuario(Usuario usuario) {
        Connection conexion = getConexion();
        int n = 0;
        if (conexion != null) {
            String query = "INSERT INTO Usuario (idUsuario,nombre,edad,direccion,clave) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getIdUsuario());
                ps.setString(2, usuario.getNombre());
                ps.setInt(3, usuario.getEdad());
                ps.setString(4, usuario.getDireccion());
                ps.setString(5, usuario.getContrasena());
                n = ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("ERROR: INSERT" + e);
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
        return n;
    }

    public static String[] generarCodigoEntradas(int nentrada) {
        //RECUPEAR LA SECUENCIA
        int inicio = recuperarSecuenciaEntrada();
        String[] codigoentradas = new String[nentrada];
        for (int i = 0; i < nentrada; i++) {
            String serie = "S" + inicio;
            inicio++;
            codigoentradas[i] = serie;
        }
        actualizarTablaContadorCodigo(inicio);
        return codigoentradas;
    }

    public static int recuperarSecuenciaEntrada() {
        Connection conexion = getConexion();
        int contador = 0;
        if (conexion != null) {
            String query = "SELECT * FROM  CONTADORCODIGO";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    contador = rs.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
        return contador;

    }

    public static void guardarEntradasPorUsuario(String[] vectorentradas, String idUsuario) {
        Connection conexion = getConexion();
        int n = 0;
        if (conexion != null) {
            String query = "INSERT INTO ENTRADA (idEntrada,idUsuario) VALUES (?,?)";
            try {

                for (int i = 0; i < vectorentradas.length; i++) {
                    PreparedStatement ps = conexion.prepareStatement(query);
                    ps.setString(1, vectorentradas[i]);
                    ps.setString(2, idUsuario);
                    n = ps.executeUpdate();
                }

            } catch (SQLException e) {
                System.out.println("ERROR: INSERT" + e);
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
    }

    public static void actualizarTablaContadorCodigo(int i) {
        Connection conexion = getConexion();
        if (conexion != null) {
            String query = "UPDATE CONTADORCODIGO SET contador = ?";//PARAMETRICA
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, i);
                ps.executeUpdate();
                System.out.println("OK: UPDATE");
            } catch (SQLException e) {
                System.out.println("ERROR: UPDATE");
            }
        }
    }

    public static boolean verificarClaveUsuario(String usuario, String clave) {
        Connection conexion = getConexion();
        boolean bandera = false;
        if (conexion != null) {
            String query = "SELECT * FROM  USUARIO WHERE idUsuario = ? AND clave = ?";
            try {
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, usuario);
                ps.setString(2, clave);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    bandera = true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: SELECT");
            }
        } else {
            System.out.println("ERROR: CONEXION");
        }
        return bandera;
    }

}
