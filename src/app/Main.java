
package app;

import model.Direccion;
import model.Empleado;
import model.Persona;
import model.Colaborador;

/**
 *Clase principal del sistema LlanquihueTour
 * 
 * En esta clase se crean objetos y se comprueban validaciones, herencias y
 * composiiciones.
 */

public class Main {

    public static void main(String[] args) {

    Direccion dir1 = new Direccion ("Saguita", 2303, "Colina", "Santiago", "Metropolitana");

    Empleado empleado1 = new Empleado ("Vanessa", "Baroch", "22222232-2", 998988787, dir1, "RRHH");
    
    Direccion dir2 = new Direccion ("Valle del sur", 887, "Curarrehue", "Pucon", "de la Araucania");
    
    Colaborador colab1 = new Colaborador ("Pio", "Maldacena", "8987987-1", 909998877, dir2, "Hotel Villarica");
    
    Direccion dir3 = new Direccion ("Aioria", 613, "Puerto Varas", "Puerto Montt", "de los Lagos");
    
    Empleado empleado2 = new Empleado ("Rodrigo", "Rodriguez", "11111111-1", 911221122, dir3, "Gerencia");
    
        System.out.println(empleado1);
        System.out.println();
        System.out.println(colab1);
        System.out.println();
        System.out.println(empleado2);

    }
    
    
}
