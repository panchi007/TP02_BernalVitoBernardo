package ar.edu.unju.fi.ejercicio06.model;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private boolean disponible;

    // Constructor
    public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
            Categoria categoria, boolean disponible) {
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.setPrecioUnitario(precioUnitario);
        this.setOrigenFabricacion(origenFabricacion);
        this.setCategoria(categoria);
        this.setDisponible(disponible); // Utiliza el parámetro para establecer el estado de disponibilidad
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Enumeración para Origen de Fabricación
    public enum OrigenFabricacion {
        ARGENTINA, CHINA, BRASIL, URUGUAY
    }

    // Enumeración para Categoría
    public enum Categoria {
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion + ", Precio Unitario: $" + precioUnitario
                + ", Origen de Fabricación: " + origenFabricacion + ", Categoría: " + categoria;
    }
}
