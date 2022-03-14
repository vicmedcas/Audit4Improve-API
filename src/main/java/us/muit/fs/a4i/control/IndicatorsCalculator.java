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
	public void calcIndicator(String name,ReportI report);
	public void calcAllIndicatos(ReportI report);
}
