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
     *
     * @param listaLibros
     */
    public static void mostrarTodosLibros(ArrayList<Libro> listaLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i).toString());
        }
    }

    /**
     * metodo para mostrar libros si estan disponibles, > 0
     *
     * @param listaLibros
     */
    public static void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros) {

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getNumCopiasDisponibles() > 0) {
                System.out.println(listaLibros.get(i).toString());
            }
        }
    }// fin metodo mostrar librosDisponibles

    /**
     * metodo para comprobar si libro indicado existe en la lista si existe
     * devuelve su posicionLibro , si no existe devuelve -1
     *
     * @param isbnBuscado
     * @param listaLibros
     * @return posicionLibro en la lista
     */
    public static int confirmarLibro(String isbnBuscado, ArrayList<Libro> listaLibros) {
        int posicionLibro = -1;
        boolean encontradoLibro = false;
        int j = 0;
        while (!encontradoLibro && j < listaLibros.size()) {
            // recorremos la lista y en cada elemento comparamos ISBN con isbnBuscado
            if (listaLibros.get(j).getISBN().equals(isbnBuscado)) {
                // si coincide
                posicionLibro = j;
                encontradoLibro = true;
            }
            j++;
        }
        return posicionLibro;
    }// fin metodo confirmarLibro

    /**
     * un metodo estatico para añadir un libro a la biblioteca
     *
     * @param listaLibros un ArrayList dela biblioteca que contiene lista de
     * libros
     */
    public static void crearLibroParaLista(ArrayList<Libro> listaLibros) {
        System.out.println();
        System.out.println("ISBN: ");
        String isbnNuevoLibro = sc.nextLine();
        System.out.println("Titulo: ");
        String tituloNuevoLibro = sc.nextLine();
        System.out.println("Autor: ");
        String autorNuevoLibro = sc.nextLine();
        System.out.println("Editorial: ");
        String editorialNuevoLibro = sc.nextLine();
        System.out.println("Numero de copias: ");
        int numCopiasNuevoLibro = sc.nextInt();
        sc.nextLine();
        System.out.println("Numero de copias disponibles: ");
        int numCopiasDisponiblesNuevoLibro = sc.nextInt();
        sc.nextLine();

        // creamos libro 
        Libro libro = new Libro(isbnNuevoLibro, tituloNuevoLibro, autorNuevoLibro, editorialNuevoLibro, numCopiasNuevoLibro, numCopiasDisponiblesNuevoLibro);
        //añadimos a la lista de libros
        listaLibros.add(libro);
    }//fin crear libro para la lista

    public static void borrarLibroDeLista(ArrayList<Libro> listaLibros) {

        System.out.println("ISBN del libro para borrar");
        String isbnBorrar = sc.nextLine();
        // comprobamos que libro existe enla lista, usamos metodo que devuelve posicionLibro del libro, si no encuentra devuelve -1
        int posicionlibroParaBorrar = confirmarLibro(isbnBorrar, listaLibros);
        if (posicionlibroParaBorrar != -1) {
            System.out.println(listaLibros.get(posicionlibroParaBorrar));
            System.out.println("encontramos libro en la lista estas seguro que desea borrarlo ? si/no");
            String elecion = sc.nextLine();
            if (elecion.equalsIgnoreCase("si")) {
                System.out.println("borrado con exito");
                listaLibros.remove(posicionlibroParaBorrar);
            } else if (elecion.equalsIgnoreCase("no")) {
                System.out.println("has decidido no borrar libro");
            }
        }
    }// fin metodo borrarLibro

    /**
     *
     
    public static void buscarLibroBibliotecas(RedBibliotecas redBibliotecas) {
        ArrayList<Libro> listaLibrosCoincideNombre = new ArrayList();        
        int contador = 0;
        System.out.println("Nombre del libro que buscamos en la red bibliotecaria: ");
        String nombreLibroBuscar = sc.nextLine();
        redBibliotecas.getListaBibliotecas();
        // recorremos lista de bibliotecas y acedemos a cada biblioteca
        for (int i = 0; i < redBibliotecas.getListaBibliotecas().size(); i++) {            
            // dentro de cada biblioteca debemos recorrer lista de libros
            for (int j = 0; j < redBibliotecas.getListaBibliotecas().get(j).getListaLibros().size(); j++) {

                if (redBibliotecas.getListaBibliotecas().get(j).getListaLibros().get(j).getTitulo().equals(nombreLibroBuscar)) {
                    contador++;
                    listaLibrosCoincideNombre.add(redBibliotecas.getListaBibliotecas().get(j).getListaLibros().get(j));
                }
            }
        }
        if(contador == 0){
            System.out.println("No encontramos ningun libro con nombre "+nombreLibroBuscar);
        }else{
            System.out.println("hemos encontrado "+ contador+" con nombre "+nombreLibroBuscar);
            for (int i = 0; i < listaLibrosCoincideNombre.size(); i++) {
                // recorremos lista para mostrar todos libros
                System.out.println(listaLibrosCoincideNombre.get(i).toString());
            }
        }

    }// fin metodo
    * */
    
        /**
     * Método de buscarLibroBiblioteca que buscará en la biblioteca qué usuarios tienen un libro,
     * y la información de dicha reserva, o si el libro está disponible en la biblioteca. 
     */
    
    /*
    public static void buscarLibroBiblioteca(ArrayList <Persona> listaPersonas) {
        int contadorEncontrados = 0;
        System.out.println("Nombre del libro que buscamos: ");
        String nombreLibroBuscar = sc.nextLine();
        
        // aqui guardamos todos usuarios que encontramos que tienen este libro reservado
        ArrayList<Usuario> listaUsuariosEncontradas = new ArrayList();
        
        // arrayList para guardar todas reservas que encontramos
        ArrayList<Reserva> listaReservasEncontradas = new ArrayList();
        
        for (int i = 0; i < listaPersonas.size(); i++) {
            if( listaPersonas.get(i) instanceof Usuario){
                
                int tamanio = ((Usuario) listaPersonas.get(i)).getListaReservas().size();
                for (int j = 0; j <  tamanio ; j++) {
                    
                    if( ((Usuario) listaPersonas.get(j)).getListaReservas().get(j).getLibro().getTitulo().contains(nombreLibroBuscar) ){
                        contadorEncontrados++;
                        // la persona que tiene este titulo guardamos en la lista
                        listaUsuariosEncontradas.add( (Usuario) listaPersonas.get(j) );
                        // añadimo en la lista de reserva reservas
                        listaReservasEncontradas.add( ((Usuario) listaPersonas.get(j)).getListaReservas().get(j) );                       
                    }                                     
                }
            }// fin if Usuario           
        }// fin for
        
        if (contadorEncontrados == 0){
            System.out.println("No encontramos nadien que tiene libro " + nombreLibroBuscar);
        }else{
            System.out.println("hemos encontrado "+contadorEncontrados+" con nombre "+nombreLibroBuscar);
            System.out.println("Personas que tienen libro "+nombreLibroBuscar+" en su reserva");
            for (int i = 0; i < listaUsuariosEncontradas.size(); i++) {
               System.out.println(listaUsuariosEncontradas.get(i).toString());                
            }            
            System.out.println("Reservas que tienen libro ");
            for (int i = 0; i < listaReservasEncontradas.size(); i++) {
                System.out.println(listaReservasEncontradas.get(i).toString());               
            }            
        }
    }// fin metodo
*/
    
    /**
     * Método de buscarLibroBiblioteca que buscará en la biblioteca qué usuarios tienen un libro, 
     * y la información de dicha reserva, o si el libro está disponible en la biblioteca. 
     * @param listaPersonas 
     */
    public static void buscarLibroBiblioteca(ArrayList<Persona> listaPersonas){
        System.out.println("Nombre libro: ");
        String nombreLibroBuscar =sc.nextLine();
        
        ArrayList<Reserva> listaLibrosBuscados = new ArrayList();
        ArrayList<Usuario> listaUsuariosConReserva = new ArrayList();
        
        for (int i = 0; i < listaPersonas.size(); i++) {
           if(listaPersonas.get(i) instanceof Usuario){
               // casting a Usuario y acceso a lista de reservas              
               for (int j = 0; j <  ((Usuario)listaPersonas.get(i)).getListaReservas().size() ; j++) {
                   if( ((Usuario)listaPersonas.get(j)).getListaReservas().get(j).getLibro().getTitulo().contains(nombreLibroBuscar)){
                       
                   }
                  // System.out.println( ((Usuario)listaPersonas.get(i)).getListaReservas().get(j).toString() );
                   
               }
              
           }
            
        }
        
        
    }// fin metodo buscarLibroPersona
    
    /**
     * metodo para buscar libros que contienen nombre introducido por usuario
     * @param nombreLibroBuscado
     * @param listaLibros 
     */
    public static void buscarLibroNombre(String nombreLibroBuscado,ArrayList<Libro>listaLibros){
        ArrayList <Libro> listaLibrosEncontrados = new ArrayList();
        for (int i = 0; i < listaLibros.size(); i++) {
            if( listaLibros.get(i).getTitulo().contains(nombreLibroBuscado)){
                listaLibrosEncontrados.add( listaLibros.get(i) );
            }
        }
        for (Libro lib : listaLibrosEncontrados) {
            System.out.println(lib);
        }
    }// fin metodo buscarLibroNombre

}
