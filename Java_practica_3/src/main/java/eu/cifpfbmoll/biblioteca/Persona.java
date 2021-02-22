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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }

    //METODOS

    
        /**
     * un método llamado ​ solicitarDatosPersona de la clase Persona, 
     * rellena datos de una persona existente
     *
     * @return persona
     */
    public void solicitarDatosPersona() {
        System.out.println("Nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.println("Primer apellido: ");
        String nuevoApellido1 = sc.nextLine();
        System.out.println("Segundo apellido: ");
        String nuevoApellido2 = sc.nextLine();
        System.out.println("Edad: ");
        int nuevoEdad = sc.nextInt();
        sc.nextLine();
        // rellenamos datos de la persona
        this.setNombre(nuevoNombre);
        this.setApellido1(nuevoApellido1);
        this.setApellido2(nuevoApellido2);
        this.setEdad(nuevoEdad);
    }//fin metodo solicitarDatosPersona
    
    //declaramos metodo abstracto para cambiar contraseña
    public abstract void cambiarContrasenia();
    
    
}
