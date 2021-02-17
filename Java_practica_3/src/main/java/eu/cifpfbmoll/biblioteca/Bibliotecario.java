/*
Desarrolla la clase ​ Bibliotecario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ puesto de trabajo, NIF y contraseña. Crea constructor
vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y
toString (NO imprimirá los datos de la superclase).
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
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
     * un metodo que pide datos y devuelve un Bibliotecario parte del metodo
     * usamos del padre que devuelve una persona a partir de la cual creamos
     * bibliotecario
     *
     * @return bibliotecario
     */
    /* obsoleto , para borrar
    @Override
    public Bibliotecario solicitarDatosPersona() {
        // creamos instancia de persona nuevaPersona la que recibe caracteristicas del metodo padre
        Persona nuevaPersona = super.solicitarDatosPersona();

        System.out.println("Puesto de trabajo: ");
        String nuevoPuestoTrabajo = sc.nextLine();
        System.out.println("NIF: ");
        String nuevoNIF = sc.nextLine();
        System.out.println("Contraseña: ");
        String nuevaContrasenia = sc.nextLine();

        // creamos instancia del Bibliotecario
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nuevoPuestoTrabajo, nuevoNIF, nuevaContrasenia, nuevaPersona);
        // devuelvo una instancia creada del bibliotecario
        return nuevoBibliotecario;
    }//fin metodo solicitarDatosPersona
     */
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
        int posicion = -1;
        // aqui guardamos la posicion de la persona que va hacer reserva
        int indiceUsuario = confirmarUsuario(listaPersonas);
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
                
                // llamamos metodo que nos devuelve posicion del libro
                posicion = Libro.confirmarLibro(isbnBuscado, listaLibros);
                
                if(posicion == -1){
                    System.out.println("No se encuentra libro con ISBN "+isbnBuscado);
                    
                }else{
                    System.out.println("Encontramos un libro con ISBN indicado ");
                    System.out.println(listaLibros.get(posicion).toString()); 
                    
                    Libro libroReservado = listaLibros.get(posicion);
                    
                    // accedemos a numero de copias
                    numeroCopias = listaLibros.get(posicion).getNumCopiasDisponibles();
                    // restamos uno
                    numeroCopias = numeroCopias-1;
                    // modificamos en la lista de libros
                    listaLibros.get(posicion).setNumCopiasDisponibles(numeroCopias);
                    
                }              
                
            }

        }

    }

    /**
     * metodo para confirmar que usuario esta ne la lista de personas
     *
     * @param listaPersonas
     */
    public static int confirmarUsuario(ArrayList<Persona> listaPersonas) {
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

}//fin class Bibliotecario
