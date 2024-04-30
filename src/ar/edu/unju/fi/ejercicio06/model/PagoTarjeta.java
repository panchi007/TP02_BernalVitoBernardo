package ar.edu.unju.fi.ejercicio06.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio.interfaces.Pago;

public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;

    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
    }

    @Override
    public void realizarPago(double monto) {
        // Se agrega un 15% de recarga al monto pagado con tarjeta
        double recargo = monto * 0.15;
        this.montoPagado = monto + recargo;
        // Redondear el monto a dos decimales
        this.montoPagado = Math.round(this.montoPagado * 100.0) / 100.0;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pago con tarjeta:");
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}