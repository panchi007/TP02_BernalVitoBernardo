package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import ar.edu.unju.fi.ejercicio05.model.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = cargarProductos();

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                        ArrayList<Producto> productosComprados = seleccionarProductos(productos);
                        if (productosComprados.size() > 0) {
                            realizarPago(productosComprados);
                        }
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número.");
                scanner.nextLine();  // Limpiar el buffer del scanner
            }
        }

        scanner.close();
        System.out.println("¡Gracias por utilizar nuestro sistema de compras!");
    }

    private static ArrayList<Producto> cargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        
        // Agregar productos a la lista
        productos.add(new Producto("P001", "Teléfono inteligente", 500.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("P002", "Laptop", 1000.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("P003", "Aspiradora", 200.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P004", "Taladro", 50.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        
        return productos;
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles en este momento.");
        } else {
            System.out.println("Lista de productos disponibles:");
            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                System.out.println((i + 1) + ". " + producto.getDescripcion() + " - Precio: $" + producto.getPrecioUnitario() + " - Disponible: " + (producto.isDisponible() ? "Sí" : "No"));
            }
        }
    }

    private static ArrayList<Producto> seleccionarProductos(ArrayList<Producto> productos) {
        ArrayList<Producto> productosComprados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean seleccionando = true;
        while (seleccionando) {
            System.out.println("Seleccione los productos que desea comprar (ingrese el número de producto):");
            mostrarProductos(productos);
            System.out.print("Ingrese el número del producto (0 para finalizar la selección): ");

            int numeroProducto = scanner.nextInt();
            if (numeroProducto == 0) {
                seleccionando = false;
            } else if (numeroProducto > 0 && numeroProducto <= productos.size()) {
                Producto producto = productos.get(numeroProducto - 1);
                if (producto.isDisponible()) {
                    productosComprados.add(producto);
                    System.out.println("Producto '" + producto.getDescripcion() + "' agregado al carrito.");
                } else {
                    System.out.println("El producto seleccionado no está disponible.");
                }
            } else {
                System.out.println("Número de producto no válido. Por favor, ingrese un número válido.");
            }
        }

        return productosComprados;
    }

    private static void realizarPago(ArrayList<Producto> productosComprados) {
        double total = calcularTotal(productosComprados);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el método de pago:");
        System.out.println("1 – Pago en efectivo");
        System.out.println("2 – Pago con tarjeta");
        System.out.print("Ingrese el número del método de pago: ");
        int metodoPago = scanner.nextInt();

        Pago pago;
        switch (metodoPago) {
            case 1:
                System.out.print("Ingrese el monto a pagar en efectivo: ");
                double montoEfectivo = scanner.nextDouble();
                pago = new PagoEfectivo(montoEfectivo, LocalDate.now());
                break;
            case 2:
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                pago = new PagoTarjeta(numeroTarjeta, LocalDate.now(), total);
                break;
            default:
                System.out.println("Método de pago no válido. Seleccionando pago en efectivo por defecto.");
                System.out.print("Ingrese el monto a pagar en efectivo: ");
                double montoPorDefecto = scanner.nextDouble();
                pago = new PagoEfectivo(montoPorDefecto, LocalDate.now());
        }

        pago.realizarPago(total);
        pago.imprimirRecibo();
    }

    private static double calcularTotal(ArrayList<Producto> productosComprados) {
        double total = 0;
        for (Producto producto : productosComprados) {
            total += producto.getPrecioUnitario();
        }
        return total;
    }
}
