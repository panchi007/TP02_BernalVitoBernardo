package ar.edu.unju.fi.ejercicio07.main;


import ar.edu.unju.fi.ejercicio07.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Precarga de 15 productos
        List<Producto> productos = precargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // Mostrar menú
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos disponibles");
            System.out.println("2 - Mostrar productos faltantes");
            System.out.println("3 - Incrementar precios en un 20%");
            System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio descendente");
            System.out.println("6 - Mostrar nombres de productos en mayúsculas");
            System.out.println("0 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos, p -> p.isEstado());
                    break;
                case 2:
                    mostrarProductos(productos, p -> !p.isEstado());
                    break;
                case 3:
                    productos = incrementarPrecios(productos);
                    System.out.println("Precios incrementados en un 20%");
                    break;
                case 4:
                    mostrarProductos(productos, p -> p.getCategoria().equals(Producto.Categoria.ELECTROHOGAR) && p.isEstado());
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente(productos);
                    mostrarProductos(productos, p -> true);
                    break;
                case 6:
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static List<Producto> precargarProductos() {
        List<Producto> productos = new ArrayList<>();
        // Ejemplo de precarga de productos
        productos.add(new Producto("001", "Televisor LED 32 pulgadas", 15000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("002", "Smartphone Samsung Galaxy S20", 60000, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("003", "Notebook HP Pavilion", 80000, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.INFORMATICA, true));
        // Agregar más productos según sea necesario
        return productos;
    }

    private static void mostrarProductos(List<Producto> productos, Predicate<Producto> filtro) {
        List<Producto> productosFiltrados = productos.stream()
                .filter(filtro)
                .collect(Collectors.toList());
        if (productosFiltrados.isEmpty()) {
            System.out.println("No se encontraron productos.");
        } else {
            productosFiltrados.forEach(System.out::println);
        }
    }

    private static List<Producto> incrementarPrecios(List<Producto> productos) {
        return productos.stream()
                .map(p -> {
                    p.setPrecioUnitario(p.getPrecioUnitario() * 1.2); // Incrementar precio en un 20%
                    return p;
                })
                .collect(Collectors.toList());
    }

    private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
        productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
    }

    private static void mostrarNombresEnMayusculas(List<Producto> productos) {
        productos.stream()
                .map(p -> p.getDescripcion().toUpperCase())
                .forEach(System.out::println);
    }
}
