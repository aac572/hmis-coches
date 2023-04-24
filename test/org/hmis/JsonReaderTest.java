package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import javax.management.RuntimeErrorException;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	@Test
	void testLeerCochesJSON() {
		String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@Test
	void testLeerCochesJSONprimero() {
		String ruta = "data/coches.json";
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue (primero.equals(coches[0]));
		assertTrue (coches[0].equals(primero));
	}

	@Test
	void testLeerCochesException() {
		String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> coches[4].equals(null));
	}

	@Test
	void testLeerArchivoNoExistente() {
		JsonReader jsonReader = new JsonReader();
		assertEquals(JsonReader.class, jsonReader.getClass(), "jsoneader es del tipo JsonReader");
		String ruta = "data/esteArchivoNoExiste.exception";
		try {
			JsonReader.leerCochesJSON(ruta);
		} catch (Exception e){
			throw new RuntimeException("No debería de lanzar excepcion");
		}
	}
}
