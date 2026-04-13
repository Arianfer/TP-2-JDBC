import Model.Alumno;
import Model.AlumnosDAO;
import Model.Direcciones;
import Model.DireccionesDAO;

import java.net.IDN;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);



/*
        Alumno alumno1 = new Alumno("Thomas", "Bardi", 22, "tomybardi@gmail.com");
        AlumnosDAO.insertar(alumno1);

        Direcciones direcciones1 = new Direcciones("Gorriti",752, 6);
        DireccionesDAO.insertar(direcciones1);

        Alumno alumno2 = new Alumno("Ori", "Granito", 21, "origranito@gmail.com");
        AlumnosDAO.insertar(alumno2);

        Direcciones direcciones1 = new Direcciones("Gorriti",752, 8);
        DireccionesDAO.insertar(direcciones1);

        AlumnosDAO.listarConDirecciones();

        System.out.print("Ingrese ID del alumno: ");
        int id = scanner.nextInt();

        DireccionesDAO dao = new DireccionesDAO();
        List<Direcciones> direcciones = dao.direccionPorAlumno(id);

        for (Direcciones d : direcciones) {
            System.out.println(d);
        }

        AlumnosDAO actuEdad = new AlumnosDAO();

        System.out.println("Ingrese el ID del Alumno a actualizar su edad: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        AlumnosDAO.actualizarEdad(id, edad);

        AlumnosDAO borrar = new AlumnosDAO();

        System.out.println("Ingrese el ID del Alumno a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AlumnosDAO.eliminarAlumno(id);
    */

    }
}