
package model;

/**
 * Representa a un colaborador externo de la empresa LlanquihueTour
 * 
 * Hereda atributos de la clase Persona
 */

public class Colaborador extends Persona {
    private String empresa;

public Colaborador () {    
}    
    
/**
 * Constructor de la clase Colaborador
 * 
 * @param nombre nombre del colaborador externo.
 * @param apellido apellido del colaborador externo.
 * @param rut Rut del colaborador externo.
 * @param telefono telefono asociado al colaborador externo.
 * @param direccion direccion de la empresa del colaborador externo.
 * @param empresa nombre de la empresa del colaborador externo.
 */    
    
    public Colaborador(String nombre, String apellido, String rut, int telefono, Direccion direccion, String empresa) {
        super(nombre, apellido, rut, telefono, direccion);
        this.empresa = empresa;
    }

/**
 * Muestra la informacion completa del colaborador.
 * 
 * @return muestra la informacion heredada de la clase Persona ademas del atributo
 * empresa, caracteristico de la Clase Empleado, formateado como texto.
 */
    
    @Override
    public String toString() {
        super.toString();
        return super.toString() +
                "\nEmpresa     : " + empresa;
    }

    
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
}
