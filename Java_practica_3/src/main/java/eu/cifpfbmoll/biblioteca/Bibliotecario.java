/*
Desarrolla la clase ​ Bibliotecario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ puesto de trabajo, NIF y contraseña. Crea constructor
vacío, todos los parámetros (incluidos los de la superclase), copia, getters/setters y
toString (NO imprimirá los datos de la superclase).
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class Bibliotecario extends Persona {

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

    /**
     * metodo constructor que recibe como parametro una persona , mas atributos
     * del bibliotecario
     *
     * @param puestoTrabajo
     * @param NIF
     * @param contrasenia
     * @param persona le pasamo como parametro una persona ya existente
     */
    public Bibliotecario(String puestoTrabajo, String NIF, String contrasenia, Persona persona) {
        // super para aceder a los atributos de la persona
        super(persona.nombre, persona.apellido1, persona.apellido2,persona.edad);
        this.puestoTrabajo = puestoTrabajo;
        this.NIF = NIF;
        this.contrasenia = contrasenia;
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
    }// fin metodo accesoBibliotecarioBoolean

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

}//fin class Bibliotecario
