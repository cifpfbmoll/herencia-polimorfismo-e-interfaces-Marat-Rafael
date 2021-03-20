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
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    //CONSTRUCTORES
    public Persona() {
    }

    // usamos setters,lo que nos obliga declararlo como final
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEdad(edad);
    }

    // usamos setters
    public Persona(Persona persona) {
        this.setNombre(persona.getNombre());
        this.setApellido1(persona.getApellido1());
        this.setApellido2(persona.getApellido2());
        this.setEdad(persona.getEdad());
    }

    //GETTER/SETTER
    public String getNombre() {
        return nombre;
    }
    // es final porque su uso en constructor obliga 
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    // es final porque su uso en constructor obliga 
    public final void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
    // es final porque su uso en constructor obliga 
    public final void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }
    // es final porque su uso en constructor obliga 
    public final void setEdad(int edad) {
        this.edad = edad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }

    //METODOS
    /**
     * metodo solicitarDatosPersona para rellenar datos del objeto ya creado
     *
     *
     */
    public void solicitarDatosPersona() throws Exception{
        System.out.println("Nombre: ");
        this.setNombre(sc.nextLine());

        System.out.println("Primer apellido: ");
        this.setApellido1(sc.nextLine());

        System.out.println("Segundo apellido: ");
        this.setApellido2(sc.nextLine());
        System.out.println("Edad: ");

        this.setEdad(sc.nextInt());

    }//fin metodo solicitarDatosPersona

    //declaramos metodo abstracto para cambiar contraseña
    public abstract void cambiarContrasenia();

}
