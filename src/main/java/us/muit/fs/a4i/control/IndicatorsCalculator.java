/**
 * <p>Algoritmos para el cálculo de indicadores específicos al tipo de informe</p>
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * 
 * <p>Define los métodos para calcular cada indicador y añadirlo al informe</p>
 * <p>Puede hacerse uno a uno o todos a la vez</p>
 * @author Isabel Román
 *
 */
public interface IndicatorsCalculator {
	/**
	 * Calcula el indicador con el nombre que se pasa
	 * Si las métricas que necesita no están en el informe las busca y las añade
	 * @param name
	 * @param report
	 */
	public void calcIndicator(String name,ReportI report);
	/**
	 * Calcula todos los indicadores descritos
	 * @param report
	 */
	public void calcAllIndicators(ReportI report);
}
