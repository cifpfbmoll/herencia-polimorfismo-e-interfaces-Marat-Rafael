/*
 Una clase llamada Biblioteca
Concretamente debemos almacenar:    nombre de la biblioteca, 
                                   lista de libros y 
                                    lista de personas . 
Para esta clase debes crear constructor vacío, constructor con todos los parámetros, constructor copia, toString, getters/setters (DTO). 

Debe haber un control en el setter de manera que el nombre de la biblioteca empiece en mayúsculas.

Mostrar libros. Imprimirá por pantalla toda la lista de libros.(método instancia)
Mostrar libros disponibles. Solo imprime la lista de los libros disponibles.(método instancia)
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class Biblioteca {

    //atributos
    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaPersonas;

    //CONSTRUCTOR
    public Biblioteca() {
    }

    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.listaLibros = listaLibros;
        this.listaPersonas = listaPersonas;
    }

    public Biblioteca(Biblioteca biblioteca) {
        this.nombreBiblioteca = biblioteca.nombreBiblioteca;
        this.listaLibros = biblioteca.listaLibros;
        this.listaPersonas = biblioteca.listaPersonas;
    }

    //METODOS GETTERS/SETTERS
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        while (nombreBiblioteca.charAt(0) < 65 || nombreBiblioteca.charAt(0) > 90) {
            // comprobamos con la tabla ASCII A=65 Z=90
            System.out.println("Nombre de la biblioteca debe empezar por mayuscula");
            Scanner sc = new Scanner(System.in);
            nombreBiblioteca = sc.nextLine();
        }
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    //toSTRING
    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", listaLibros=" + listaLibros + ", listaPersonas=" + listaPersonas + '}';
    }   
    // RESTO DE LOS METODOS
    //Mostrar libros. Imprimirá por pantalla toda la lista de libros.(método instancia)
    public void mostrarTodosLibros(){
        //creamos variable para guardad aqui lista de libros
        ArrayList<Libro> listaLibrosMostrar = this.getListaLibros();
        // bucle for para recorrer toda lalista
        for (int i = 0; i < listaLibrosMostrar.size(); i++) {
            listaLibrosMostrar.get(i).toString();            
        }
    }// fin metodo MostrarTodosLibros
    
    //Mostrar libros disponibles. Solo imprime la lista de los libros disponibles.(método instancia)
    public void mostrarLibrosDisponibles(){
        // creamos variable ArrayList donde guardamos ArrayList de la biblioteca
        ArrayList<Libro>listaLibrosMostrarDisponibles = this.getListaLibros();
        //bucle for para recorrer array de libros
        for (int i = 0; i < listaLibrosMostrarDisponibles.size(); i++) {
            if(listaLibrosMostrarDisponibles.get(i).getNumCopiasDisponibles()>0){
                // si tiene numero de copias mas que 0 lo mostramos
                System.out.println(listaLibrosMostrarDisponibles.get(i).toString());
            }           
        }       
    }//fin metodo mostrarLibrosDisponibles
 
}
