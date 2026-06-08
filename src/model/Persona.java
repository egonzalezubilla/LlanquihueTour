
package model;

/**
 *Representa a una persona que esta relacionada con LlanquihueTour
 *
 * 
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    private int telefono;
    private Direccion direccion;

public Persona () {    
}    
    
/**
 * Constructor de la clase Persona
 * 
 * @param nombre nombre la persona
 * @param apellido apellido de la persona
 * @param rut Rut de la persona
 * @param telefono telefono asociado a la persona
 * @param direccion direccion asociada a la persona
 */    
    
    public Persona(String nombre, String apellido, String rut, int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
    }

/**
 * Muestra la informacion completa de la persona
 * 
 * @return muestra la informacion formateada como texto
 */    
    
    @Override
    public String toString() {
        return "---- INFORMACION DE LA PERSONA ----\n\n" +
               "Nombre      : " + nombre + " " + apellido + "\n" +
               "RUT         : " + rut + "\n" +
               "Telefono    : " + telefono + "\n" +
               "Direccion   : " + direccion.toString();
    }               
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    
}
