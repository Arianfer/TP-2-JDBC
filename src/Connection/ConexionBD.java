package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    ///URL de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/alumnosShaffer";
    private static final String USER = "root";
    private static final String PASS = "romano3442";

    ///Creamos la instancia unica
    private static ConexionBD instancia;
    public static Connection conexion;

    ///Constructor privado para evitar multiples instancia
    private ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion establecida a la base de datos");
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos");
        }
    }

    /// Método público para obtener la instancia única
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    /// Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    ///Metodo para cerrar la conexion
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada");
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

