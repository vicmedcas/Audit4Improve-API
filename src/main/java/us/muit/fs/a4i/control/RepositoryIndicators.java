/**
 * 
 */
package us.muit.fs.a4i.control;

import java.util.logging.Logger;

import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * <p>Implementa los métodos para calcular indicadores referidos a un repositorio repositorio</p>
 * <p>Puede hacerse uno a uno o todos a la vez</p>
 * @author Isabel Román
 *
 */
public class RepositoryIndicators implements IndicatorsCalculator {
	private static Logger log=Logger.getLogger(RepositoryIndicators.class.getName());
	@Override
	public void calcIndicator(String name, ReportI report) {
		log.info("Calcula el indicador de nombre "+name);
		
	}

	@Override
	public void calcAllIndicatos(ReportI report) {
		log.info("Calcula todos los indicadores del repositorio");
	}

}
