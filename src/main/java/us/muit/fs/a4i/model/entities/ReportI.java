package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.List;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

public interface ReportI {
	/**
	 * <p>Tipos de informes, puede necesitarse cuando los algoritmos de cálculo de indicadores difieran según el tipo de informe</p>
	 * <p>Un informe sólo es de un tipo y no se puede modificar una vez establecido</p>
	 * 
	 */

	public static enum ReportType{
    	REPOSITORY,
    	DEVELOPER,
    	PROJECT,
    	ORGANIZATION
    }
	
	/**
	 * Consulta una métrica de un informe a partir del nombre
	 * @param name Nombre de la métrica solicitada
	 * @return Métrica solicitada
	 */
	Metric getMetricByName(String name);
	/**
	 * Obtiene todas las métricas del informe
	 * @return Colleción de métricas que contiene el informe
	 */
	Collection<Metric> getAllMetrics();
    /**
     * Añade una métrica al informe
     * @param met Nueva métrica
     */
	void addMetric(Metric met);
	/**
	 * Obtiene un indicador del informe a partir del nombre del mismo
	 * @param name Nombre del indicador consultado
	 * @return El indicador
	 */

	Indicator getIndicatorByName(String name);
	/**
	 * Añade un indicador al informe
	 * @param ind Nuevo indicador
	 */

	void addIndicator(Indicator ind);


	/**
	 * Establede el identificador unívoco de la entidad a la que se refiere el informe, debe ser el identificador usado en el remoto
	 * @param id Identificador unívoco de la entidad a la que se refiere el informe en el remoto
	 */
	void setId(String id);
	
    /**
     * Obtiene el identificador de la entidad a la que se refiere el informe
     * @return Identificador unívoco de la entidad a la que se refiere el informe en el remoto
     */
	String getId();
	
	
	/**
	 * Establece el tipo del informe, sólo se puede establecer una vez y debe coincidir con la el tipo de la calculadora usada
	 * @param type Tipo del informe 
	 */
	void setType(ReportI.ReportType type);
	/**
	 * Obtiene el tipo del informe
	 * @return Tipo del informe
	 */
	ReportI.ReportType getType();

}