package ui;

import data.GestorDatos;
import java.util.ArrayList;
import java.util.Scanner;
import model.Direccion;
import model.Persona;

/**
 * Clase principal del sistema LlanquihueTour. Gestiona el flujo de ejecución de
 * la aplicación. Se encarga de cargar los datos desde los archivos externos,
 * inicializar las listas de personas y direcciones, y desplegar el menú
 * interactivo para el usuario.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("---- LLANQUIHUETOUR ----\n\n");
        System.out.println("BIENVENIDO AL SISTEMA DE GESTION DE PERSONAS\n");
        System.out.println("Cargando la informacion desde los archivos...\n");

        ArrayList<Direccion> listaDirecciones = GestorDatos.leerDireccion();

        ArrayList<Persona> listaPersonas = GestorDatos.leerPersona(listaDirecciones);

        if (listaPersonas.isEmpty()) {
            System.out.println("Aviso: No se cargaron personas en el sistema. Verifique el archivo personas.txt en src/resources.");
        } else {
            System.out.println("Datos cargados correctamente: " + listaPersonas.size() + " personas registradas.");

        }

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Mostrar registro completo");
            System.out.println("2. Mostrar personas segun tipo");
            System.out.println("3. Salir");
            System.out.print("\nINGRESE UNA OPCION: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\n--- REGISTRO COMPLETO ---\n");
                    for (Persona p : listaPersonas) {
                        System.out.println(p);
                    }
                    break;

                case "2":
                    System.out.println("\n¿Que tipo desea filtrar? (Empleado / Colaborador)");
                    String filtroTipo = sc.nextLine().trim();

                    System.out.println("\n--- FILTRO: " + filtroTipo.toUpperCase() + " ---\n");
                    boolean encontrado = false;
                    for (Persona p : listaPersonas) {
                        if (p.getTipo().equalsIgnoreCase(filtroTipo)) {
                            System.out.println(p);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\nNo se encontraron personas de tipo: " + filtroTipo);
                    }
                    break;

                case "3":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("\nOPCION NO VALIDA. INTENTE NUEVAMENTE.");
            }
        }
        sc.close();

    }

}
