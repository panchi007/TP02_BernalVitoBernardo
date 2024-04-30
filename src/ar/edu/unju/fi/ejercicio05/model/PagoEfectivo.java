package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio05.interfaces.*;

public class PagoEfectivo implements Pago {
    private double montoPagado;
    private LocalDate fechaPago;

    public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        // Se aplica un 10% de descuento al monto pagado en efectivo
        this.montoPagado -= monto * 0.10;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pago en efectivo:");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}
