/**
 * 
 */
package us.muit.fs.a4i.test.control;
import java.util.logging.Logger;


import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mockitoSession;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;


import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.entities.Report;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;


/**
 * <p>Test para probar la clase Report</p>
 * @author Isabel Román
 *
 */
@ExtendWith(MockitoExtension.class)
class ReportTest {
	private Report reportTested;
	/**
	 * <p>Objetos tipo Mock, sustitutos de las clases de las que depende Report</p>
	 * 
	 */
	@Mock(serializable = true)
	private static IndicatorsCalculator indCalcMock1= Mockito.mock(IndicatorsCalculator.class);
	
	@Mock(serializable = true)
	private static Metric metricMock1= Mockito.mock(Metric.class);
	@Mock(serializable = true)
	private static Metric metricMock2= Mockito.mock(Metric.class);

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
	 * Test del constructor simple
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#Report()}.
	 */
	@Test
	void testReport() {
		
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test del constructor pasándole el id
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#Report(java.lang.String)}.
	 */
	@Test
	void testReportString() {
		reportTested=new Report("id");
		
		assertEquals("id",reportTested.getId(),"No se establece correctamente el identificador del informe");
		
		
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#getMetricByName(java.lang.String)}.
	 */
	@Test
	void testGetMetricByName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#addMetric(us.muit.fs.a4i.model.entities.Metric)}.
	 */
	@Test
	void testAddMetric() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#getIndicatorByName(java.lang.String)}.
	 */
	@Test
	void testGetIndicatorByName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#addIndicator(us.muit.fs.a4i.model.entities.Indicator)}.
	 */
	@Test
	void testAddIndicator() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#calcIndicator(java.lang.String)}.
	 */
	@Test
	void testCalcIndicator() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#setId(java.lang.String)}.
	 */
	@Test
	void testSetId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#getId()}.
	 */
	@Test
	void testGetId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#setIndicatorsCalculator(us.muit.fs.a4i.control.IndicatorsCalculator)}.
	 */
	@Test
	void testSetIndicatorsCalculator() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link us.muit.fs.a4i.model.entities.Report#getAllMetrics()}.
	 */
	@Test
	void testGetAllMetrics() {
		fail("Not yet implemented"); // TODO
	}

}
