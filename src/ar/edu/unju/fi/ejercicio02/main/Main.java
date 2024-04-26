package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("Menú de acciones:");
			System.out.println("1 - Crear efeméride");
			System.out.println("2 - Mostrar efemérides");
			System.out.println("3 - Eliminar efeméride");
			System.out.println("4 - Modificar efeméride");
			System.out.println("5 - Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				crearEfemeride(efemerides, scanner);
				break;
			case 2:
				mostrarEfemerides(efemerides);
				break;
			case 3:
				eliminarEfemeride(efemerides, scanner);
				break;
			case 4:
				modificarEfemeride(efemerides, scanner);
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida. Inténtelo de nuevo.");
			}
		} while (opcion != 5);
	}

	private static void crearEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		System.out.print("Ingrese el código: ");
		int codigo = scanner.nextInt();

		System.out.print("Ingrese el mes (número del 1 al 12): ");
		int numMes = scanner.nextInt();
		while (numMes < 1 || numMes > 12) {
			System.out.println("Mes inválido. Inténtelo de nuevo.");
			System.out.print("Ingrese el mes (número del 1 al 12): ");
			numMes = scanner.nextInt();
		}
		Mes mes = Mes.values()[numMes - 1];

		System.out.print("Ingrese el día: ");
		int dia = scanner.nextInt();

		System.out.print("Ingrese el detalle: ");
		scanner.nextLine(); // Limpiar el buffer del scanner
		String detalle = scanner.nextLine();

		Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
		efemerides.add(efemeride);
		System.out.println("Efeméride creada exitosamente.");
	}

	private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemérides para mostrar.");
		} else {
			System.out.println("Efemérides:");
			for (Efemeride efemeride : efemerides) {
				System.out.println(efemeride.getCodigo() + " - " + efemeride.getMes() + " " + efemeride.getDia() + ": "
						+ efemeride.getDetalle());
			}
		}
	}

	private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemérides para eliminar.");
			return;
		}

		System.out.print("Ingrese el código de la efeméride que desea eliminar: ");
		int codigoEliminar = scanner.nextInt();

		boolean encontrado = false;
		for (Efemeride efemeride : efemerides) {
			if (efemeride.getCodigo() == codigoEliminar) {
				efemerides.remove(efemeride);
				encontrado = true;
				System.out.println("Efeméride eliminada exitosamente.");
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ninguna efeméride con el código proporcionado.");
		}
	}

	private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemérides para modificar.");
			return;
		}

		System.out.print("Ingrese el código de la efeméride que desea modificar: ");
		int codigoModificar = scanner.nextInt();

		boolean encontrado = false;
		for (Efemeride efemeride : efemerides) {
			if (efemeride.getCodigo() == codigoModificar) {
				System.out.println("Ingrese los nuevos datos para la efeméride:");

				System.out.print("Nuevo mes (número del 1 al 12): ");
				int numMes = scanner.nextInt();
				while (numMes < 1 || numMes > 12) {
					System.out.println("Mes inválido. Inténtelo de nuevo.");
					System.out.print("Nuevo mes (número del 1 al 12): ");
					numMes = scanner.nextInt();
				}
				Mes nuevoMes = Mes.values()[numMes - 1];
				efemeride.setMes(nuevoMes);

				System.out.print("Nuevo día: ");
				int nuevoDia = scanner.nextInt();
				efemeride.setDia(nuevoDia);

				System.out.print("Nuevo detalle: ");
				scanner.nextLine(); // Limpiar el buffer del scanner
				String nuevoDetalle = scanner.nextLine();
				efemeride.setDetalle(nuevoDetalle);

				encontrado = true;
				System.out.println("Efeméride modificada exitosamente.");
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ninguna efeméride con el código proporcionado.");
		}
	}
}
