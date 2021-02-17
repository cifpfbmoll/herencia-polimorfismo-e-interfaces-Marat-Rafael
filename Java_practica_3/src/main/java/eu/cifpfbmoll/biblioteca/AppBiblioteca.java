package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class AppBiblioteca {

    // creamos un escaner
    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos instancia de la biblioteca !
        Biblioteca miBiblioteca = new Biblioteca("FBM", new ArrayList<Libro>(), new ArrayList<Persona>());

        // creamos algunos Bibliotecarios para lista del personas
        // String puestoTrabajo, String NIF, String contrasenia, String nombre, String apellido1, String apellido2, byte edad
        Bibliotecario b1 = new Bibliotecario("B1", "111", "111", "Alex", "Alonso", "Fernandez", 33);
        Bibliotecario b2 = new Bibliotecario("B2", "222", "222", "Jose", "Ferrero", "Cortez", 35);
        Bibliotecario b3 = new Bibliotecario("B3", "333", "333", "Manolo", "Saez", "Grande", 22);
        Bibliotecario b4 = new Bibliotecario("B4", "444", "444", "Rafael", "Gion", "Gion", 38);
        Bibliotecario b5 = new Bibliotecario("B5", "555", "555", "Nadal", "Toro", "Justicia", 46);
        // añadimos personal a la lista del personal
        miBiblioteca.getListaPersonas().add(b1);
        miBiblioteca.getListaPersonas().add(b2);
        miBiblioteca.getListaPersonas().add(b3);
        miBiblioteca.getListaPersonas().add(b4);
        miBiblioteca.getListaPersonas().add(b5);

        // creamos algunos libros para la biblioteca para probar
        // Libro  atributos : ISBN +  titulo + autor  + editorial + numCopias  + numCopiasDisponible 
        Libro l1 = new Libro("001", "Divina comedia", "Dante", "La Pajarita Roja", 15, 10);
        Libro l2 = new Libro("002", "Divina comedia", "Dante", "Algani Editorial", 55, 0);
        Libro l3 = new Libro("003", "Divina comedia", "Dante", "Editorial Denes", 55, 55);
        Libro l4 = new Libro("004", "Don Quijote de la Mancha 1", "Cervantes", "Andavira Editora", 55, 35);
        Libro l5 = new Libro("111", "Don Quijote de la Mancha 2", "Cervantes", "Andavira Editora", 55, 33);
        Libro l7 = new Libro("112", "El idiota", "Dostoievski", "La Pajarita Roja", 15, 0);
        Libro l8 = new Libro("113", "El idiota", "Dostoievski", "Calambur Editorial", 15, 5);
        Libro l9 = new Libro("975689215", "Almas muertas", "Dostoievski", "La Pajarita Roja", 11, 1);
        Libro l10 = new Libro("587348122", "Lolita", "Nabokov", "La Pajarita Roja", 100, 0);
        Libro l20 = new Libro("683745554", "Romancero gitano", "Lorca", "Kraicon", 1000, 568);
        Libro l21 = new Libro("683745654", "Romancero gitano", "Lorca", "Algani Editorial", 1000, 955);
        Libro l22 = new Libro("898945677", "Romancero gitano", "Lorca", "Calambur Editorial", 95, 95);
        Libro l23 = new Libro("233364926", "Don Quijote de la Mancha 1", "Cervantes", "Calambur Editorial", 20, 0);
        Libro l24 = new Libro("235364899", "Don Quijote de la Mancha 2", "Cervantes", "Calambur Editorial", 20, 0);
        Libro l30 = new Libro("111122222", "Guerra y paz 1", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l31 = new Libro("111133333", "Guerra y paz 2", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l32 = new Libro("111144444", "Guerra y paz 3", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l33 = new Libro("111155555", "Guerra y paz 4", "Tolstoi", "La Pajarita Roja", 20, 20);

        miBiblioteca.getListaLibros().add(l1);
        miBiblioteca.getListaLibros().add(l2);
        miBiblioteca.getListaLibros().add(l3);
        miBiblioteca.getListaLibros().add(l4);
        miBiblioteca.getListaLibros().add(l5);
        miBiblioteca.getListaLibros().add(l7);
        miBiblioteca.getListaLibros().add(l8);
        miBiblioteca.getListaLibros().add(l9);
        miBiblioteca.getListaLibros().add(l10);
        miBiblioteca.getListaLibros().add(l20);
        miBiblioteca.getListaLibros().add(l21);
        miBiblioteca.getListaLibros().add(l22);
        miBiblioteca.getListaLibros().add(l23);
        miBiblioteca.getListaLibros().add(l24);
        miBiblioteca.getListaLibros().add(l30);
        miBiblioteca.getListaLibros().add(l31);
        miBiblioteca.getListaLibros().add(l32);
        miBiblioteca.getListaLibros().add(l33);

        // creamos algunos Usuarios de la biblioteca
        //Usuario( ArrayList<Reserva> listaReservas,telefono,  direcion, codigopostal, correo, nombre, apellido1, apellido2, edad
        Usuario u1 = new Usuario(new ArrayList<Reserva>(), "11111", "calle General Riera 11", "07552", "jose@gmail.com", "Jose", "Alonso", "Zapatero", 33);
        Usuario u2 = new Usuario(new ArrayList<Reserva>(), "22222", "caratera Militar 122", "07592", "antonio@gmail.com", "Antonio", "Garcia", "Serrano", 23);
        Usuario u3 = new Usuario(new ArrayList<Reserva>(), "33333", "plaza Paris 45", "07232", "david@gmail.com", "David", "Fernandez", "Goya", 43);
        Usuario u4 = new Usuario(new ArrayList<Reserva>(), "44444", "calle Matamorros 33", "07698", "fernando@gmail.com", "Fernando", "Rey", "Velazquez", 24);
        Usuario u5 = new Usuario(new ArrayList<Reserva>(), "55555", "plaza Mayor 3", "07114", "rafael@gmail.com", "Rafael", "Guion", "Profesor", 36);

        //añadimos a la lista de personas
        miBiblioteca.getListaPersonas().add(u1);
        miBiblioteca.getListaPersonas().add(u2);
        miBiblioteca.getListaPersonas().add(u3);
        miBiblioteca.getListaPersonas().add(u4);
        miBiblioteca.getListaPersonas().add(u5);

        boolean salirMenu = false;
        boolean salirBibliotecario = false;
        boolean salirUsuario = false;
        byte opcion;

        do {
            System.out.println("********MENU***********");
            System.out.println("1 - Bibliotecario");
            System.out.println("2 - Usuario");
            System.out.println("0 - Salir");
            System.out.println("***********************");
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion) {
                case 1:// menu del Bibliotecario
                    Bibliotecario Bibliotecario = new Bibliotecario();

                    // llamamos metodo para confirmamr que este usuario existe
                    if (Bibliotecario.accesoBibliotecarioBoolean(miBiblioteca.getListaPersonas())) {
                        // si confirmamos Bibliotecario mostramos menu

                        do {

                            System.out.println("*********Bibliotecario******");
                            System.out.println("************MENU************");
                            System.out.println("1 - Dar de alta nuevo Bibliotecario");
                            System.out.println("2 - Mostrar todos bibliotecarios");
                            System.out.println("3 - Dar de baja un bibliotecario");
                            System.out.println("4 - Reservar libro");
                            System.out.println("5 - Devolver libro");
                            System.out.println("6 - Mostrar todos libros");
                            System.out.println("7 - Mostrar solo libros disponibles");
                            System.out.println("8 - Añadir libros a la lista");
                            System.out.println("9 - Eliminar libro de lalista");
                            System.out.println("0 - Salir");
                            byte opcionBibliotecario = sc.nextByte();
                            sc.nextLine();
                            switch (opcionBibliotecario) {
                                case 1:
                                    // creamos instancia vacia
                                    Bibliotecario nuevoBibliotecario = new Bibliotecario();
                                    // metodo nos devuelve un Bibliotecario
                                    nuevoBibliotecario = nuevoBibliotecario.solicitarDatosPersona();
                                    // añadimos nuevoBibliotecario a la lista
                                    miBiblioteca.getListaPersonas().add(nuevoBibliotecario);
                                    break;
                                case 2:// mostramos todos bilotecarios de la lista
                                    Bibliotecario.mostrarTodosBibliotecarios(miBiblioteca.getListaPersonas());
                                    break;
                                case 3:
                                    //borramos un bibliotecario existente de la lista
                                    Bibliotecario.borrarBibliotecario(miBiblioteca.getListaPersonas());
                                    break;
                                case 4:

                                    break;

                                case 5:

                                    break;
                                case 6:
                                    Libro.mostrarTodosLibros(miBiblioteca.getListaLibros());
                                    break;

                                case 7:

                                    break;
                                case 8:

                                    break;

                                case 9:

                                    break;
                                case 0:
                                    salirBibliotecario = true;
                                    break;

                            }//fin switch
                        } while (!salirBibliotecario);
                    } else {
                        // si no confirmado salimos
                        System.out.println("Usuario no confirmado");
                        salirBibliotecario = true;
                    }
                    break;
                // terminamos menu del Bibliotecario
                case 2:// menu del Usuario

                    break;
                case 0:
                    salirMenu = true;
            }// fin switch MENU principal
        } while (!salirMenu);
    }
}
