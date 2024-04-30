package ar.edu.unju.fi.ejercicio07.model;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private boolean estado; // Nuevo atributo para indicar el estado del producto

    // Constructor
    public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
                    Categoria categoria, boolean estado) {
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.setPrecioUnitario(precioUnitario);
        this.setOrigenFabricacion(origenFabricacion);
        this.setCategoria(categoria);
        this.setEstado(estado); // Inicializar el estado del producto
    }

    // Métodos getter y setter para el atributo codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Métodos getter y setter para el atributo descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos getter y setter para el atributo precioUnitario
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Métodos getter y setter para el atributo origenFabricacion
    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    // Métodos getter y setter para el atributo categoria
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Métodos getter y setter para el atributo estado
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Enumeración para Origen de Fabricación
    public enum OrigenFabricacion {
        ARGENTINA, CHINA, BRASIL, URUGUAY
    }

    // Enumeración para Categoría
    public enum Categoria {
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion + ", Precio Unitario: $" + precioUnitario +
                ", Origen de Fabricación: " + origenFabricacion + ", Categoría: " + categoria;
    }
}
