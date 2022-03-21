/**
 * 
 */
package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Checker;

/**
 * Test de la clase Checker que verifica las métricas e indicadores
 * 
 * @author Isabel Román
 *
 */
class CheckerTest {
	private static Logger log = Logger.getLogger(CheckerTest.class.getName());
	static Checker underTest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		underTest = new Checker();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.control.Checker#definedMetric(java.lang.String)}.
	 */
	@Test
	void testDefinedMetric() {
		Integer valueOK = Integer.valueOf(3);
		String valueKO = "KO";
		log.info("Busco la métrica kkk");
		try {
			assertNull(underTest.definedMetric("kkk", valueOK.getClass().getName()),
					"Debería ser nulo, la métrica no está definida");

			log.info("Busco la métrica watchers");
			assertNotNull(underTest.definedMetric("watchers", valueOK.getClass().getName()),
					"Debería devolver un hashmap, la métrica está definida");
			assertNull(underTest.definedMetric("watchers", valueKO.getClass().getName()),
					"Debería ser nulo, la métrica está definida para Integer");
		} catch (FileNotFoundException e) {
			fail("El fichero está en la carpeta resources");
			e.printStackTrace();
		}
		underTest.setAppMetrics("pepe");
		try {
			underTest.definedMetric("kkk", valueOK.getClass().getName());
			fail("Debería lanzar una excepción porque intenta buscar en un fichero que no existe");
		} catch (FileNotFoundException e) {
			log.info("Lanza la excepción adecuada, FileNotFoud");
		} catch (Exception e) {
			fail("Lanza la excepción equivocada " + e);
		}

	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.control.Checker#definedIndicator(java.lang.String)}.
	 */
	@Test
	void testDefinedIndicator() {
		Integer valueOK = Integer.valueOf(3);
		String valueKO = "KO";

		try {

			log.info("Busco el indicador kkk");
			assertNull(underTest.definedIndicator("kkk", valueOK.getClass().getName()),
					"Debería ser nulo, el indicador no está definido");
			log.info("Busco el indicador watchers");
			assertNotNull(underTest.definedIndicator("watchers", valueOK.getClass().getName()),
					"Debería no ser nulo, el indicador está definido para valor de tipo Integer");
			assertNull(underTest.definedIndicator("watchers", valueKO.getClass().getName()),
					"Debería ser nulo, el indicador está definido para valor de tipo Integer");
		} catch (FileNotFoundException e) {
			fail("El fichero está en la carpeta resources y no se ha definido uno para la aplicación");
			e.printStackTrace();
		}
		underTest.setAppMetrics("pepe");
		try {
			underTest.definedIndicator("kkk", valueOK.getClass().getName());
			fail("Debería lanzar una excepción porque intenta buscar en un fichero que no existe");
		} catch (FileNotFoundException e) {
			log.info("Lanza la excepción adecuada, FileNotFoud");
		} catch (Exception e) {
			fail("Lanza la excepción equivocada " + e);
		}
		//Tendría que probar un fichero de configuración de la aplicación cliente que sí fuera válido y asegurar que efectivamente se lee

	}
}
