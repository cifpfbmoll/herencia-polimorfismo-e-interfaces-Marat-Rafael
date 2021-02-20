/*
Desarrolla la clase ​ Reserva​ . Se caracteriza por: tener un ​ Libro, fecha y hora de la
reserva​ . Crea constructor vacío, todos los parámetros, copia, getters/setters y
toString.
 */
package eu.cifpfbmoll.biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
// implementamos interfaz del material
public class Reserva implements Material {

    //ATRIBUTOS
    private static int IDreserva; // estatica , comun para todos
    private int id;// individual
    private Libro libro;
    private String fechaReserva;
    private String horaReserva;
    private String fechaDevolucion;

    //CONSTRUCTORES
    public Reserva() {
        IDreserva++; //a la hora de crear reserva aumenta en uno
        id = IDreserva; // y su valor se guarda en variable id
    }

    public Reserva(Libro libro, String fechaReserva, String horaReserva,String fechaDevolucion) {
        IDreserva++;
        id = IDreserva;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Reserva(Reserva reserva) {
        IDreserva++;
        id = IDreserva;
        this.libro = reserva.libro;
        this.fechaReserva = reserva.fechaReserva;
        this.horaReserva = reserva.horaReserva;
        this.fechaDevolucion = reserva.fechaDevolucion;
    }
    //GETTER/SETTER

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
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
        return "Reserva{" + "id=" + id + ", libro=" + libro + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", fechaDevolucion=" + fechaDevolucion + '}';
    }



    @Override
    public String obtenerFechaDevolucion() {
        String fechaDevolucionLibro = "";
        // hay que cambiar Libro por material? 
        if (this.getLibro() instanceof Libro) {
            // creamos objeto de LocalDate y lo parseamos de getFecha , DateTimeFormater cojemos de bibliotecario mismo formato !
            LocalDate fechaReservaLbro = LocalDate.parse(this.getFechaReserva(), DateTimeFormatter.ofPattern("yyyy-MMMM-dd"));
            // creamos un patern para mostrar informacion
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
            // fecha reserva es un objeto de LocalDate, le aplicamos metodo plusMonths
            LocalDate fechaReturn = fechaReservaLbro.plusMonths(1);
            // le aplicamos formato
            dtf.format(fechaReturn);
            //System.out.println("Reserva esta creada " + fechaReserva + " la feche de la devolucion es " + fechaReturn);  
            fechaDevolucionLibro = dtf.format(fechaReturn);
        }
        return fechaDevolucionLibro;
    }

    @Override
    // no lo se esto se puede llamar chulo, pero un poco mas bonito
    public String mostrarInfoChula() {
        String infoChula = "................datos de reserva.................\n"
                + "         Reserva "+this.getId()+"\n"
                + "         libro "+this.getLibro().getTitulo()+"\n"
                + "         Reservado dia "+this.getFechaReserva()+" a las "+this.getHoraReserva()+"\n"
                + "         Hay que devolver "+this.getFechaDevolucion()+"\n"
                + "         ..................................................";

        return infoChula;
    }

}//FIN CLASS
