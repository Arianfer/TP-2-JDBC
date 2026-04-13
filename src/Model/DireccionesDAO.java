package Model;

import Connection.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DireccionesDAO {

    /// Insertar
    public static void insertar(Direcciones direcciones) {
        String sql = "INSERT INTO Direcciones(calle, altura, alumno_id) VALUES(?,?,?)";

        try {
            Connection connection = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, direcciones.getCalle());
            ps.setInt(2, direcciones.getAltura());
            ps.setInt(3, direcciones.getAlumno_id());

            ps.executeUpdate();
            System.out.println("Direccion insertada");

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    /// Ver Direcciones por alumno_id

    public List<Direcciones> direccionPorAlumno(int alumno_id) {

        List<Direcciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM direcciones WHERE alumno_id = ?";

        try (Connection connection = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, alumno_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Direcciones direcciones = new Direcciones();

                direcciones.setId(rs.getInt("id"));
                direcciones.setCalle(rs.getString("calle"));
                direcciones.setAltura(rs.getInt("altura"));

                lista.add(direcciones);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }

        return lista;
    }







    }