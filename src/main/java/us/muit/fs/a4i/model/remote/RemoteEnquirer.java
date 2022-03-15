/**
 * 
 */
package us.muit.fs.a4i.model.remote;

import java.util.List;

import us.muit.fs.a4i.exceptions.MetricException;

import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * <p>Interfaz para desacoplar el mecanismo de obtención de métricas del servidor remoto que se use como fuente de las mismas</p>
 * <p>Un conjunto de métricas es específico para un tipo de entidad a informar: organización, proyecto, repositorio, desarrollador...</p>
 * <p>La identidad se refiere al identificador unívoco de la entidad sobre la que se quiere informar en el servidor remoto, la semántica puede depender del tipo de entidad y del remoto</p>
 * @author IsabelRomán
 *
 */
public interface RemoteEnquirer{
	
	/**
	 * <p>Construye el informe por defecto sobre la entidad indicada</p>
	 * @param entityId Identificador unívoco en el remoto de la entidad sobre la que se quiere informar.
	 * @return
	 */
	
	public ReportI buildReport(String entityId);
	/**
	 * <p>Consulta una métrica específica para una entidad concreta</p>
	 * @param metricName métrica solicitada
	 * @param entityId Identificador unívoco en el remoto de la entidad sobre la que se consulta
	 * @return
	 * @throws MetricException
	 */
	public Metric getMetric(String metricName,String entityId) throws MetricException;

	/**
	 * <p>Devuelve las métricas que puede obtener del remoto</p>
	 * @return
	 */
	public List<String> getAvailableMetrics();
}
