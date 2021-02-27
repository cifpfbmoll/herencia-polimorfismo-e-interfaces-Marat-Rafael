/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class RedBibliotecas {
    //ATRIBUTOS
    private ArrayList <Biblioteca> listaBibliotecas ;

    //CONSTRUCTOR
    public RedBibliotecas() {
    }

    public RedBibliotecas(ArrayList<Biblioteca> listaBibliotecas) {
        this.listaBibliotecas = listaBibliotecas;
    }
    
    // GETTER/SETTER

    public ArrayList<Biblioteca> getListaBibliotecas() {
        return listaBibliotecas;
    }

    public void setListaBibliotecas(ArrayList<Biblioteca> redBibliotecaria) {
        this.listaBibliotecas = redBibliotecaria;
    }

    @Override
    public String toString() {
        return "RedBibliotecas{" + "redBibliotecaria=" + listaBibliotecas + '}';
    }
    
    
    /**
     * Metodo para mostrar todas bibliotecas que hay en la lista de la red Biblioteca
     * @param listaBibliotecas 
     */
    public static void  mostrarTodasBibliotecas(ArrayList<Biblioteca> listaBibliotecas){
        for (int i = 0; i < listaBibliotecas.size(); i++) {
            System.out.println(listaBibliotecas.get(i).getNombreBiblioteca().toString());           
        }
}
    
    
}
