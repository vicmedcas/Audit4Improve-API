/**
 * 
 */
package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.remote.GitHubEnquirer;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;

/**
 * @author Isabel Román
 * Verifico el funcionamiento de GitHubRepositoryEnquirer
 *
 */
class RemoteTest {

	/**
	 * Test method for {@link us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer#getMetric(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetMetric() {
		GitHubEnquirer underTest = new GitHubRepositoryEnquirer();
		try{
			Metric myMetric=underTest.getMetric("totalAdditions","MIT-FS/Audit4Improve-API");
			assertNotNull("myMetric","No devuelve una métrica");
			assertEquals(myMetric.getName(),"totalAdditions","No devuelve la métrica esperada");
			assertNotNull(myMetric.getValue(),"No tiene un valor");
			assertEquals(myMetric.getSource(),"GitHub, calculada","La fuente no es GitHub, calculada");
		}
		catch (Exception e) {
			fail("Lanza excepción");

		} 
			
		}
		
}
