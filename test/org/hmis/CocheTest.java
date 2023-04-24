package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CocheTest {

   
    @Test
    void testEquals() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
        assertEquals(primero, segundo, "Los dos coches no son iguales");
    }

    @Test
    void testToString() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        assertEquals("Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]", primero.toString());

    }

    // Test del metodo equals de la clase Coche
    @Test
    void testEquals2() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        Coche segundo = null;
        assertNotEquals(primero, segundo, "Los dos coches no son iguales");
    }
    
    // Test del metodo equals de la clase Coche
    @Test
    void testEquals3() {
        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
        assertEquals(primero, primero, "Los dos coches no son iguales");
    }

        // Test del método equals de la clase Coche
        @Test
        void testEquals4() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            String segundo = "";
            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
        }

        @Test
        void testEquals_att1() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);

            segundo.setAño(2003);
            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
        }

        @Test
        void testEquals_att2() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);

            segundo.setMarca("Seat");
            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
        }

        @Test
        void testEquals_att3() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
            segundo.setModelo("Twingo");
            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
        }

        @Test
        void testEquals_att4() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
            segundo.setPrecio(16000);
            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
        }

        // test getters
        @Test
        void testGetters() {
            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
            assertEquals("Renault", primero.getMarca());
            assertEquals("Clio", primero.getModelo());
            assertEquals(2001, primero.getAño());
            assertEquals(12000, primero.getPrecio());
        }


}
