package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {
    private String nombre;
    private byte edad;
    private float peso;

    public FelinoDomestico(String nombre, byte edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Objeto - FelinoDomestico [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
    }
}