package org.example.modelo;

public class Profesor {

    private int numEmpleado;
    private String nombre;
    private int edad;
    private String puesto;
    private String cedulaProfesional;

    public Profesor(){}

    public Profesor(int numEmpleado, String nombre, int edad, String puesto, String cedulaProfesional) {
        setNumEmpleado(numEmpleado);
        setNombre(nombre);
        setEdad(edad);
        setPuesto(puesto);
        setCedulaProfesional(cedulaProfesional);

    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if(nombre.isBlank() || nombre.isEmpty()){
            System.out.println("Error, nombre requerido");
        }

        this.nombre = nombre;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        if(edad > 20 && edad < 80){
            this.edad = edad;
        }else{
            System.out.println("Edad no válida");
        }

    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {

        if(puesto.isBlank() || puesto.isEmpty()){
            System.out.println("El puesto es obligatorio");
        }

        this.puesto = puesto;

    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {

        if(cedulaProfesional.isBlank() || cedulaProfesional.isEmpty()){
            System.out.println("La cédula profesional es obligatoria");
        }

        this.cedulaProfesional = cedulaProfesional;

    }

    @Override
    public String toString() {

        return "numEmpleado=" + numEmpleado + '\n' +
                "nombre='" + nombre + '\n' +
                "edad=" + edad + '\n' +
                "puesto='" + puesto + '\n' +
                "cedulaProfesional='" + cedulaProfesional + '\n' +
                "----------------------------------------------";

    }

}