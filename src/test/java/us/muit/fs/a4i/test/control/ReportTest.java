/**
 * 
 */
package us.muit.fs.a4i.test.control;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;
import us.muit.fs.a4i.model.entities.Indicator;
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
	private static Logger log=Logger.getLogger(ReportTest.class.getName());
	/**
	 * <p>Objetos tipo Mock, sustitutos de las clases de las que depende Report</p>
	 * 
	 */
	@Mock
	private static IndicatorsCalculator indCalcMock= Mockito.mock(IndicatorsCalculator.class);
	
	
	
	//Servirán para conocer el argumento con el que se ha invocado algún método de alguno de los mocks (sustitutos o representantes)
    //ArgumentCaptor es un genérico, indico al declararlo el tipo del argumento que quiero capturar
	@Captor
	private ArgumentCaptor<Integer> intCaptor;
	@Captor
	private ArgumentCaptor<String> strCaptor;
	@Captor
	private ArgumentCaptor<Metric> metricCaptor;
	@Captor
	private ArgumentCaptor<Indicator> indicatorCaptor;
	@Captor
	private ArgumentCaptor<Report> reportCaptor;
	
	@Mock(serializable = true)
	private static Metric<Integer> metricIntMock= Mockito.mock(Metric.class);
	@Mock(serializable = true)
	private static Metric<Date> metricDatMock= Mockito.mock(Metric.class);
	@Mock(serializable = true)
	private static Indicator<Integer> indicatorIntMock= Mockito.mock(Indicator.class);
	

	private static Report reportTested;
	
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
		reportTested=new Report();	
		
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
		Date date=Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
		Mockito.when(metricIntMock.getName()).thenReturn("issues");
		Mockito.when(metricIntMock.getDescription()).thenReturn("Tareas sin finalizar en el repositorio");
	
		Mockito.when(metricIntMock.getValue()).thenReturn(3);	
		Mockito.when(metricDatMock.getName()).thenReturn("lastPush");
		Mockito.when(metricDatMock.getDescription()).thenReturn("Último push realizado en el repositorio");
	
		Mockito.when(metricDatMock.getValue()).thenReturn(date);
		//Primero se prueba a añadir una métrica de tipo Integer
		reportTested.addMetric(metricIntMock);
		
		Metric metric=reportTested.getMetricByName("issues");
		assertEquals(metric.getValue(),3,"Debería tener el valor especificado en el mock");
		assertEquals(metric.getDescription(),"Tareas sin finalizar en el repositorio","Debería tener el valor especificado en el mock");
		//Ahora se prueba una métrica de tipo Date
		reportTested.addMetric(metricDatMock);
		metric=reportTested.getMetricByName("lastPush");
		assertEquals(metric.getValue(),metricDatMock.getValue(),"Debería tener el valor especificado en el mock");
		assertEquals(metric.getDescription(),"Último push realizado en el repositorio","Debería tener el valor especificado en el mock");
		//Ahora se prueba a añadir otra vez la misma métrica pero con otro valor
		
		reportTested.addMetric(metricIntMock);
		Mockito.when(metricIntMock.getValue()).thenReturn(55);	
		metric=reportTested.getMetricByName("issues");
		assertEquals(metric.getValue(),55,"Debería tener el valor especificado en el mock");
		assertEquals(metric.getDescription(),"Tareas sin finalizar en el repositorio","Debería tener el valor especificado en el mock");
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
		//Se configura la calculadora de indicadores
		try {
			reportTested.setIndicatorsCalculator(indCalcMock);
		} catch (IndicatorException e1) {
			fail("No debería lanzar la excepción");
		}
		//Se solicita el cálculo de un indicador determinado
		reportTested.calcIndicator("issues");
		//Se observa con qué parámetros se invoca a la calculadora de indicadores
		try {
			Mockito.verify(indCalcMock).calcIndicator(strCaptor.capture(), reportCaptor.capture());
		} catch (IndicatorException e) {
			fail("No debería lanzar la excepción");
		}
		
		//Se verfica que se usa el nombre corecto y se pasa la referencia al informe correcto
		assertEquals("issues",strCaptor.getValue(),"Se solicita el cálculo de la métrica adecuada");
		assertEquals(reportTested,reportCaptor.getValue(),"Se pasa la referencia correcta del informe");
		//Hago un test que asegure que el propio informe captura y gestiona la excepción de que el indicador no existe
		try {
			Mockito.doThrow(new IndicatorException("El indicador no existe")).when(indCalcMock).calcIndicator("indKO", reportTested);
			reportTested.calcIndicator("indKO");			
		
		} catch (IndicatorException e) {
			fail("La excepción la debe gestionar el propio informe");
		}    
		
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
