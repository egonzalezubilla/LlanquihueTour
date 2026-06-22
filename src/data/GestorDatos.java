package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.Colaborador;
import model.Direccion;
import model.Empleado;
import model.Persona;

/**
 * Clase auxiliar que permite la correcta lectura de archivos externos .txt
 *
 */
public class GestorDatos {

    /**
     * Metodo para leer el archivo direcciones.txt usando la clase nativa
     * InputStream e InputStreamReader
     *
     * @return devuelve la lista de direcciones completa.
     */
    public static ArrayList<Direccion> leerDireccion() {
        ArrayList<Direccion> listaDireccion = new ArrayList<>();

        InputStream entrada = GestorDatos.class.getClassLoader().getResourceAsStream("resources/direcciones.txt");

        if (entrada == null) {
            System.err.println("ERROR: No se encontró el archivo en 'src/resources/direcciones.txt'.");
            return listaDireccion;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(entrada, "UTF-8"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(";");

                if (partes.length < 4) {
                    System.err.println("Línea " + numeroLinea + " ignorada: Formato incompleto.");
                    continue;
                }

                if (!lineaDireccionValida(partes)) {
                    System.err.println("Línea " + numeroLinea + " ignorada: Datos inválidos.");
                    continue;
                }

                try {
                    String rutAsociado = partes[0].trim();
                    String calle = partes[1].trim();
                    int numero = Integer.parseInt(partes[2].trim());
                    String comuna = partes[3].trim();

                    Direccion dir = new Direccion(rutAsociado, calle, numero, comuna);

                    listaDireccion.add(dir);

                } catch (NumberFormatException e) {
                    System.err.println("Error de formato numérico en la línea " + numeroLinea + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }

        return listaDireccion;

    }

    /**
     * Lee el archivo "personas.txt", busca su dirección por RUT y crea
     * dinámicamente el objeto correspondiente (Empleado o Colaborador).
     *
     * @param listaDireccion Lista de direcciones cargadas previamente.
     * @return devuelve la lista de Personas (Empleados y Colaboradores)
     * completamente unificada.
     */
    public static ArrayList<Persona> leerPersona(ArrayList<Direccion> listaDireccion) {
        ArrayList<Persona> listaPersona = new ArrayList<>();

        InputStream entrada = GestorDatos.class.getClassLoader().getResourceAsStream("resources/personas.txt");

        if (entrada == null) {
            System.err.println("ERROR: No se encontró el archivo en 'src/resources/personas.txt'.");
            return listaPersona;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(entrada, "UTF-8"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(";");

                if (partes.length < 6) {
                    System.err.println("Línea " + numeroLinea + " en personas.txt ignorada: Formato incompleto.");
                    continue;
                }

                if (!lineaValida(partes)) {
                    System.err.println("Línea " + numeroLinea + " en personas.txt ignorada: Datos inválidos.");
                    continue;
                }

                String rut = partes[0].trim();

                Direccion dirAsociada = buscarDireccionPorRut(rut, listaDireccion);

                if (dirAsociada == null) {
                    dirAsociada = new Direccion(rut, "Sin Dirección Registrada", 0, "Sin Comuna");
                }

                Persona nuevaPersona = crearPersonaSegunTipo(partes, dirAsociada);

                if (nuevaPersona != null) {
                    listaPersona.add(nuevaPersona);
                } else {
                    System.err.println("Línea " + numeroLinea + " ignorada: Tipo de persona desconocido (" + partes[4] + ").");
                }
            }

        } catch (IOException e) {
            System.err.println("Error de lectura en personas.txt: " + e.getMessage());
        }

        return listaPersona;
    }

    /**
     * Metodo que se encarga de construir la subclase de persona segun el tipo
     * (Empleado, Colaborador).
     */
    private static Persona crearPersonaSegunTipo(String[] campos, Direccion direccion) {
        String rut = campos[0].trim();
        String nombre = campos[1].trim();
        String apellido = campos[2].trim();
        int telefono = Integer.parseInt(campos[3].trim());
        String tipo = campos[4].trim();
        String datoEspecifico = campos[5].trim();

        if (tipo.equalsIgnoreCase("EMPLEADO")) {
            return new Empleado(rut, nombre, apellido, telefono, direccion, datoEspecifico);
        } else if (tipo.equalsIgnoreCase("COLABORADOR")) {
            return new Colaborador(rut, nombre, apellido, telefono, direccion, datoEspecifico);
        }
        return null;
    }

    /**
     * Metodo que busca en el ArrayList la dirección que coincida con el RUT de
     * la persona para asociarla.
     */
    private static Direccion buscarDireccionPorRut(String rutPersona, List<Direccion> listaDirecciones) {
        for (Direccion dir : listaDirecciones) {
            if (dir.getRutAsociado().equalsIgnoreCase(rutPersona)) {
                return dir;
            }
        }
        return null;
    }

    /**
     * Metodo que valida una linea de texto antes de crear el objeto Persona.
     * Utiliza metodos de la clase Validador: rutValido, textoValido y
     * telefonoValido.
     *
     * @param partes son las distintas partes de la linea de texto, rut, nombre
     * y apellido, telefono, su tipo de persona y atributo particular.
     * @return true si toda la informacion es valida.
     */
    private static boolean lineaValida(String[] partes) {

        if (!util.Validador.rutValido(partes[0].trim())) {
            return false;
        }

        if (!util.Validador.textoValido(partes[1].trim()) || !util.Validador.textoValido(partes[2].trim())) {
            return false;
        }

        if (!util.Validador.telefonoValido(partes[3].trim())) {
            return false;
        }

        String tipo = partes[4].trim();
        if (!tipo.equalsIgnoreCase("Empleado") && !tipo.equalsIgnoreCase("Colaborador")) {
            return false;
        }

        if (!util.Validador.textoValido(partes[5].trim())) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que valida los campos de una linea de texto antes de crear el
     * objeto Direccion. Utiliza metodos de la clase Validador, rutValido,
     * textoValido y numeroDirValido.
     *
     * @param partes son las distintas partes de la direccion: calle, numero y
     * comuna.
     * @return true si todo es valido.
     */
    private static boolean lineaDireccionValida(String[] partes) {

        if (!util.Validador.rutValido(partes[0].trim())) {
            return false;
        }

        if (!util.Validador.textoValido(partes[1].trim()) || !util.Validador.textoValido(partes[3].trim())) {
            return false;
        }

        if (!util.Validador.numeroDirValido(partes[2].trim())) {
            return false;
        }

        return true;
    }

}
