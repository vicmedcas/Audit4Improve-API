/**
 * 
 */
package us.muit.fs.a4i.test.model.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.model.entities.Metric.MetricBuilder;
import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.Metric;

/**
 * <p>Test para probar el constructor de objetos Metric</p>
 * @author Isabel Román
 *
 */
class MetricBuilderTest {
	MetricBuilder underTest;

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test para el constructo
	 * Test method for {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#MetricBuilder(java.lang.String, java.lang.Object)}.
	 */
	@Test
	void testMetricBuilder() {
		try {
			underTest=new MetricBuilder<Integer>("watchers",33);
		} catch (MetricException e) {
			
			e.printStackTrace();
		}
		Metric newMetric=underTest.build();
		assertEquals("watchers",newMetric.getName(),"El nombre establecido no es correcto");
		assertEquals(33,newMetric.getValue(),"El valor establecido no es correcto");
		assertEquals(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).toString(),newMetric.getDate().toString(),"La fecha establecida no es correcta");
		assertNull(newMetric.getDescription(),"No debería contener ninguna descripción");
		assertNull(newMetric.getSource(),"No debería contener la fuente");
		assertNull(newMetric.getUnit(),"No debería incluir las unidades");
		
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#description(java.lang.String)}.
	 */
	@Test
	void testDescription() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#source(java.lang.String)}.
	 */
	@Test
	void testSource() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#unit(java.lang.String)}.
	 */
	@Test
	void testUnit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Metric.MetricBuilder#build()}.
	 */
	@Test
	void testBuild() {
		fail("Not yet implemented"); // TODO
	}

}
