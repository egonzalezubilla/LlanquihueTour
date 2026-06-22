package model;

/**
 * Representa aun empleado de la empresa LlanquihueTour.
 *
 * Esta clase hereda de Persona.
 */
public class Empleado extends Persona {

    private String departamento;

    public Empleado() {
    }

    /**
     * Constructor de la clase Empleado de LlanquihueTour.
     *
     * @param rut Rut del empleado.
     * @param nombre nombre del empleado.
     * @param apellido apellido del empleado.
     * @param telefono telefono asociado al empleado.
     * @param direccion direccion del empleado.
     * @param departamento Area de la empresa donde trabaja el empleado.
     */
    public Empleado(String rut, String nombre, String apellido, int telefono, Direccion direccion, String departamento) {
        super(rut, nombre, apellido, telefono, direccion);
        this.departamento = departamento;
    }

    /**
     * Muestra la informacion del empleado.
     *
     * @return muestra la informacion heredada de la clase Persona jutnto al
     * atrubuto departamento, respectivo de la clase Empleado, formateado como
     * texto.
     */
    @Override
    public String toString() {
        super.toString();
        return super.toString()
                + "\nDepartamento: " + departamento;
    }

    @Override
    public String getTipo() {
        return "Empleado";
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
