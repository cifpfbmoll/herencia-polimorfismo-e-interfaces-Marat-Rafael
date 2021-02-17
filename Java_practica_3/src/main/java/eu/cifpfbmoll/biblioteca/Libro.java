/*
Una clase llamada Libro. Concretamente debemos almacenar: 
ISBN, título, autor, editorial, nº de copias y nº copias disponibles. 
Para esta clase debes crear constructor vacío, constructor con todos los parámetros, 
constructor copia, toString, getters/setters (DTO) y un contador de libros 
(que llevará el control de los diferentes libros que hay en la aplicación). 
Debe haber un control en el setter de manera que el número de copias inicial nunca debe ser menos de 1. 
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat-Rafael
 */
public class Libro {

    Scanner sc = new Scanner(System.in);
    //ATRIBUTOS
    private static int contador;
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;

    //CONSTRUCTORES
    public Libro() {
        contador++;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numCopias = numCopias;
        this.numCopiasDisponibles = numCopiasDisponibles;
        contador++;
    }

    public Libro(Libro libro) {
        this.ISBN = libro.ISBN;
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.editorial = libro.editorial;
        this.numCopias = libro.numCopias;
        this.numCopiasDisponibles = libro.numCopiasDisponibles;
        contador++;
    }
    //METODOS GETTER/SETTER

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Libro.contador = contador;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNimCopias(int nimCopias) {
        while (numCopias < 1) {
            System.out.println("Numero de copias no puede ser menos de 1");
            numCopias = sc.nextInt();
            sc.nextLine();
        }
        this.numCopias = nimCopias;
    }

    public int getNumCopiasDisponibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDisponibles(int numCopiasDisponibles) {
        this.numCopiasDisponibles = numCopiasDisponibles;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", numCopias=" + numCopias + ", numCopiasDisponibles=" + numCopiasDisponibles + '}';
    }

    /**
     * El método ​ reservarLibro​ , pedirá al usuario el teléfono y el correo
     * electrónico, si coincide, le permitirá realizar la reserva, y por tanto,
     * solicitará el ISBN del libro, y en consecuencia quedará completa la
     * información de la reserva (revisa la clase Reserva). Debes tener en
     * cuenta que debes actualizar la clase Libro, con la información de libros
     * disponibles, y obviamente se debe tener en cuenta que no podrá reservar
     * si no hay unidades disponibles.
     */
    public void reservarLibro(ArrayList<Libro> listaLibros,ArrayList <Persona> listaPersonas) {
        int indicePersona;

        
    }

    /**
     *
     * @param listaPersonas
     */
    public int confirmarUsuario(ArrayList<Persona> listaPersonas) {
        int posicion = -1;
        System.out.println("Indica telefono del usuario: ");
        String telefonoBuscar = sc.nextLine();
        System.out.println("Indica correo del usuario: ");
        String mailBuscar = sc.nextLine();
        for (int i = 0; i < listaPersonas.size(); i++) {
            // recorremos array buscando Usuarios
            if (listaPersonas.get(i) instanceof Usuario) {
                // hacemos casting y comparamos datos
                if (((Usuario) listaPersonas.get(i)).getTelefono().equalsIgnoreCase(telefonoBuscar)
                        && ((Usuario) listaPersonas.get(i)).getCorreoElectronico().equals(mailBuscar)) {

                    System.out.println(" Usuario confirmado");
                    posicion = i;
                    return posicion;
                }
            }
        }
        System.out.println("Usuario no confirmado");
        return posicion;
    }// fin metodo confirmarUsuario
    
    public static void mostrarTodosLibros(ArrayList <Libro> listaLibros){
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i).toString());           
        }       
    }    
}
