/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art4uinterfaz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rim El abrouki
 * @version 1.0
 * @since AaD 1.0
 */
public class Validacion {

    /**
     * Método que valida si un string contiene un dato de tipo int válido
     *
     * @param s String a validar si contiene un dato de tipo int válido
     * @return true si el string contiene un dato de tipo int válido o false en
     * caso contrario
     */
    public static boolean esEntero(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que se le pasa una cadena de caracteres y comprueba si es válida
     * para setearla como valor para el nombre,Apellido,Descripcion,titulo..etc
     *
     * Cadena de caracteres [1-50 caracteres] [a-z, A-Z], tildes, dieresis y
     * espacios
     *
     * @param str cadena de caracteres
     * @return true de ser un valor válido para un nombre y false si es que no
     */
    public static boolean esString(String str) {
        boolean ret = true;
        if (str.isEmpty()) {
            ret = false;
        }
        if (str.length() <= 1 || str.length() >= 150) {
            ret = false;
        }
        return ret;
    }

    /**
     * Método que se le pasa una caracteres individuales(letras) y comprueba si
     * es válida para setearla como valor para el genero.
     *
     *
     * @param genero char
     * @return true si genero igual una letra de los tres y false si es que no
     */
    public static boolean ValidarGenero(String genero) {
        if (genero.equals("V") || genero.equals("M") || genero.equals("O")) {

            return true;
        }
        return false;
    }

    /**
     * Método que valida si un string contiene un dato de clase SimpleDateFormat
     * válido
     *
     * @param s String a validar si contiene un dato de clase SimpleDateFormat
     * válido
     * @return true si el string contiene un dato de clase SimpleDateFormat
     * válido o false en caso contrario
     */
    public static boolean esFecha(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     *
     * Método que valida la forma de una dirección de correo electronico,
     *
     * @param email String
     *
     * @return true si la cadena con el valor del email valida o false en caso
     * contrario
     */
    public static Boolean validaEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * // metodo que valida el numero de la tarjeta,para que No Pasa 16 digitos

     * @param trj de tipo String
     * @return  el numero de tarjeta si, esta bien
     */
    public static boolean validarNumeroTarjeta(String trj) {
        return trj.matches("[0-9]{16}");
    }

}
