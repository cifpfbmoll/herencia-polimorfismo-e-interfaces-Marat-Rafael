/*
Desarrolla la clase ​ Bibliotecario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ puesto de trabajo, NIF y contraseña. Crea constructor
vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y
toString (NO imprimirá los datos de la superclase).
 */
package eu.cifpfbmoll.biblioteca;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class Bibliotecario extends Persona {

    static Scanner sc = new Scanner(System.in);

    private String puestoTrabajo;
    private String NIF;
    private String contrasenia;

    /**
     * constructor vacio
     */
    public Bibliotecario() {
    }

    /**
     * Constructor con todos atributoss
     *
     * @param puestoTrabajo
     * @param NIF
     * @param contrasenia
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param edad
     */
    public Bibliotecario(String puestoTrabajo, String NIF, String contrasenia, String nombre, String apellido1, String apellido2, int edad) {
        // super acedemos a todos atributos del persona
        super(nombre, apellido1, apellido2, edad);
        this.puestoTrabajo = puestoTrabajo;
        this.NIF = NIF;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor copia
     *
     * @param bibliotecario recibe como parametro un bibliotecario existente y
     * lo copia
     */
    public Bibliotecario(Bibliotecario bibliotecario) {
        // con super acedemos a todo atributos de la persona
        super(bibliotecario.nombre, bibliotecario.apellido1, bibliotecario.apellido2, bibliotecario.edad);
        this.puestoTrabajo = bibliotecario.puestoTrabajo;
        this.NIF = bibliotecario.NIF;
        this.contrasenia = bibliotecario.contrasenia;
    }

    //GETTER/SETTER
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "puestoTrabajo=" + puestoTrabajo + ", NIF=" + NIF + ", contrasenia=" + contrasenia + '}';
    }
    // metodo para mostrar toString completo del Bibliotecario

    public String toString2() {
        return super.toString() + " Bibliotecario{" + "puestoTrabajo=" + puestoTrabajo + ", NIF=" + NIF + ", contrasenia=" + contrasenia + '}';
    }

    // resto de metodos
    /**
     * metodo para rellenar datos del Bibliotecario
     */
    @Override
    public void solicitarDatosPersona() {
        // primero llamamos alpadre y rellenamos dato de la persona
        super.solicitarDatosPersona();
        // solicitamos datos del bibliotecario
        System.out.println("Puesto de trabajo: ");
        String nuevoPuestoTrabajo = sc.nextLine();
        System.out.println("NIF: ");
        String nuevoNIF = sc.nextLine();
        System.out.println("Contraseña: ");
        String nuevaContrasenia = sc.nextLine();
        // inserteamos datos a la instancia del Bibliotecario
        this.setPuestoTrabajo(nuevoPuestoTrabajo);
        this.setNIF(nuevoNIF);
        this.setContrasenia(nuevaContrasenia);
    }

    /**
     * metodo para ver si bibliotecario existe en la lista
     *
     * @param listaPersonas
     * @return
     */
    public boolean accesoBibliotecarioBoolean(ArrayList<Persona> listaPersonas) {
        System.out.println("NIF del Bibliotecario: ");
        String nifBuscado = sc.nextLine();

        System.out.println("Contraseña: ");
        String contraseniaBuscada = sc.nextLine();

        //recorremos arraylist de personas
        for (int i = 0; i < listaPersonas.size(); i++) {
            // si un elemento es Bibliotecario
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                // casting para ser Bibliotecario
                if (((Bibliotecario) listaPersonas.get(i)).getNIF().equals(nifBuscado)
                        // comparamos con nif del bibliotecario de la lista
                        && ((Bibliotecario) listaPersonas.get(i)).getContrasenia().equals(contraseniaBuscada)) {
                    // comparamos con contraseña del Bibliotecario
                    return true;
                }
            }
        }
        return false;
    } // fin metodo accesoBibliotecarioBoolean

    public void mostrarTodosBibliotecarios(ArrayList<Persona> listaPersonas) {

        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                System.out.println(((Bibliotecario) listaPersonas.get(i)).toString2());
            }
        }
    }// fin metodo mostrarTodosBibliotecarios

    public void borrarBibliotecario(ArrayList<Persona> listaPersonas) {
        System.out.println("Indica NIF del Bibliotecario a borrar: ");
        String nifBorrar = sc.nextLine();
        if (!buscarBibiotecarioNifBoolean(nifBorrar, listaPersonas)) {
            System.out.println("No se encuentraeste Bibliotecario en la lista");
        } else {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i) instanceof Bibliotecario) {
                    if (((Bibliotecario) listaPersonas.get(i)).getNIF().equalsIgnoreCase(nifBorrar)) {
                        System.out.println(((Bibliotecario) listaPersonas.get(i)).toString2());
                        System.out.println("Borrado de la lista");
                        listaPersonas.remove(i);

                    }
                }
            }
        }
    }// fin metodo borrarBibliotecario

    /**
     *
     * @param nifBuscado
     * @param listaPersonas
     * @return
     */
    public boolean buscarBibiotecarioNifBoolean(String nifBuscado, ArrayList<Persona> listaPersonas) {
        //recoremos array
        for (int i = 0; i < listaPersonas.size(); i++) {
            //si elemento instanceof de Bibliotecario
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                // comparamos con nif si es igual devolver true
                if (((Bibliotecario) listaPersonas.get(i)).getNIF().equalsIgnoreCase(nifBuscado)) {
                    return true;
                }
            }
        }
        return false;
    }// fin metodo buscar BibliotecarioNifBoolean

    /**
     *
     * @param nifBuscado
     * @param listaPersonas
     */
    public void buscarBibiotecarioNif(String nifBuscado, ArrayList<Persona> listaPersonas) {
        //recoremos array
        for (int i = 0; i < listaPersonas.size(); i++) {
            //si elemento instanceof de Bibliotecario
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                // comparamos con nif si es igual devolver true
                if (((Bibliotecario) listaPersonas.get(i)).getNIF().equalsIgnoreCase(nifBuscado)) {

                }
            }
        }

    }// fin metodo buscar BibliotecarioNif

    /**
     * El método ​ reservarLibro​ , pedirá al usuario el teléfono y el correo
     * electrónico, si coincide, le permitirá realizar la reserva, y por tanto,
     * solicitará el ISBN del libro, y en consecuencia quedará completa la
     * información de la reserva (revisa la clase Reserva). Debes tener en
     * cuenta que debes actualizar la clase Libro, con la información de libros
     * disponibles, y obviamente se debe tener en cuenta que no podrá reservar
     * si no hay unidades disponibles.
     */
    public void reservarLibro(ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {
        int numeroCopias;
        int indiceLibro = -1;
        // aqui guardamos la indiceLibro de la persona que va hacer reserva
        int indiceUsuario = Usuario.confirmarUsuario(listaPersonas);
        if (indiceUsuario != -1) {
            // si usuario existecreamos objeto Usuario y rellenamos con datos del ArrayList
            Usuario usuario = new Usuario();
            usuario = (Usuario) listaPersonas.get(indiceUsuario);
            System.out.println(usuario.toString());

            // comprobamos que tiene reservas menos que 5
            if (usuario.librosControl()) {
                // solicitamos libro que quere reservar
                System.out.println("Tiene menos de 5 reservas puede solicitar un libro");
                System.out.println("ISBN: ");
                String isbnBuscado = sc.nextLine();

                // llamamos metodo que nos devuelve indiceLibro del libro
                indiceLibro = Libro.confirmarLibro(isbnBuscado, listaLibros);

                if (indiceLibro == -1) {
                    System.out.println("No se encuentra libro con ISBN " + isbnBuscado);

                } else {
                    System.out.println("Encontramos un libro con ISBN indicado ");
                    System.out.println(listaLibros.get(indiceLibro).toString());

                    if (listaLibros.get(indiceLibro).getNumCopiasDisponibles() < 1) {
                        System.out.println("Lo siento no quedan copias disponibles");
                    } else {

                        //--------------Creamos fecha-----------
                        // nuevo objeto que da formato a la fecha
                        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        // nuevo objeto fecha local
                        LocalDate fechaReserva = LocalDate.now();
                        //a la fecha local aplicalos formato 
                        fechaReserva.format(formatoFecha);
                        //------------Creamos hora--------------
                        // creamos objeto de la horaLocal
                        LocalTime horaReserva = LocalTime.now();
                        // creamos formato
                        DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                        // aplicamos formato al objeto de la horaReserva
                        horaReserva.format(formatHora);
                        //---------------------------------------

                        // copiamos libro en un nuevo objeto
                        Libro libroReservado = listaLibros.get(indiceLibro);
                        // creamos nuevo objeto reserva, dentro tiene un libro reservado, fecha y hora

                        Reserva nuevaReserva = new Reserva(libroReservado, fechaReserva.format(formatoFecha), horaReserva.format(formatHora));

                        // acedemos a la lista de reservas de Usuario y le añadimos esta nueva reserva
                        usuario.getListaReservas().add(nuevaReserva);

                        // accedemos a numero de copias
                        numeroCopias = listaLibros.get(indiceLibro).getNumCopiasDisponibles();
                        // restamos uno
                        numeroCopias = numeroCopias - 1;
                        // modificamos en la lista de libros
                        listaLibros.get(indiceLibro).setNumCopiasDisponibles(numeroCopias);

                        System.out.println("Reserva creada");
                        System.out.println(nuevaReserva.toString());
                    }
                }
            } else {
                System.out.println("Tiene 5 libros reservados, no puede hacer mas reservas");
                //System.out.println(usuario.getListaReservas().toString());
                for (int i = 0; i < usuario.getListaReservas().size(); i++) {
                    System.out.println(usuario.getListaReservas().get(i).toString());

                }
            }
        }
    }// fin metodo reservarLibro

    /**
     * metodo para devolver libro a la biblioteca
     *
     * @param listaLibros
     * @param listaPersonas
     */
    public void devolverLibro(ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {

        int indiceUsuario = Usuario.confirmarUsuario(listaPersonas);

        if (indiceUsuario != -1) {

            // mostramos usuario usando casting
            Usuario usuarioConfirmado = (Usuario) listaPersonas.get(indiceUsuario);
            System.out.println(usuarioConfirmado.toString());

            // si usuario tiene lista de reservas mas de 0 lostramos reservas
            if (usuarioConfirmado.getListaReservas().size() > 0) {

                System.out.println("Reservas del usuario");
                System.out.println("************************");
                // mostramos todas reservas actuales del usuario
                usuarioConfirmado.mostrarReservasUsuario(usuarioConfirmado);
                
                System.out.println("************************");
                System.out.println("ISBN del libro que devuelve usuario");
                String isbnDevolver = sc.nextLine();

                // recoreemos lista de reservas para comprobar que ISBN indicado coincide con ISBN de reservado
                for (int i = 0; i < usuarioConfirmado.getListaReservas().size(); i++) {
                    // si coincide
                    if (usuarioConfirmado.getListaReservas().get(i).getLibro().getISBN().equals(isbnDevolver)) {
                        // borramos elemento de la lista
                        usuarioConfirmado.getListaReservas().remove(i);
                        System.out.println("Reserva borrada");
                        usuarioConfirmado.mostrarReservasUsuario(usuarioConfirmado);
                    }else{
                        System.out.println("No hay libro con ISBN "+ isbnDevolver);
                    }
                }
                // ahora hay que aumentar numero de copias de libros disponibles
                // recorremos lista de libros
                for (int i = 0; i < listaLibros.size(); i++) {
                    // cuando encontramos isbn que coinciden
                    if (listaLibros.get(i).getISBN().equals(isbnDevolver)) {
                        // acedemos a numero de copias
                        int copiasActuales = listaLibros.get(i).getNumCopiasDisponibles();
                        // modificamos +1
                        copiasActuales++;
                        // y devolvemos a la lista
                        listaLibros.get(i).setNumCopiasDisponibles(copiasActuales);
                    }
                }
            }// fin if usuario confirmado
        }
    }// fin metodo devolverLibro

}//fin class Bibliotecario
