/*
Desarrolla la clase ​ Persona​ . Se caracteriza por: ​ nombre, apellido1, apellido2, edad​ .
Crea constructor vacío, todos los parámetros, copia, getters/setters y toString.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public abstract class Persona {

    Scanner sc = new Scanner(System.in);
    //ATRIBUTOS
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected int edad;

    //CONSTRUCTORES
    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellido1 = persona.apellido1;
        this.apellido2 = persona.apellido2;
        this.edad = persona.edad;
    }

    //GETTER/SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }

    //METODOS
    /**
     * un método llamado ​ solicitarDatosPersona de la clase Persona, que pide
     * los datos y devuelve una Persona.
     *
     * @return persona
     */
    public Persona solicitarDatosPersona() {
        System.out.println("Nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.println("Primer apellido: ");
        String nuevoApellido1 = sc.nextLine();
        System.out.println("Segundo apellido: ");
        String nuevoApellido2 = sc.nextLine();
        System.out.println("Edad: ");
        int nuevoEdad = sc.nextByte();

        Persona nuevaPersona = new Persona(nuevoNombre, nuevoApellido1, nuevoApellido2, nuevoEdad) {};
        return nuevaPersona;
    }//fin metodo solicitarDatosPersona
}
