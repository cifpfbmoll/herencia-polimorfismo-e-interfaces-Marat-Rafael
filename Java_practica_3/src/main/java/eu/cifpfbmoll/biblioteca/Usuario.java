/*
Desarrolla la clase ​ Usuario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ teléfono, dirección, código postal, correo electrónico y lista
de Reservas​ . Crea constructor vacío, todos los parámetros (incluidos los de la
superclase), copia, getters/setters y toString (que imprimirá también los datos de la
superclase).
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Marat Rafael
 */
public class Usuario extends Persona {

    static Scanner sc = new Scanner(System.in);
    //Atributos
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private String correoElectronico;
    private ArrayList<Reserva> listaReservas;

    //Constructores
    /**
     * constructor vacio
     */
    public Usuario() {
    }

    /**
     * constructor con todos atributos
     *
     * @param listaReservas
     * @param telefono
     * @param direccion
     * @param codigoPostal
     * @param correoElectronico
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param edad
     */
    public Usuario(ArrayList<Reserva> listaReservas,
            String telefono,
            String direccion,
            String codigoPostal,
            String correoElectronico,
            String nombre,
            String apellido1,
            String apellido2,
            int edad) {
        // con suer accedemos a los campos de los atributos de la persona
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.listaReservas = listaReservas;
    }

    /**
     * constructor copia
     *
     * @param usuario
     */
    public Usuario(Usuario usuario) {
        //para aceder a campos del Persona, tengo convertir atributos del classe Persona en protected
        super(usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getEdad());
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigoPostal = usuario.codigoPostal;
        this.correoElectronico = usuario.correoElectronico;
        this.listaReservas = usuario.listaReservas;
    }

    //GETTER/SETTER
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return super.toString() + " Usuario{" + "telefono=" + telefono + ", direccion=" + direccion + ", codigo Postal=" + codigoPostal + ", correo Electronico=" + correoElectronico + ", listaReservas=" + listaReservas + '}';
    }

    /**
     * metodo para completar datos del Usuario existente
     */
    @Override
    public void solicitarDatosPersona() throws Exception{
        // primero llamamos al padre y rellenamos campos de la persona
        super.solicitarDatosPersona();
        System.out.println("Telefono: ");
        String nuevoTelefono = sc.nextLine();
        System.out.println("Direccion: ");
        String nuevoDireccion = sc.nextLine();
        System.out.println("Codigo postal: ");
        String nuevoCodigoPostal = sc.nextLine();
        System.out.println("Correo electronico");
        String nuevoCorreoElectronico = sc.nextLine();

        // insertamos datos indicados al Usuario
        this.setTelefono(nuevoTelefono);
        this.setDireccion(nuevoDireccion);
        this.setCodigoPostal(nuevoCodigoPostal);
        this.setCorreoElectronico(nuevoCorreoElectronico);

    }

    // metodo para controlar que no haya mas de 5 libros reservados
    /**
     *
     * @return false si hay mas de 5 libros en la lista de reservas
     */
    public boolean librosControl() {
        // acedemos a la lista de reservas del usuario, si su tamaño es menos que 5 devuelve true
        if (this.getListaReservas().size() < 5) {
            return true;
        }
        return false;
    }// finmetodo librosControl

    public void mostrarReservasUsuario(Usuario usuario) {
        for (int i = 0; i < usuario.getListaReservas().size(); i++) {
            System.out.println(usuario.getListaReservas().get(i).toString());
        }
    }

    /**
     * metodo para confirmar que usuario esta ne la lista de personas, devuelve
     * un numero que es su posicion en la lista de Personas devuelve -1 si no
     * encontrado
     *
     * @param listaPersonas pasamos ArrayList de Personas
     */
    public static int confirmarUsuario(ArrayList<Persona> listaPersonas) {
        int posicionUsuario = -1;
        boolean encontradoUsuario = false;
        System.out.println("Indica telefono del usuario: ");
        String telefonoBuscar = sc.nextLine();
        System.out.println("Indica correo del usuario: ");
        String mailBuscar = sc.nextLine();
        // cambiamos a while
        int j = 0;
        while (!encontradoUsuario && j < listaPersonas.size()) {
            // si una persona es usuario
            if (listaPersonas.get(j) instanceof Usuario) {
                // usamos casting para aceder a get Telegono y compararlo con lo que introduce usuario
                if (((Usuario) listaPersonas.get(j)).getTelefono().equals(telefonoBuscar)
                        // &&  comparamos mail
                        && ((Usuario) listaPersonas.get(j)).getCorreoElectronico().equals(mailBuscar)) {
                    // si las dos cosas coinciden guardamos posicion del usuario
                    posicionUsuario = j;
                    // usuario encontrado pasamos a true para salir del bucle
                    encontradoUsuario = true;
                }
            }
            j++;
        }//fin while
        System.out.println("Usuario no confirmado");
        return posicionUsuario;
    }// fin metodo confirmarUsuario

    /**
     * metodo estatico para crear nuevo Usuario
     *
     * @param listaPersonas ArrayList de personas
     */
    public static void crearNuevoUsuarioParaLista(ArrayList<Persona> listaPersonas) throws Exception{
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.solicitarDatosPersona();
        listaPersonas.add(usuarioNuevo);
    }// fin crearNuevoUsuario

    /**
     * metodo de la clase Usuario para mostrar todas reserva de usuario
     */
    public void mostrarReservas() {
        if (this.getListaReservas().isEmpty()) {
            System.out.println("No tiene reservas");
        } else {
            for (int i = 0; i < this.getListaReservas().size(); i++) {
                System.out.println(this.getListaReservas().get(i).mostrarInfoChula());
            }
        }
    }// fin metodo mostrarReservas

    /**
     * metodo para mostrar todos usuarios registrados
     *
     * @param listaPersonas
     */
    public static void mostrarTodosUsuarios(ArrayList<Persona> listaPersonas) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) instanceof Usuario) {
                System.out.println(listaPersonas.get(i).toString());
            }
        }
    }//fin metodo mostrarTodosUsuarios

    /**
     * metodo abstracto de la clase persona para cambiar contraseña en el
     * Usuario en vez de contraseña usamos correo electronico
     */
    @Override
    public void cambiarContrasenia() {
        boolean contraseniasCoinciden = false;
        do {
            System.out.println("Correo electronico se usa como contraseña en esta aplicacion");
            System.out.println("Escribe nuevo correo electronico: ");
            String nuevaContrasenia1 = sc.nextLine();
            System.out.println("Vuelve a escribir nuevo correo electronico: ");
            String nuevaContrasenia2 = sc.nextLine();
            if (nuevaContrasenia1.equals(nuevaContrasenia2)) {
                contraseniasCoinciden = true;
                this.setCorreoElectronico(nuevaContrasenia1);
                System.out.println("Nueva contraseña establecida");
            }
        } while (!contraseniasCoinciden);
    }// fin metodo cambiarContraseña

    /**
     * metodo para mostrar todos usuarios que tienen reserva
     * @param listaPersonas 
     */
    public static void mostrarTodosUsuariosConReservas(ArrayList<Persona> listaPersonas) {
        // nuevo arraylist para guardar todas personas que tiene reservas
        ArrayList<Usuario> listaUsuariosConReserva = new ArrayList();
    
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) instanceof Usuario) {
                // casting a Usuario y acceso a lista de reservas              
                for (int j = 0; j < ((Usuario) listaPersonas.get(i)).getListaReservas().size(); j++) {
                    // si usuario tiene lista de reservas mas que 0, tiene reservas
                    if (((Usuario) listaPersonas.get(i)).getListaReservas().size() > 0) {
                        
                        Usuario usuarioConReservas = ((Usuario) listaPersonas.get(i));
                        // añadimos usuario en la lista de usuarios con reserva
                        listaUsuariosConReserva.add(usuarioConReservas);
                    }
                }
            }
        }

        // importamos Set y HashSet, para eliminar objetos dublicados    
        // 
        Set<Usuario> hashSet = new HashSet<>(listaUsuariosConReserva);
        // borramos todo
        listaUsuariosConReserva.clear();
        // añadimos todo, pero sin repitir
        listaUsuariosConReserva.addAll(hashSet);
        
        System.out.println("");
        for (Usuario usuario : listaUsuariosConReserva) {
            System.out.println(usuario);
        }
    }// fin metodo mostrarTodosUsuariosConReserva
    

}// fin classe Usuario
