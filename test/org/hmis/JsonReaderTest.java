package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import javax.management.RuntimeErrorException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JsonReaderTest {

	@ParameterizedTest
	@CsvSource({"data/coches.json"})
	void testLeerCochesJSON(String ruta) {
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@ParameterizedTest
	@CsvSource({"data/coches.json"})
	void testLeerCochesJSONprimero(String ruta) {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue (primero.equals(coches[0]));
		assertTrue (coches[0].equals(primero));
	}

	@ParameterizedTest
	@CsvSource({"data/coches.json"})
	void testLeerCochesException(String ruta) {
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> coches[4].equals(null));
	}

	@ParameterizedTest
	@CsvSource({"data/cochesNoExistente.json"})
	void testLeerArchivoNoExistente(String ruta) {
		JsonReader jsonReader = new JsonReader();
		assertEquals(JsonReader.class, jsonReader.getClass(), "jsonReader es del tipo JsonReader");
		try {
			JsonReader.leerCochesJSON(ruta);
		} catch (Exception e){
			throw new RuntimeException("No debería de lanzar excepcion");
		}
	}
}
