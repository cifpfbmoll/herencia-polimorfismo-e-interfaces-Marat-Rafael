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

    static Scanner sc = new Scanner(System.in);
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
     * metodo para mostrar todos libros de la biblioteca
     * @param listaLibros 
     */
    public static void mostrarTodosLibros(ArrayList <Libro> listaLibros){
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i).toString());           
        }       
    }  
    
    /**
     * metodo para mostrar libros si estan disponibles, > 0
     * @param listaLibros 
     */
    public static void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros){
        
        for (int i = 0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getNumCopiasDisponibles()>0){
                System.out.println(listaLibros.get(i).toString());
            }          
        }
    }// fin metodo mostrar librosDisponibles
    
    /**
     * metodo para comprobar si libro indicado existe en la lista
     * si existe devuelve su posicion ,
     * si no existe devuelve -1
     * @param isbnBuscado
     * @param listaLibros
     * @return posicion en la lista
     */
    public static int confirmarLibro(String isbnBuscado, ArrayList<Libro> listaLibros){
        int posicion = -1;
        for (int i = 0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getISBN().equals(isbnBuscado)){
                posicion = i;
                return posicion;
            }           
        }
        return posicion;
    }// fin metodo confirmarLibro
    
}
