/*
Desarrolla la clase ​ Usuario​ . Heredará los atributos anteriores, pero además
deseamos almacenar su ​ teléfono, dirección, código postal, correo electrónico y lista
de Reservas​ . Crea constructor vacío, todos los parámetros (incluidos los de la
superclase), copia, getters/setters y toString (que imprimirá también los datos de la
superclase).
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class Usuario extends Persona {

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
    public Usuario( ArrayList<Reserva> listaReservas,
                    String telefono, 
                    String direccion, 
                    String codigoPostal, 
                    String correoElectronico,                      
                    String nombre, 
                    String apellido1, 
                    String apellido2, 
                    byte edad) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.listaReservas = listaReservas;
    }

    /**
     * constructor copia
     * @param usuario 
     */
    public Usuario(Usuario usuario) {
        //para aceder a campos del Persona, tengo convertir atributos del classe Persona en protected
        super(usuario.nombre, usuario.apellido1, usuario.apellido2, usuario.edad);
        this.telefono = usuario.telefono;
        this.direccion = usuario.direccion;
        this.codigoPostal = usuario.codigoPostal;
        this.correoElectronico = usuario.correoElectronico;
        this.listaReservas = usuario.listaReservas;
    }
    /**
     * constructor con un parametro Persona ya existente, mas con todos atributos
     * @param persona
     * @param telefono
     * @param direccion
     * @param codigoPostal
     * @param correoElectronico
     * @param listaReservas 
     */
    public Usuario( Persona persona,
                    String telefono, 
                    String direccion, 
                    String codigoPostal, 
                    String correoElectronico, 
                    ArrayList<Reserva> listaReservas) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.listaReservas = listaReservas;
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
        return super.toString()+" Usuario{" + "telefono=" + telefono + ", direccion=" + direccion + ", codigo Postal=" + codigoPostal + ", correo Electronico=" + correoElectronico + ", listaReservas=" + listaReservas + '}'; 
    }

    @Override
    public Persona solicitarDatosPersona() {
        //solicitarDatosPersona del padre nos devuelve una persona lo almacenamos en nueva variable
        Persona nuevaPersona = super.solicitarDatosPersona();
        System.out.println("Telefono: ");
        String nuevoTelefono = sc.nextLine();
        System.out.println("Direccion: ");
        String nuevoDireccion = sc.nextLine();
        System.out.println("Codigo postal: ");
        String nuevoCodigoPostal = sc.nextLine();
        System.out.println("Correo electronico");
        String nuevoCorreoElectronico=sc.nextLine();
        
        //para nuevo usuario creamos nuevo ArrayList de reservas
        ArrayList<Reserva> nuevaListaReseva = new ArrayList();
        // apartir de los datos creamos nuevo usuario
        Usuario nuevoUsuario = new Usuario(nuevaPersona,nuevoTelefono, nuevoDireccion, nuevoCodigoPostal, nuevoCorreoElectronico, nuevaListaReseva);
        return nuevoUsuario;
    }//fin metodo solicitarDatosPersona



    
    

}// fin classe Usuario
