/*
Desarrolla la clase ​ Reserva​ . Se caracteriza por: tener un ​ Libro, fecha y hora de la
reserva​ . Crea constructor vacío, todos los parámetros, copia, getters/setters y
toString.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class Reserva {

    //ATRIBUTOS
    private ArrayList<Libro> libro;
    private String fechaReserva;
    private String horaReserva;

    //CONSTRUCTORES
    public Reserva() {
    }

    public Reserva(ArrayList<Libro> libro, String fechaReserva, String horaReserva) {
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
    }

    public Reserva(Reserva reserva) {
        this.libro = reserva.libro;
        this.fechaReserva = reserva.fechaReserva;
        this.horaReserva = reserva.horaReserva;
    }
    //GETTER/SETTER

    public ArrayList<Libro> getLibro() {
        return libro;
    }

    public void setLibro(ArrayList<Libro> libro) {
        this.libro = libro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "libro=" + libro + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + '}';
    }
    
    
    
    
}//FIN CLASS
