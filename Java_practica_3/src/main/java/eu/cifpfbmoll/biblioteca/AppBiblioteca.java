package eu.cifpfbmoll.biblioteca;

import java.io.IOException;
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

        // creamos un objeto redBibliotecaria dentro vamos a almacenar diferentes Bibliotecas
        RedBibliotecas redBibliotecaria = new RedBibliotecas(new ArrayList<Biblioteca>());

        Biblioteca bibliotecaArenal = new Biblioteca("Biblioteca CEPA Arenal", new ArrayList<Libro>(), new ArrayList<Persona>());

        Biblioteca bibliotecaPalma = new Biblioteca("Biblioteca Palma", new ArrayList<Libro>(), new ArrayList<Persona>());

        Biblioteca bibliotecaSoller = new Biblioteca("Biblioteca Soller", new ArrayList<Libro>(), new ArrayList<Persona>());

        Biblioteca bibliotecaFBM = new Biblioteca("CEFP Francesc Borja Moll", new ArrayList<Libro>(), new ArrayList<Persona>());

        //añadimos bibliotecas al ArrayList
        redBibliotecaria.getListaBibliotecas().add(bibliotecaArenal);
        redBibliotecaria.getListaBibliotecas().add(bibliotecaFBM);
        redBibliotecaria.getListaBibliotecas().add(bibliotecaPalma);
        redBibliotecaria.getListaBibliotecas().add(bibliotecaSoller);

        boolean salirElecionBilioteca = false;
        // creamos un objeto miBiblioteca, segun elecion de usuario se conecta a un o otro objeto Bibloteca
        Biblioteca miBiblioteca = new Biblioteca();
        boolean salirMenu = false;
        boolean salirBibliotecario = false;
        boolean salirUsuario = false;
        byte opcion;

        try {
            do {
                System.out.println("");
                System.out.println("*****ELIGE BIBLIOTECA******");
                System.out.println(" 1 - Biblioteca CEPA Arenal");
                System.out.println(" 2 - Biblioteca CEFP Francesc Borja Moll");
                System.out.println(" 3 - Biblioteca Palma");
                System.out.println(" 4 - Biblioteca Soller");
                System.out.println(" 0 - Salir");
                System.out.println("***************************");
                System.out.println("");

                byte elecionBibliotecaMenu = sc.nextByte();
                sc.nextLine();
                switch (elecionBibliotecaMenu) {
                    case 1:
                        miBiblioteca = redBibliotecaria.getListaBibliotecas().get(0);
                        miBiblioteca = inicializarBiblioteca(redBibliotecaria, 0);
                        menuPrincipal(redBibliotecaria, miBiblioteca, salirBibliotecario, salirUsuario, salirMenu);
                        break;
                    case 2:
                        miBiblioteca = redBibliotecaria.getListaBibliotecas().get(1);
                        miBiblioteca = inicializarBiblioteca(redBibliotecaria, 1);
                        menuPrincipal(redBibliotecaria, miBiblioteca, salirBibliotecario, salirUsuario, salirMenu);
                        break;
                    case 3:
                        miBiblioteca = redBibliotecaria.getListaBibliotecas().get(2);
                        miBiblioteca = inicializarBiblioteca(redBibliotecaria, 2);
                        menuPrincipal(redBibliotecaria, miBiblioteca, salirBibliotecario, salirUsuario, salirMenu);
                        break;
                    case 4:
                        miBiblioteca = redBibliotecaria.getListaBibliotecas().get(3);
                        miBiblioteca = inicializarBiblioteca(redBibliotecaria, 3);
                        menuPrincipal(redBibliotecaria, miBiblioteca, salirBibliotecario, salirUsuario, salirMenu);
                        break;
                    case 0:
                        salirElecionBilioteca = true;
                        break;
                    default:
                        System.out.println("De momento solo hay bibliotecas disponibles: ");
                        redBibliotecaria.mostrarTodasBibliotecas(redBibliotecaria.getListaBibliotecas());

                }// fin switch elecionBibliotecaMenu

            } while (!salirElecionBilioteca);
        } catch (RuntimeException e) {
            System.out.println("Opcion introducida mal");
        }

        sc.close();

        /**
         * metodo para rellenar datos a la biblioteca
         */
    }//fin main

    // metodo menu Principal
    public static void menuPrincipal(RedBibliotecas redBibliotecas, Biblioteca miBiblioteca, boolean salirBibliotecario, boolean salirUsuario, boolean salirMenu) throws RuntimeException {
        byte opcion;

        do {
            System.out.println("************************************************");
            System.out.println("***************BIBLIOTECA***********************");
            System.out.println("******" + miBiblioteca.getNombreBiblioteca() + "***********");
            System.out.println("********MENU***********");
            System.out.println("1 - Bibliotecario");
            System.out.println("2 - Usuario");
            System.out.println("0 - Salir");
            System.out.println("************************************************");
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion) {
                
                case 1:// menu del bibliotecarioActual
                    
                    int posicionDelBibliotecarioActual = Bibliotecario.accesoBibliotecario(miBiblioteca.getListaPersonas());
                    // llamamos metodo para confirmamr que este usuario existe
                    if (posicionDelBibliotecarioActual != -1) {
                        // si confirmamos bibliotecarioActual mostramos menu
                        // creamos una instancia del bibliotecario que actualmente esta en menu
                        Bibliotecario bibliotecarioActual = (Bibliotecario) miBiblioteca.getListaPersonas().get(posicionDelBibliotecarioActual);
                        
                        do {
                            
                            salirBibliotecario = menuBibliotecario(miBiblioteca, bibliotecarioActual, salirBibliotecario);
                            
                        } while (!salirBibliotecario);
                    } else {
                        // si no confirmado salimos
                        System.out.println("Bibliotecario no confirmado");
                        salirBibliotecario = true;
                    }
                    break;
                    
                    // terminamos menu del bibliotecarioActual
                case 2:// menu del Usuario
                    // control de acceso del usuario creamos nuevo objeto Usuario
                    Usuario usuario = new Usuario();
                    //variable para metodo que devuelve posicion del usuario si existe, y devuelve -1 si no existe
                    int posicionUsuario = Usuario.confirmarUsuario(miBiblioteca.getListaPersonas());
                    if (posicionUsuario == -1) {
                        System.out.println("Desea registrarse en la Biblioteca? si/no");
                        String registrarNuevoUsuario = sc.nextLine();
                        if (registrarNuevoUsuario.equalsIgnoreCase("si")) {
                            Usuario.crearNuevoUsuarioParaLista(miBiblioteca.getListaPersonas());
                        }
                    } else {
                        
                        usuario = (Usuario) miBiblioteca.getListaPersonas().get(posicionUsuario);
                        try {
                            menuUsuario(redBibliotecas, miBiblioteca, usuario, salirUsuario);
                        } catch (RuntimeException e) {
                            System.out.println("Opcion elegida mal");
                        }
                        
                    }
                    break;
                    
                case 0:
                    salirMenu = true;
            }// fin switch MENU principal
            
        } while (!salirMenu);

    }// fin metodo menuPrincipal

    /**
     * metodo para mostrar menuUsuario
     *
     * @param miBiblioteca
     * @param usuario
     * @param salirUsuario
     */
    public static void menuUsuario(RedBibliotecas redBibliotecas, Biblioteca miBiblioteca, Usuario usuario, boolean salirUsuario) throws RuntimeException {
        do {
            System.out.println("********************USUARIO*****************");
            System.out.println("*********************MENU*******************");
            System.out.println("1 - Ver todos libros de la biblioteca");
            System.out.println("2 - Ver libros disponibles de la biblioteca");
            System.out.println("3 - Buscar libro en la biblioteca");
            System.out.println("4 - Ver mis reservas");
            System.out.println("5 - Cambiar mi correo electronico");
            System.out.println("0 - Salir");
            System.out.println("********************************************");
            byte opcionUsuario = sc.nextByte();
            sc.nextLine();
            switch (opcionUsuario) {
                case 1:// ver lista de libros
                    Libro.mostrarTodosLibros(miBiblioteca.getListaLibros());
                    break;
                case 2:// ver lista de libros disponibles
                    Libro.mostrarLibrosDisponibles(miBiblioteca.getListaLibros());
                    break;
                case 3:
                    //Libro.buscarLibroBiblioteca(miBiblioteca.getListaPersonas());

                    break;
                case 4:// ver mis reservas
                    usuario.mostrarReservas();
                    break;
                case 5:// cambiar correo electronico
                    usuario.cambiarContrasenia();
                case 0://salir
                    salirUsuario = true;
                    break;

            }//fin switch Usuario

        } while (!salirUsuario);
    }// fin metodo menuUsuario

    /**
     * metodo para mortrar menuBibliotecario
     *
     * @param miBiblioteca
     * @param bibliotecarioActual
     * @param salirBibliotecario
     * @return
     */
    public static boolean menuBibliotecario(Biblioteca miBiblioteca, Bibliotecario bibliotecarioActual, boolean salirBibliotecario) {
        System.out.println("*************BIBLIOTECARIO***************");
        System.out.println("****************MENU*********************");
        System.out.println("1 - Dar de alta nuevo Bibliotecario");
        System.out.println("2 - Mostrar todos bibliotecarios");
        System.out.println("3 - Dar de baja un bibliotecario");
        System.out.println("4 - Reservar libro");
        System.out.println("5 - Devolver libro");
        System.out.println("6 - Mostrar todos libros");
        System.out.println("7 - Mostrar solo libros disponibles");
        System.out.println("8 - Añadir libros a la lista");
        System.out.println("9 - Eliminar libro de la lista");
        System.out.println("11 - Mostrar todos usuarios");
        System.out.println("12 - Cambiar contraseña");
        System.out.println("13 - Buscar libro en reservas");
        System.out.println("14 - Mostrar todos usuarios con reservas");
        System.out.println("15 - Buscar un libro en reservas");
        System.out.println("0 - Salir");
        System.out.println("******************************************");
        byte opcionBibliotecario = sc.nextByte();
        sc.nextLine();
        switch (opcionBibliotecario) {
            case 1:// añadir nuevo bibliotecario
                // creamos instancia vacia
                Bibliotecario nuevoBibliotecario = new Bibliotecario();
                // metodo nos rellena datos del bibliotecario
                nuevoBibliotecario.solicitarDatosPersona();
                // añadimos nuevoBibliotecario a la lista
                miBiblioteca.getListaPersonas().add(nuevoBibliotecario);
                break;
            case 2:
                // mostramos todos bilotecarios de la lista
                bibliotecarioActual.mostrarTodosBibliotecarios(miBiblioteca.getListaPersonas());
                break;
            case 3:
                //borramos un bibliotecario existente de la lista
                bibliotecarioActual.borrarBibliotecario(miBiblioteca.getListaPersonas());
                break;
            case 4:
                // Reservar Libro
                bibliotecarioActual.reservarLibro(miBiblioteca.getListaLibros(), miBiblioteca.getListaPersonas());
                break;
            case 5:
                // devolver libro
                bibliotecarioActual.devolverLibro(miBiblioteca.getListaLibros(), miBiblioteca.getListaPersonas());
                break;
            case 6:
                // mostrar todos libros
                Libro.mostrarTodosLibros(miBiblioteca.getListaLibros());
                break;

            case 7:
                // mostrar libros disponibles
                Libro.mostrarLibrosDisponibles(miBiblioteca.getListaLibros());
                break;
            case 8:
                // añadir libro a la biblioteca
                Libro.crearLibroParaLista(miBiblioteca.getListaLibros());
                break;
            case 9:
                // eliminar libro de la biblioteca
                Libro.borrarLibroDeLista(miBiblioteca.getListaLibros());
                break;
            case 11:
                //mostrar todos usuarios de biblioteca
                Usuario.mostrarTodosUsuarios(miBiblioteca.getListaPersonas());
                break;
            case 12:
                // cambiar contraseña del bibliotecario actual
                bibliotecarioActual.cambiarContrasenia();
                break;
            case 13:
                System.out.println("Nombre libro: ");
                String nomLib = sc.nextLine();
                Libro.buscarLibroNombre(nomLib, miBiblioteca.getListaLibros());
                break;
            case 14:
                Usuario.mostrarTodosUsuariosConReservas(miBiblioteca.getListaPersonas());
                break;
            case 15:
                miBiblioteca.buscarLibroBiblioteca(miBiblioteca);
                break;
            case 0:
                // salir
                salirBibliotecario = true;
                break;

        }//fin switch
        return salirBibliotecario;
    }// fin menuBibliotecario

    /**
     * metodo para crear algumos bibliotecarios y usuarios en la biblioteca,
     * para pruebas
     *
     * @return
     */
    public static Biblioteca inicializarBiblioteca(RedBibliotecas redBibliotecaria, int codigoBilioteca) {
        //creamos instancia de la biblioteca !
        Biblioteca miBiblioteca = redBibliotecaria.getListaBibliotecas().get(codigoBilioteca);
        // creamos algunos Bibliotecarios para lista del personas
        // String puestoTrabajo, String NIF, String contrasenia, String nombre, String apellido1, String apellido2, byte edad
        Bibliotecario b1 = new Bibliotecario("B1", "111", "111", "Alex", "Alonso", "Fernandez", 33);
        Bibliotecario b2 = new Bibliotecario("B2", "222", "222", "Jose", "Ferrero", "Cortez", 35);
        Bibliotecario b3 = new Bibliotecario("B3", "333", "333", "Manolo", "Saez", "Grande", 22);
        Bibliotecario b4 = new Bibliotecario("B4", "444", "444", "Rafael", "Gion", "Gion", 38);
        Bibliotecario b5 = new Bibliotecario("B5", "555", "555", "Nadal", "Toro", "Justicia", 46);
        Bibliotecario b6 = new Bibliotecario("B1", "666", "666", "Francisco", "Jose", "Fernandez", 33);
        Bibliotecario b7 = new Bibliotecario("B2", "777", "777", "Joan", "Alfonso", "Nadal", 35);
        Bibliotecario b8 = new Bibliotecario("B3", "888", "888", "Jose", "Zapatero", "Alvarez", 29);
        Bibliotecario b9 = new Bibliotecario("B4", "999", "999", "Rafael", "Ferrero", "Alvarez", 28);
        Bibliotecario b10 = new Bibliotecario("B5", "555", "555", "Alejandro", "Alex", "Moreno", 26);
        Bibliotecario b11 = new Bibliotecario("B4", "1010", "1010", "Roberto", "Carlos", "Alvarez", 33);
        Bibliotecario b12 = new Bibliotecario("B5", "1111", "1111", "Franco", "Santander", "Moreno", 26);

        // añadimos  bibliotecarios a la lista del personal  diferentes bibliotecarios
        redBibliotecaria.getListaBibliotecas().get(0).getListaPersonas().add(b1);
        redBibliotecaria.getListaBibliotecas().get(0).getListaPersonas().add(b2);
        redBibliotecaria.getListaBibliotecas().get(0).getListaPersonas().add(b3);
        redBibliotecaria.getListaBibliotecas().get(1).getListaPersonas().add(b4);
        redBibliotecaria.getListaBibliotecas().get(1).getListaPersonas().add(b5);
        redBibliotecaria.getListaBibliotecas().get(1).getListaPersonas().add(b6);
        redBibliotecaria.getListaBibliotecas().get(2).getListaPersonas().add(b7);
        redBibliotecaria.getListaBibliotecas().get(2).getListaPersonas().add(b8);
        redBibliotecaria.getListaBibliotecas().get(2).getListaPersonas().add(b9);
        redBibliotecaria.getListaBibliotecas().get(3).getListaPersonas().add(b10);
        redBibliotecaria.getListaBibliotecas().get(3).getListaPersonas().add(b11);
        redBibliotecaria.getListaBibliotecas().get(3).getListaPersonas().add(b12);

        // creamos algunos libros para la biblioteca para probar
        // Libro  atributos : ISBN +  titulo + autor  + editorial + numCopias  + numCopiasDisponible
        Libro l1 = new Libro("001", "Divina comedia", "Dante", "La Pajarita Roja", 50, 9);
        Libro l2 = new Libro("002", "Divina comedia", "Dante", "Algani Editorial", 55, 0);
        Libro l3 = new Libro("003", "Divina comedia", "Dante", "Editorial Denes", 50, 50);
        Libro l4 = new Libro("004", "Don Quijote de la Mancha 1", "Cervantes", "Andavira Editora", 50, 9);
        Libro l5 = new Libro("005", "Don Quijote de la Mancha 2", "Cervantes", "Andavira Editora", 50, 10);
        Libro l6 = new Libro("006", "El idiota", "Dostoievski", "La Pajarita Roja", 50, 0);
        Libro l7 = new Libro("007", "El idiota", "Dostoievski", "Calambur Editorial", 50, 10);
        Libro l8 = new Libro("008", "Almas muertas", "Dostoievski", "La Pajarita Roja", 50, 1);
        Libro l9 = new Libro("009", "Lolita", "Nabokov", "La Pajarita Roja", 100, 0);
        Libro l10 = new Libro("010", "Romancero gitano", "Lorca", "Kraicon", 100, 50);
        Libro l11 = new Libro("011", "Romancero gitano", "Lorca", "Algani Editorial", 100, 50);
        Libro l12 = new Libro("012", "Romancero gitano", "Lorca", "Calambur Editorial", 50, 50);
        Libro l13 = new Libro("013", "Don Quijote de la Mancha 1", "Cervantes", "Calambur Editorial", 20, 0);
        Libro l14 = new Libro("014", "Don Quijote de la Mancha 2", "Cervantes", "Calambur Editorial", 20, 0);
        Libro l15 = new Libro("015", "Guerra y paz 1", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l16 = new Libro("016", "Guerra y paz 2", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l17 = new Libro("017", "Guerra y paz 3", "Tolstoi", "La Pajarita Roja", 20, 20);
        Libro l18 = new Libro("018", "Guerra y paz 4", "Tolstoi", "La Pajarita Roja", 20, 20);

        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l1);
        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l2);
        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l3);
        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l4);
        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l5);
        redBibliotecaria.getListaBibliotecas().get(0).getListaLibros().add(l6);
        redBibliotecaria.getListaBibliotecas().get(1).getListaLibros().add(l7);
        redBibliotecaria.getListaBibliotecas().get(1).getListaLibros().add(l8);
        redBibliotecaria.getListaBibliotecas().get(1).getListaLibros().add(l9);
        redBibliotecaria.getListaBibliotecas().get(1).getListaLibros().add(l10);
        redBibliotecaria.getListaBibliotecas().get(1).getListaLibros().add(l11);
        redBibliotecaria.getListaBibliotecas().get(2).getListaLibros().add(l12);
        redBibliotecaria.getListaBibliotecas().get(2).getListaLibros().add(l13);
        redBibliotecaria.getListaBibliotecas().get(2).getListaLibros().add(l14);
        redBibliotecaria.getListaBibliotecas().get(2).getListaLibros().add(l15);
        redBibliotecaria.getListaBibliotecas().get(3).getListaLibros().add(l16);
        redBibliotecaria.getListaBibliotecas().get(3).getListaLibros().add(l17);
        redBibliotecaria.getListaBibliotecas().get(3).getListaLibros().add(l18);

        // creamos algunos Usuarios de la biblioteca
        //Usuario( ArrayList<Reserva> listaReservas,telefono,  direcion, codigopostal, correo, nombre, apellido1, apellido2, edad
        Usuario u1 = new Usuario(new ArrayList<>(), "11111", "calle General Riera 11", "07552", "jose@gmail.com", "Jose", "Alonso", "Zapatero", 33);
        Usuario u2 = new Usuario(new ArrayList<Reserva>(), "22222", "caratera Militar 122", "07592", "antonio@gmail.com", "Antonio", "Garcia", "Serrano", 23);
        Usuario u3 = new Usuario(new ArrayList<Reserva>(), "33333", "plaza Paris 45", "07232", "david@gmail.com", "David", "Fernandez", "Goya", 43);
        Usuario u4 = new Usuario(new ArrayList<Reserva>(), "44444", "calle Matamorros 33", "07698", "fernando@gmail.com", "Fernando", "Rey", "Velazquez", 24);
        Usuario u5 = new Usuario(new ArrayList<Reserva>(), "55555", "plaza Mayor 3", "07114", "rafael@gmail.com", "Rafael", "Guion", "Muñoz", 36);
        Usuario u = new Usuario(new ArrayList<Reserva>(), "1", "1", "1", "1", "R", "G", "M", 11);

        // un par de reservas para probar
        Reserva r1 = new Reserva(l1, "2021-febrero-25", "06:12:27", "2021-marzo-25");
        Reserva r2 = new Reserva(l4, "2021-febrero-25", "06:12:27", "2021-marzo-25");

        // reservas añadimos al usuario u, el esta en todas  bibliotecas
        u.getListaReservas().add(r1);
        u.getListaReservas().add(r2);

        //añadimos a la lista de personas Usuarios
        redBibliotecaria.getListaBibliotecas().get(0).getListaPersonas().add(u1);
        redBibliotecaria.getListaBibliotecas().get(0).getListaPersonas().add(u);
        redBibliotecaria.getListaBibliotecas().get(1).getListaPersonas().add(u2);
        redBibliotecaria.getListaBibliotecas().get(1).getListaPersonas().add(u);
        redBibliotecaria.getListaBibliotecas().get(2).getListaPersonas().add(u3);
        redBibliotecaria.getListaBibliotecas().get(2).getListaPersonas().add(u);
        redBibliotecaria.getListaBibliotecas().get(3).getListaPersonas().add(u4);
        redBibliotecaria.getListaBibliotecas().get(3).getListaPersonas().add(u);

        return miBiblioteca;
    }// fin metodo inicializarBiblioteca
}
