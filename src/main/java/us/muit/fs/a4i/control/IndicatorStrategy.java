/**
 * 
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.model.entities.Indicator;

/**
 * 
 * <p>Interfaz común a todos los algoritmos de consulta de métricas</p>
 * @author isa
 * 
 */
public interface IndicatorStrategy {
	public Indicator getIndicator();

}
