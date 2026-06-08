
package model;

/**
 * Representa la direccion fisica de una persona relacionada con LlanquihueTour.
 * 
 * Esta clase se utiliza como parte de la composición dentro de la clase Persona.
 */
public class Direccion {
    private String calle;
    private int numero;
    private String comuna;
    private String ciudad;
    private String region;

public Direccion() {
}    
    
/**
 * Constructor de la clase Direccion
 * 
 * @param calle nombre de la calle
 * @param numero numero de la calle
 * @param comuna comuna de la direccion asociada
 * @param ciudad ciudad donde se ubica la direccion
 * @param region region de Chile donde se ubica la direccion
 */  
    
public Direccion(String calle, int numero, String comuna, String ciudad, String region) {
    this.calle = calle;
    this.numero = numero;
    this.comuna = comuna;
    this.ciudad = ciudad;
    this.region = region;
    }
/**
 * Muestra la informacion completa de la direccion
 * 
 * @return muestra la informacion formateada como texto
 */

    @Override
    public String toString() {
        return "Direccion: " + calle + " #" + numero + ", " +
                comuna + ", " + ciudad + ", Region " + region;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    




}


