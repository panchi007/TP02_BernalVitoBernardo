package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {
	public static void main(String[] args) {
		ArrayList<Producto> listaProductos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("Menú de opciones:");
			System.out.println("1 – Crear Producto");
			System.out.println("2 – Mostrar productos");
			System.out.println("3 – Modificar producto");
			System.out.println("4 – Salir");
			System.out.print("Elija una opción: ");

			try {
				opcion = scanner.nextInt();
				scanner.nextLine(); // Consumir la nueva línea después de leer el entero

				switch (opcion) {
				case 1:
					crearProducto(listaProductos, scanner);
					break;
				case 2:
					mostrarProductos(listaProductos);
					break;
				case 3:
					modificarProducto(listaProductos, scanner);
					break;
				case 4:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número.");
				scanner.nextLine(); // Limpiar el buffer del scanner
				opcion = 0; // Asignar un valor válido para continuar en el bucle
			}
		} while (opcion != 4);
	}

	private static void crearProducto(ArrayList<Producto> listaProductos, Scanner scanner) {
		System.out.println("Creando nuevo producto...");

		System.out.print("Ingrese el código del producto: ");
		String codigo = scanner.nextLine();

		System.out.print("Ingrese la descripción del producto: ");
		String descripcion = scanner.nextLine();

		System.out.print("Ingrese el precio unitario del producto: ");
		double precioUnitario = scanner.nextDouble();
		scanner.nextLine(); // Consumir la nueva línea después de leer el double

		// Mostrar opciones de Origen de Fabricación
		System.out.println("------ Origen de fabricación ------");
		int i = 1;
		for (OrigenFabricacion origen : OrigenFabricacion.values()) {
			System.out.println(i + " - " + origen);
			i++;
		}
		System.out.print("Elija una opción: ");
		int opcionOrigen = scanner.nextInt();
		scanner.nextLine(); // Consumir la nueva línea después de leer el entero
		OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[opcionOrigen - 1];

		// Mostrar opciones de Categoría
		System.out.println("------ Categoría ------");
		i = 1;
		for (Categoria categoria : Categoria.values()) {
			System.out.println(i + " - " + categoria);
			i++;
		}
		System.out.print("Elija una opción: ");
		int opcionCategoria = scanner.nextInt();
		scanner.nextLine(); // Consumir la nueva línea después de leer el entero
		Categoria categoria = Categoria.values()[opcionCategoria - 1];

		// Crear y agregar el producto a la lista
		Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
		listaProductos.add(producto);

		System.out.println("Producto creado exitosamente.");
	}

	private static void mostrarProductos(ArrayList<Producto> listaProductos) {
		if (listaProductos.isEmpty()) {
			System.out.println("No hay productos para mostrar.");
		} else {
			System.out.println("Lista de productos:");
			for (Producto producto : listaProductos) {
				System.out.println(producto.toString()); // Utilizar toString() para imprimir el producto
			}
		}
	}

	private static void modificarProducto(ArrayList<Producto> listaProductos, Scanner scanner) {
		if (listaProductos.isEmpty()) {
			System.out.println("No hay productos para modificar.");
		} else {
			System.out.print("Ingrese el código del producto a modificar: ");
			String codigo = scanner.nextLine();

			// Buscar el producto por código
			Producto productoEncontrado = null;
			for (Producto producto : listaProductos) {
				if (producto.getCodigo().equals(codigo)) {
					productoEncontrado = producto;
					break;
				}
			}

			if (productoEncontrado == null) {
				System.out.println("No se encontró ningún producto con el código ingresado.");
			} else {
				System.out.println("Producto encontrado: " + productoEncontrado.toString());

				// Mostrar opciones de modificación
				System.out.println("Seleccione el atributo a modificar:");
				System.out.println("1 - Descripción");
				System.out.println("2 - Precio Unitario");
				System.out.println("3 - Origen de Fabricación");
				System.out.println("4 - Categoría");
				System.out.print("Elija una opción: ");
				int opcionModificacion = scanner.nextInt();
				scanner.nextLine(); // Consumir la nueva línea después de leer el entero

				switch (opcionModificacion) {
				case 1:
					System.out.print("Ingrese la nueva descripción: ");
					String nuevaDescripcion = scanner.nextLine();
					productoEncontrado.setDescripcion(nuevaDescripcion);
					break;
				case 2:
					System.out.print("Ingrese el nuevo precio unitario: ");
					double nuevoPrecioUnitario = scanner.nextDouble();
					scanner.nextLine(); // Consumir la nueva línea después de leer el double
					productoEncontrado.setPrecioUnitario(nuevoPrecioUnitario);
					break;
				case 3:
					// Mostrar opciones de Origen de Fabricación
					System.out.println("------ Origen de fabricación ------");
					int i = 1;
					for (OrigenFabricacion origen : OrigenFabricacion.values()) {
						System.out.println(i + " - " + origen);
						i++;
					}
					System.out.print("Elija una opción: ");
					int opcionOrigen = scanner.nextInt();
					scanner.nextLine(); // Consumir la nueva línea después de leer el entero
					OrigenFabricacion nuevoOrigen = OrigenFabricacion.values()[opcionOrigen - 1];
					productoEncontrado.setOrigenFabricacion(nuevoOrigen);
					break;
				case 4:
					// Mostrar opciones de Categoría
					System.out.println("------ Categoría ------");
					i = 1;
					for (Categoria categoria : Categoria.values()) {
						System.out.println(i + " - " + categoria);
						i++;
					}
					System.out.print("Elija una opción: ");
					int opcionCategoria = scanner.nextInt();
					scanner.nextLine(); // Consumir la nueva línea después de leer el entero
					Categoria nuevaCategoria = Categoria.values()[opcionCategoria - 1];
					productoEncontrado.setCategoria(nuevaCategoria);
					break;
				default:
					System.out.println("Opción no válida.");
					break;
				}

				System.out.println("Producto modificado exitosamente.");
			}
		}
	}

}