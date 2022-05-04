/**
 * 
 */
package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Context;

/**
 * @author isa
 *
 */
class AllMetricsTest {
	private static Logger log = Logger.getLogger(AllMetricsTest.class.getName());
	/**
	 * Test method for {@link us.muit.fs.a4i.config.Checker#listAllMetrics()}.
	 */
	@Test
	void testListAllMetrics() {
		List<String> metrics=null;
		try {
			metrics = Context.getContext().getChecker().listAllMetrics();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(metrics.toString());
		assertNotNull(metrics);
	}

}
