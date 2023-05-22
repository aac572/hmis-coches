package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CocheTest {

    private static Coche[] coches() {
        String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
        return coches;
    }

    @ParameterizedTest
    @MethodSource("coches")
    void testEquals(Coche coche) {
        Coche coche2= new Coche();
        coche2.setAño(coche.getAño()+1);
        assertEquals(coche, coche, "Los coches deberían ser iguales");
        assertNotEquals(coche, coche2, "Los coches no deberían ser iguales");
    }

    @ParameterizedTest
    @MethodSource("coches")
    void testToString(Coche coche) {
        String expected = "Coche [marca=" + coche.getMarca() + ", modelo=" + coche.getModelo() + ", año=" + coche.getAño() + ", precio=" + coche.getPrecio() + "]";
        assertEquals(expected, coche.toString());

    }
    
    // test getters
    @ParameterizedTest
    @CsvSource({"Seat, Ibiza, 2010, 4000"})
    void testGetters(String marca, String modelo, String year, String precio) {
        Coche coche = new Coche();
        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setAño(Integer.valueOf(year));
        coche.setPrecio(Integer.valueOf(precio));
        assertEquals(marca, coche.getMarca());
        assertEquals(modelo, coche.getModelo());
        assertEquals(year, String.valueOf(coche.getAño()));
        assertEquals(precio, String.valueOf(coche.getPrecio()));
    }


}
