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

        // creamos algunas personas para lista del personal
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
                            System.out.println("0 - Salir");
                            byte opcionBibliotecario = sc.nextByte();
                            sc.nextLine();
                            switch (opcionBibliotecario) {
                                case 1:
                                    // creamos instancia vacia
                                    Bibliotecario nuevoBibliotecario = new Bibliotecario();
                                    // metodo nos devuelve un Bibliotecario
                                    nuevoBibliotecario.solicitarDatosPersona();
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
