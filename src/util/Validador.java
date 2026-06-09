
package util;

/**
 *Clase auxiliar que contiene metodos de validacion en LlanquihueTour
 *
 */

public class Validador {

/**
     * Valida si un texto no está vacío.
     * 
     * @param texto texto que se desea validar
     * @return true si el texto tiene contenido, false si está vacío
     */
    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

/**
 * Valida que una direccion sea un numero positivo
 * 
 * @param numero numero de direccion que se desea validar
 * @return true si el numero es positivo
 */    
    
public static boolean numeroDirValido(int numero) {
        return numero > 0;
    }

/**
 * Valida si un telefono tiene 9 digitos (standard en Chile)
 * @param telefono numero de telefono a verificar
 * @return true si el numero contiene 9 digitos
 */

public static boolean telefonoValido(int telefono) {
        return telefono >= 100000000 && telefono <= 999999999;
    }

/**
     * Valida que el RUT tenga el formato correcto (en cantidad de digitos,
     * digitos correctos y el digito verificador).
     *
     * @param rut RUT que se desea validar
     * @return true si el formato es correcto.
     */
public static boolean rutValido(String rut) {
        return rut.matches("[0-9]{7,8}-[0-9Kk]");
    }


    
}
