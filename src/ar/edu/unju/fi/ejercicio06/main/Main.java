package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.model.*;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.*;

public class Main {
    public static void main(String[] args) {
        FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte) 45, 12f);

        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
        FelinoSalvaje felino1 = converter.convert(garfield);
        converter.mostrarObjeto(felino1);

        FelinoSalvaje tanner = new FelinoSalvaje("Tanner", (byte) 20, 186f);
        if (Converter.isNotNull(tanner)) {
            Converter<FelinoSalvaje, FelinoDomestico> reverseConverter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
            FelinoDomestico felino2 = reverseConverter.convert(tanner);
            reverseConverter.mostrarObjeto(felino2);
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
    }
}