package model;

/**
 * Representa la direccion fisica de una persona relacionada con LlanquihueTour.
 *
 * Esta clase se utiliza como parte de la composición dentro de la clase
 * Persona.
 */
public class Direccion {

    private String rutAsociado;
    private String calle;
    private int numero;
    private String comuna;

    public Direccion() {
    }

    /**
     * Constructor de la clase Direccion
     *
     * @param rutAsociado RUT de la persona asociada a kla direccion particular.
     * @param calle nombre de la calle
     * @param numero numero de la calle
     * @param comuna comuna de la direccion asociada
     */
    public Direccion(String rutAsociado, String calle, int numero, String comuna) {
        this.rutAsociado = rutAsociado;
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;

    }

    /**
     * Muestra la informacion completa de la direccion
     *
     * @return muestra la informacion formateada como texto
     */
    @Override
    public String toString() {
        return "Direccion   : " + calle + " #" + numero + ", " + comuna;
    }

    public String getRutAsociado() {
        return rutAsociado;
    }

    public void setRutAsociado(String rutAsociado) {
        this.rutAsociado = rutAsociado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

}
