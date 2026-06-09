
package app;

import model.Direccion;
import model.Empleado;
import model.Persona;
import model.Colaborador;
import util.Validador;

/**
 *Clase principal del sistema LlanquihueTour
 * 
 * En esta clase se crean objetos y se comprueban validaciones, herencias y
 * composiiciones.
 */

public class Main {

    public static void main(String[] args) {

    Direccion dir1 = new Direccion ("Saguita", 2303, "Colina", "Santiago", "Metropolitana");
    
/**
 * Se valida que la direccion contenga información valida mediante la clase
 * Validador.
 */

        if (Validador.textoValido(dir1.getCalle()) &&
            Validador.numeroDirValido(dir1.getNumero()) &&
            Validador.textoValido(dir1.getComuna()) &&
            Validador.textoValido(dir1.getCiudad()) &&
            Validador.textoValido(dir1.getRegion())) {
            System.out.println("Datos de la direccion validos.");
        }
        else {
            System.out.println("Los datos de la direccion son incorrectos.");
        }
    
    
    Empleado empleado1 = new Empleado ("Vanessa", "Baroch", "22222232-2", 998988787, dir1, "RRHH");

/**
 * Se valida que el empleado tenga informacion correcta mediante la clase
 * Validador.
 */
    
        if (Validador.textoValido(empleado1.getNombre()) &&
            Validador.textoValido(empleado1.getApellido()) &&
            Validador.rutValido(empleado1.getRut()) &&
            Validador.telefonoValido(empleado1.getTelefono()) &&
            Validador.textoValido(empleado1.getDepartamento())) {
            System.out.println("Datos del empleado validos.");
        }
        else {
            System.out.println("Los datos del empleado son incorrectos.");
        }

    Direccion dir2 = new Direccion ("Valle del sur", 887, "Curarrehue", "Pucon", "de la Araucania");
    
/**
 * Se valida que la direccion contenga información valida mediante la clase
 * Validador.
 */

        if (Validador.textoValido(dir2.getCalle()) &&
            Validador.numeroDirValido(dir2.getNumero()) &&
            Validador.textoValido(dir2.getComuna()) &&
            Validador.textoValido(dir2.getCiudad()) &&
            Validador.textoValido(dir2.getRegion())) {
            System.out.println("Datos de la direccion validos.");
        }
        else {
            System.out.println("Los datos de la direccion son incorrectos.");
        }    
    
    Colaborador colab1 = new Colaborador ("Pio", "Maldacena", "8987987-1", 909998877, dir2, "Hotel Villarica");
 
/**
 * Se valida que el colaborador tenga informacion correcta mediante la clase
 * Validador.
 */
    
        if (Validador.textoValido(colab1.getNombre()) &&
            Validador.textoValido(colab1.getApellido()) &&
            Validador.rutValido(colab1.getRut()) &&
            Validador.telefonoValido(colab1.getTelefono()) &&
            Validador.textoValido(colab1.getEmpresa())) {
            System.out.println("Datos del colaborador validos.");
        }
        else {
            System.out.println("Los datos del colaborador son incorrectos.");
        }    
    
    Direccion dir3 = new Direccion ("Aioria", 613, "Puerto Varas", "Puerto Montt", "de los Lagos");
   
/**
 * Se valida que la direccion contenga información valida mediante la clase
 * Validador
 */

        if (Validador.textoValido(dir3.getCalle()) &&
            Validador.numeroDirValido(dir3.getNumero()) &&
            Validador.textoValido(dir3.getComuna()) &&
            Validador.textoValido(dir3.getCiudad()) &&
            Validador.textoValido(dir3.getRegion())) {
            System.out.println("Datos de la direccion validos.");
        }
        else {
            System.out.println("Los datos de la direccion son incorrectos.");
        }    
    
    Empleado empleado2 = new Empleado ("Rodrigo", "Rodriguez", "11111111-1", 911221122, dir3, "Gerencia");
    
/**
 * Se valida que el empleado tenga informacion correcta mediante la clase
 * Validador.
 */
    
        if (Validador.textoValido(empleado2.getNombre()) &&
            Validador.textoValido(empleado2.getApellido()) &&
            Validador.rutValido(empleado2.getRut()) &&
            Validador.telefonoValido(empleado2.getTelefono()) &&
            Validador.textoValido(empleado2.getDepartamento())) {
            System.out.println("Datos del empleado validos.");
        }
        else {
            System.out.println("Los datos del empleado son incorrectos.");
        }    
    
        System.out.println(empleado1);
        System.out.println();
        System.out.println(colab1);
        System.out.println();
        System.out.println(empleado2);

    }
    
    
}
