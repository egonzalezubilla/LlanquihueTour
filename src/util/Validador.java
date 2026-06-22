package util;

/**
 * Clase auxiliar que contiene metodos de validacion en LlanquihueTour
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
     * Valida si un numero de direccion es un numero positivo.
     *
     * @param numero numero de direccion a verificar
     * @return true si el numero es positivo.
     */
    public static boolean numeroDirValido(String numero) {
        try {
            int nuevoNumero = Integer.parseInt(numero.trim());

            return nuevoNumero > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Valida si un telefono tiene 9 digitos (standard en Chile)
     *
     * @param telefono numero de telefono a verificar
     * @return true si el numero contiene 9 digitos
     */
    public static boolean telefonoValido(String telefono) {
        try {
            int numeroTelefono = Integer.parseInt(telefono.trim());

            return numeroTelefono >= 100000000 && numeroTelefono <= 999999999;
        } catch (NumberFormatException e) {
            return false;
        }
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
