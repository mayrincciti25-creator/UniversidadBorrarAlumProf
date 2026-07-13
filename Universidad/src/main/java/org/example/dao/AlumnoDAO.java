package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class AlumnoDAO {

    public boolean nuevoAlumno(Alumno alumno){

        String sql = "INSERT INTO alumnos VALUES(?,?,?,?,?)";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setInt(1, alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setInt(3, alumno.getEdad());
            stm.setString(4, alumno.getCarrera());
            stm.setInt(5, alumno.getCuatrimestre());

            stm.executeUpdate();

            System.out.println("Alumno registrado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

    public ArrayList<Alumno> extraserAlumnos(){

        ArrayList<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()){

            while(rs.next()){

                Alumno alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestre"));

                alumnos.add(alumno);

            }

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());

        }

        return alumnos;

    }

    public boolean actualizarAlumno(Alumno alumno){

        String sql = "UPDATE alumnos SET nombre=?, edad=?, carrera=?, cuatrimestre=? WHERE numExpediente=?";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1, alumno.getNombre());
            stm.setInt(2, alumno.getEdad());
            stm.setString(3, alumno.getCarrera());
            stm.setInt(4, alumno.getCuatrimestre());
            stm.setInt(5, alumno.getNumExpediente());

            stm.executeUpdate();

            System.out.println("Alumno actualizado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

    public boolean eliminarAlumno(Alumno alumno){

        String sql = "DELETE FROM alumnos WHERE numExpediente=?";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setInt(1, alumno.getNumExpediente());

            stm.executeUpdate();

            System.out.println("Alumno eliminado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

}