package org.example;

import org.example.dao.AlumnoDAO;
import org.example.modelo.Alumno;
import org.example.vista.Menu;

public class Main {
    static void main() {
        /*AlumnoDAO alumnoDAO = new AlumnoDAO();
        Alumno alumno = new Alumno(2025162035,"Francisco Rodriguez",20,"TI",3);
        alumnoDAO.nuevoAlumno(alumno);*/
        Menu menu = new Menu();
        menu.menu();
    }
}
