package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class ProfesorDAO {

    public boolean nuevoProfesor(Profesor profesor){

        String sql = "INSERT INTO maestros VALUES(?,?,?,?,?)";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setInt(3, profesor.getEdad());
            stm.setString(4, profesor.getPuesto());
            stm.setString(5, profesor.getCedulaProfesional());

            stm.executeUpdate();

            System.out.println("Profesor registrado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

    public ArrayList<Profesor> extraerProfesores(){

        ArrayList<Profesor> profesores = new ArrayList<>();

        String sql = "SELECT * FROM maestros";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()){

            while(rs.next()){

                Profesor profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setCedulaProfesional(rs.getString("cedulaProfesional"));

                profesores.add(profesor);

            }

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());

        }

        return profesores;

    }

    public boolean actualizarProfesor(Profesor profesor){

        String sql = "UPDATE maestros SET nombre=?, edad=?, puesto=?, cedulaProfesional=? WHERE numEmpleado=?";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1, profesor.getNombre());
            stm.setInt(2, profesor.getEdad());
            stm.setString(3, profesor.getPuesto());
            stm.setString(4, profesor.getCedulaProfesional());
            stm.setInt(5, profesor.getNumEmpleado());

            stm.executeUpdate();

            System.out.println("Profesor actualizado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

    public boolean eliminarProfesor(Profesor profesor){

        String sql = "DELETE FROM maestros WHERE numEmpleado=?";

        try(Connection connection = Conexion.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setInt(1, profesor.getNumEmpleado());

            stm.executeUpdate();

            System.out.println("Profesor eliminado correctamente");
            return true;

        }catch(SQLException e){

            System.out.println("Error: " + e.getMessage());
            return false;

        }

    }

}