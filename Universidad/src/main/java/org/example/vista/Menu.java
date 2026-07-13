package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.*;
import java.util.ArrayList;

public class Menu {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    AlumnoDAO alumnoDAO = new AlumnoDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();

    Alumno alumno = new Alumno();
    Profesor profesor = new Profesor();

    private void registrar(){

        try{

            System.out.println("Número de expediente:");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));

            System.out.println("Nombre:");
            alumno.setNombre(br.readLine());

            System.out.println("Edad:");
            alumno.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Carrera:");
            alumno.setCarrera(br.readLine());

            System.out.println("Cuatrimestre:");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));

            alumnoDAO.nuevoAlumno(alumno);

        }catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

    }

    private void listar(){

        ArrayList<Alumno> alumnos = alumnoDAO.extraserAlumnos();

        System.out.println("------ LISTA DE ALUMNOS ------");

        for(Alumno alumno : alumnos){

            System.out.println(alumno);

        }

    }

    private void modificar() throws IOException{

        System.out.println("Número de expediente:");
        alumno.setNumExpediente(Integer.parseInt(br.readLine()));

        System.out.println("Nombre:");
        alumno.setNombre(br.readLine());

        System.out.println("Edad:");
        alumno.setEdad(Integer.parseInt(br.readLine()));

        System.out.println("Carrera:");
        alumno.setCarrera(br.readLine());

        System.out.println("Cuatrimestre:");
        alumno.setCuatrimestres(Integer.parseInt(br.readLine()));

        alumnoDAO.actualizarAlumno(alumno);

    }

    private void eliminarAlumno(){

        try{

            System.out.println("Número de expediente:");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));

            alumnoDAO.eliminarAlumno(alumno);

        }catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

    }

    private void registrarProfesor(){

        try{

            System.out.println("Número de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

            System.out.println("Nombre:");
            profesor.setNombre(br.readLine());

            System.out.println("Edad:");
            profesor.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Puesto:");
            profesor.setPuesto(br.readLine());

            System.out.println("Cédula profesional:");
            profesor.setCedulaProfesional(br.readLine());

            profesorDAO.nuevoProfesor(profesor);

        }catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

    }

    private void listarProfesores(){

        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        System.out.println("------ LISTA DE PROFESORES ------");

        for(Profesor profesor : profesores){

            System.out.println(profesor);

        }

    }

    private void modificarProfesor() throws IOException{

        System.out.println("Número de empleado:");
        profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

        System.out.println("Nombre:");
        profesor.setNombre(br.readLine());

        System.out.println("Edad:");
        profesor.setEdad(Integer.parseInt(br.readLine()));

        System.out.println("Puesto:");
        profesor.setPuesto(br.readLine());

        System.out.println("Cédula profesional:");
        profesor.setCedulaProfesional(br.readLine());

        profesorDAO.actualizarProfesor(profesor);

    }

    private void eliminarProfesor(){

        try{

            System.out.println("Número de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

            profesorDAO.eliminarProfesor(profesor);

        }catch(Exception e){

            System.out.println("Error: " + e.getMessage());

        }

    }
    public void menu(){

        int opcion = 0;

        do{

            try{

                System.out.println("\n===== MENU UNIVERSIDAD =====");
                System.out.println("1. Registrar alumno");
                System.out.println("2. Listar alumnos");
                System.out.println("3. Modificar alumno");
                System.out.println("4. Eliminar alumno");
                System.out.println("5. Registrar profesor");
                System.out.println("6. Listar profesores");
                System.out.println("7. Modificar profesor");
                System.out.println("8. Eliminar profesor");
                System.out.println("9. Salir");

                System.out.println("Seleccione una opción:");
                opcion = Integer.parseInt(br.readLine());


                switch(opcion){

                    case 1:
                        registrar();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        modificar();
                        break;

                    case 4:
                        eliminarAlumno();
                        break;

                    case 5:
                        registrarProfesor();
                        break;

                    case 6:
                        listarProfesores();
                        break;

                    case 7:
                        modificarProfesor();
                        break;

                    case 8:
                        eliminarProfesor();
                        break;

                    case 9:
                        System.out.println("Programa finalizado");
                        break;

                    default:
                        System.out.println("Opción no válida");

                }


            }catch(Exception e){

                System.out.println("Error en el menú: " + e.getMessage());

            }


        }while(opcion != 9);


    }


    public static void main(String[] args){

        Menu menu = new Menu();

        menu.menu();

    }

}