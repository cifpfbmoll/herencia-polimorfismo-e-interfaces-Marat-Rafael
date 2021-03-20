/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

/**
 *
 * @author Marat Rafael
 */
public class CustomException extends Exception{
    // atributo
    public int numError;
    //constructor
    // constructor vacio
    public CustomException() {
    }
    //constructor con numero del error
    public CustomException(int numError) {
        super();
        this.numError = numError;
    }
    //constructor con mensaje
    public CustomException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String message = "";
        switch(numError){
            case 01:
                message="tiene que introducir valor numerica";
                break;
            case 02:
                message="";
                break;
            case 03:
                message="";
                break;
        }
        return message; 
    }
    
    
}
