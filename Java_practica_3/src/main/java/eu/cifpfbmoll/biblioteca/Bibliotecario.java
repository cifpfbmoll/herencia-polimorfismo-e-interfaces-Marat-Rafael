/*
Desarrolla la clase ​ Bibliotecario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ puesto de trabajo, NIF y contraseña. Crea constructor
vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y
toString (NO imprimirá los datos de la superclase).
 */
package eu.cifpfbmoll.biblioteca;

//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
// nueva subClase bibliotecario que es hijo de Persona
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
        super(bibliotecario.getNombre(), bibliotecario.getApellido1(), bibliotecario.getApellido2(), bibliotecario.getEdad());
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
        
    }// fin metodo solicitarDatosPersona

    /**
     * Un metodo para comprobar si el usuario puede acceder
     *
     * @param listaPersonas lista de personas donde buscamos bibliotecario
     * @return devuelve posicion del bibliotecario enla lista, o -1 si no lo
     * encuentra
     */
    public static int accesoBibliotecario(ArrayList<Persona> listaPersonas) {
        // posicion predeterminada -1, si encontramos en la lista de Personas cambiamos posicion
        boolean encontrado = false;
        int posicionBibliotecario = -1;
        System.out.println("NIF del Bibliotecario: ");
        String nifBuscado = sc.nextLine();
        
        System.out.println("Contraseña: ");
        String contraseniaBuscada = sc.nextLine();
        // cambiamos a while
        int j = 0;
        // tiene que cumplis las dos condiciones , si una no se cumple (por ejemplo encuntra elemento) sale del while
        while (j < listaPersonas.size() && !encontrado) {
            // comprobamos cada Persona, si es Bibliotecario
            if (listaPersonas.get(j) instanceof Bibliotecario) {
                // comparamos con datos introducidos
                // comparamos NIF con nifBuscado usando casting
                if (((Bibliotecario) listaPersonas.get(j)).getNIF().equals(nifBuscado)
                        // &&  y comparamos getContraseña con contraseñaBuscada usando casting
                        && ((Bibliotecario) listaPersonas.get(j)).getContrasenia().equals(contraseniaBuscada)) {
                    // SOLO si las dos busquedas coinciden pasamos encontradoISBN a true
                    encontrado = true;
                    // en posicion guardamos index del ArrayList
                    posicionBibliotecario = j;
                }
            }
            j++;
        }
        return posicionBibliotecario;
    }// fin metodo acesoBibliotecario

    public void mostrarTodosBibliotecarios(ArrayList<Persona> listaPersonas) {
        // for para recorrer todo arraylista y mostrar cada elemento
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                System.out.println(((Bibliotecario) listaPersonas.get(i)).toString2());
            }
        }
    }// fin metodo mostrarTodosBibliotecarios

    /**
     * Metodo para borrar bibliotecario de la lista de usuarios si lo encuentra
     *
     * @param listaPersonas como parametro pasamos un ArrayList de usuarios
     */
    public void borrarBibliotecario(ArrayList<Persona> listaPersonas) {
        System.out.println("Indica NIF del Bibliotecario a borrar: ");
        String nifBorrar = sc.nextLine();

        //creamos variable donde guardamos index del bibliotecario, usamos metodo que devuelve posicion de bibliotecario en la lista, si no encuentra devuelve -1
        int posicionBorrar = buscarBibiotecarioNifPosicion(nifBorrar, listaPersonas);
        // si devuelve -1, no esta en la lista
        if (posicionBorrar == -1) {
            System.out.println("No se encuentraeste Bibliotecario en la lista");
        } else {
            // si es una posicion destinta de -1, primero mostramos bibliotecario
            System.out.println(listaPersonas.get(posicionBorrar).toString());
            System.out.println("Borrado de la lista");
            // borramos bibliotecario
            listaPersonas.remove(posicionBorrar);
            
        } // fin else
    }// fin metodo borrarBibliotecario

    /**
     * metodo para comprobar si bibliotecario esta en la lista, devuelve su
     * posicion o -1 si no se encuentra
     *
     * @param nifBuscado como parametro recibe un String con nif que buscamos
     * @param listaPersonas Arraylist de Personas, usando casting tendremos que
     * comprobar si es bibliotecario
     * @return devuelve un numero que se refiere a la posicion del bibliotecario
     * dentro de ArrayList, si no lo esncuentra devuelve -1
     */
    public int buscarBibiotecarioNifPosicion(String nifBuscado, ArrayList<Persona> listaPersonas) {
        // valor predeterminado sera -1, si encontramos al bibliotecario devolvemos su posicion en la lista de personas
        int posicion = -1;
        boolean encontrado = false;
        //recoremos array, cambiamos a while
        // mientras no encontramos posicion y no terminamos lista, debe cumplir las dos condiciones, para siguir buscando
        int j = 0;
        while (!encontrado && j < listaPersonas.size()) {
            // comprobamos cada elemento de la lista de personas, si es instancia del Bibliotecario
            if (listaPersonas.get(j) instanceof Bibliotecario) {
                if ( // usamos casting para acceder a getNif
                        ((Bibliotecario) listaPersonas.get(j)).getNIF().equals(nifBuscado)) {
                    posicion = j;
                    encontrado = true;
                }
            }
            j++;
        }
        return posicion;
    }// fin metodo buscar BibliotecarioNifBoolean

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
                        
                        LocalDate fechaReserva = calcularFechaReserva();
                        
                        LocalTime horaReserva = calcularHoraReserva();

                        // copiamos libro en un nuevo objeto
                        Libro libroReservado = listaLibros.get(indiceLibro);

                        // creamos nuevo objeto reserva, 
                        Reserva nuevaReserva = new Reserva();
                        // le insertamos libro reservado
                        nuevaReserva.setLibro(libroReservado);
                        // insertamos fecha con su formato, en parentesis indicamos formato para representar resultado
                        nuevaReserva.setFechaReserva(fechaReserva.format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd")));
                        // insertamos hora con su formato en parentesis indicamos formato para representar la hora
                        nuevaReserva.setHoraReserva(horaReserva.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        // insertamos fecha devolucion calculada por el metodo obtenerFechaDevolucion
                        nuevaReserva.setFechaDevolucion(nuevaReserva.obtenerFechaDevolucion());

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
     * metodo para calcular la hora de crear reserva a partir de LocalTime,
     * aplicando formato de DateTimeFormater
     *
     * @return devuelve la hora cuando creamos la reserva
     */
    public LocalTime calcularHoraReserva() {
        //------------Creamos hora--------------
        // creamos objeto de la horaLocal
        LocalTime horaReserva = LocalTime.now();
        // creamos formato
        // DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        // aplicamos formato al objeto de la horaReserva, en una linea con DateTimeFormater 
        horaReserva.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return horaReserva;
    }// fin metodo calcularHoraReserva

    /**
     * metodo para calcular la fecha de la reserva usando objeto de LocalDate y
     * aplicando formato de DateTimeFormater
     *
     * @return devuelve la fecha cuando creamos la reserva
     */
    public LocalDate calcularFechaReserva() {
        //--------------Creamos fecha-----------
        // nuevo objeto que da formato a la fecha
        //DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
        // nuevo objeto fecha local
        LocalDate fechaReserva = LocalDate.now();
        //a la fecha local aplicalos formato , en parentesis indicamos formato de representar fecha
        fechaReserva.format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd"));
        return fechaReserva;
    }

    /**
     * metodo para devolver libro a la biblioteca , primero comprobamos que
     * usuario existe
     *
     * @param listaLibros pasamos como parametroArrayList de libros
     * @param listaPersonas pasamos como parametro ArrayList de personas
     */
    public void devolverLibro(ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {
        // primero llamamos metodo que nos devuelve un numero
        int indiceUsuario = Usuario.confirmarUsuario(listaPersonas);
        // si el numero es destinto de -1, usuario existe en la lista
        if (indiceUsuario != -1) {
            // mostramos usuario usando casting
            Usuario usuarioConfirmado = (Usuario) listaPersonas.get(indiceUsuario);
            System.out.println(usuarioConfirmado.toString());

            // si usuario tiene lista de reservas mas de 0 mostramos reservas para informar lo que tiene reservado
            if (usuarioConfirmado.getListaReservas().size() > 0) {
                
                System.out.println("Reservas del usuario");
                System.out.println("************************");
                // mostramos todas reservas actuales del usuario
                usuarioConfirmado.mostrarReservasUsuario(usuarioConfirmado);

                // preguntamos que libro desea devolver
                System.out.println("************************");
                System.out.println("ISBN del libro que devuelve usuario");
                String isbnDevolver = sc.nextLine();

                // recoreemos lista de reservas para comprobar que ISBN indicado coincide con ISBN de reservado, cambiamos a while
                boolean encontradoISBN = false;
             
                int j = 0;
                // mientras no encontramos libro o no termina la lista de reservas , tiene que cumplir las dos condiciones para siguir buscar
                while (!encontradoISBN && j < usuarioConfirmado.getListaReservas().size()) {                    
                    if (usuarioConfirmado.getListaReservas().get(j).getLibro().getISBN().equals(isbnDevolver)) {
                        // si coinciden libro de la reserva y libro escrita por usuario borramos la reserva que contiene este libro
                        usuarioConfirmado.getListaReservas().remove(j);
                        System.out.println("Reserva borrada");
                        encontradoISBN = true;
                    }else{
                        System.out.println("No hay libro con ISBN " + isbnDevolver);
                    }
                    j++;
                }
                // ahora hay que aumentar numero de copias de libros disponibles
                // llamamos metodo que nos devuelve la posicion del libro en la lista de libros
                   int posicionISBN = Libro.confirmarLibro(isbnDevolver, listaLibros);
                   // accedemos alli y aumentamos en uno libros disponibles
                   int numCopiasDisponibles = listaLibros.get(posicionISBN).getNumCopiasDisponibles();
                   numCopiasDisponibles = numCopiasDisponibles+1;
                   listaLibros.get(posicionISBN).setNumCopiasDisponibles(numCopiasDisponibles);
 
            }// fin if usuario confirmado
        }
    }// fin metodo devolverLibro

    /**
     * metodo abstracto para cambiar contraseña
     */
    @Override
    public void cambiarContrasenia() {
        boolean contraseniasCoinciden = false;
        do {
            System.out.println("Escribe nueva contraseña: ");
            String nuevaContrasenia1 = sc.nextLine();
            System.out.println("Vuelve a escribir nueva contraseña: ");
            String nuevaContrasenia2 = sc.nextLine();
            if (nuevaContrasenia1.equals(nuevaContrasenia2)) {
                contraseniasCoinciden = true;
                this.setContrasenia(nuevaContrasenia1);
                System.out.println("Nueva contraseña esta establecida");
            }
        } while (!contraseniasCoinciden);
    }// fin metodo cambiarContrasenia

}//fin class Bibliotecario
