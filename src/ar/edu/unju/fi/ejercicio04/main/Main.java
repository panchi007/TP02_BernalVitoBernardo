package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(jugadores, scanner);
                    break;
                case 4:
                    eliminarJugador(jugadores, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese nombre:");
        String nombre = scanner.next();
        System.out.println("Ingrese apellido:");
        String apellido = scanner.next();
        System.out.println("Ingrese fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimientoStr = scanner.next();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        System.out.println("Ingrese nacionalidad:");
        String nacionalidad = scanner.next();
        System.out.println("Ingrese estatura:");
        double estatura = scanner.nextDouble();
        System.out.println("Ingrese peso:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese posición (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
        String posicionStr = scanner.next();
        Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());

		Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado con éxito.");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        System.out.println("LISTA DE JUGADORES:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " - " +
                    jugador.getPosicion() + " - Edad: " + jugador.calcularEdad());
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        System.out.println("Ingrese nombre del jugador:");
        String nombre = scanner.next();
        System.out.println("Ingrese apellido del jugador:");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                System.out.println("Ingrese nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
                String nuevaPosicionStr = scanner.next();
                Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Posición modificada con éxito.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        System.out.println("Ingrese nombre del jugador:");
        String nombre = scanner.next();
        System.out.println("Ingrese apellido del jugador:");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado con éxito.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }
}