package Model;

import java.sql.*;

import Connection.ConexionBD;

import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO {
    // INSERT
        public static void insertar(Alumno alumno) {
            String sql = "INSERT INTO alumnos(nombre, apellido, edad, email) VALUES (?, ?, ?, ?)";

            try{
            Connection connection = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, alumno.getNombre());
                ps.setString(2, alumno.getApellido());
                ps.setInt(3, alumno.getEdad());
                ps.setString(4, alumno.getEmail());

                ps.executeUpdate();
                System.out.println("Alumno insertado");

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


   //Listar Alumnos con Direcciones

        public static void listarConDirecciones(){
            String sql = """
                   SELECT a.id, a.nombre, a.apellido, a.edad, a.email, 
                          d.calle, d.altura
                   FROM alumnos a
                   LEFT JOIN direcciones d ON a.id = d.id
            """;
            try(
                    Connection connection = ConexionBD.getInstancia().getConexion();
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("nombre") + " " +
                            rs.getString("apellido") + " " +
                            " | Edad: " + rs.getInt("edad") +
                            " | Email: " + rs.getString("email") +
                            " | Calle: " + rs.getString("calle") +
                            " | Altura: " + rs.getInt("altura")
                    );
                }

            }catch (SQLException e){
                System.out.println("Error " + e.getMessage());
            }
        }

        //Actualizar edad de Alumno

    public static void  actualizarEdad(int id, int nuevaEdad){

            String sql = "UPDATE alumnos SET edad = ? WHERE id = ? ";

            try{
                Connection connection = ConexionBD.getInstancia().getConexion();
                PreparedStatement ps = connection.prepareStatement(sql);

                    ps.setInt(1, nuevaEdad);
                    ps.setInt(2, id);

                    int cantRegistrosAfectados = ps.executeUpdate();

                    if(cantRegistrosAfectados > 0){
                        System.out.println("Edad actualizada correctamente");
                    }else{
                        System.out.println("No existe un alumno con esa ID");
                    }
                }catch(SQLException e){
                    System.out.println("ERROR " + e.getMessage());
                }

            }




    public static void eliminarAlumno(int id){

         String sql = "DELETE FROM alumnos WHERE id = ?";

         try{
             Connection connection = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = connection.prepareStatement(sql);

             ps.setInt(1, id);

             int registrosAfectados = ps.executeUpdate();

             if(registrosAfectados > 0 ){
                 System.out.println("Alumno eliminado correctamente");
             }else{
                 System.out.println("No existe un alumno con esa ID");
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

    }



}

