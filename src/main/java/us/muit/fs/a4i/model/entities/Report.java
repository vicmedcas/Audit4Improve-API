/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import us.muit.fs.a4i.control.IndicatorsCalculator;

/**
 * <p>Aspectos generales de todos los informes</p>
 * <p>Todos incluirán un conjunto de métricas de tipo numérico y otro de tipo Date</p>
 * @author Isabel Román
 *
 */

public class Report implements ReportI {
	private static Logger log=Logger.getLogger(Report.class.getName());
	/**
	 * <p>Identificador unívoco de la entidad a la que se refire el informe</p>
	 */
	private String id;
	/**
	 * <p>Los objetos que implementen esta interfaz implementarán los algoritmos para el cálculo de indicadores<p>
	 * <p>Los algoritmos de cálculo de indicadores podrán ser específicos para un tipo de informe<p>
	 */
	private IndicatorsCalculator calc;
	
	/**
	 * <p>Tipos de informes, puede necesitarse cuando los algoritmos de cálculo de indicadores difieran según el tipo de informe</p>
	 * 
	 */
	
	public static enum Type{
	    	REPOSITORY,
	    	DEVELOPER,
	    	PROJECT,
	    	ORGANIZATION
	    }
	/**
	 * Mapa de Métricas
	 * 
	 * */
	 
	private HashMap<String,Metric> metrics;
	
	/**
	 * Mapa de indicadores
	 */
		
	private HashMap<String,Indicator> indicators;
	
	public Report(){
		metrics=new HashMap();
		indicators=new HashMap();
		
	}
	public Report(String id){
		metrics=new HashMap();
		indicators=new HashMap();
		this.id=id;		
	}
	/**
	 * <p>Busca la métrica solicita en el informe y la devuelve</p>
	 * <p>Si no existe devuelve null</p>
	 * @param name Nombre de la métrica buscada
	 * @return la métrica localizada
	 */
	@Override
	public Metric getMetricByName(String name) {
		log.info("solicitada métrica de nombre "+name);
		Metric metric=null;
		
		if (metrics.containsKey(name)){
			metric=metrics.get(name);
		}
		return metric;
	}
	/**
	 * <p>Añade una métrica al informe</p>
	 */

	@Override
	public void addMetric(Metric met) {
		
		metrics.put(met.getName(), met);
		log.info("Añadida métrica "+met);

	}
	/**
	 * <p>Busca el indicador solicitado en el informe y lo devuelve</p>
	 * <p>Si no existe devuelve null</p>
	 * @param name Nombre del indicador buscado
	 * @return el indicador localizado
	 */
	@Override
	public Indicator getIndicatorByName(String name) {
		log.info("solicitado indicador de nombre "+name);
		Indicator indicator=null;
		
		if (indicators.containsKey(name)){
			indicator=indicators.get(name);
		}
		return indicator;
	}
/**
 * <p>Añade un indicador al informe</p>	
 * 
 */ 
	@Override
	public void addIndicator(Indicator ind) {
		
		indicators.put(ind.getName(), ind);
		log.info("Añadido indicador "+ind);

	}
	/**
	 * <p>Calcula el indicador solicitado<p>
	 */
	@Override
	public void calcIndicator(String name) {
		calc.calcIndicator(name, this);
	}
    @Override
	public void setId(String id) {
    	this.id=id;
    }
    @Override
	public String getId() {
    	return id;
    }
    @Override
    public void setIndicatorsCalculator(IndicatorsCalculator calc) {
		log.info("Se establece la calculadora de indicadores que va a usar este informe");
		this.calc=calc;
		
	}
	
	@Override
	public String toString() {
		String repoinfo;
		repoinfo="Información del Informe:\n - Métricas: ";
		for (String clave:metrics.keySet()) {
		     repoinfo+="\n Clave: " + clave + metrics.get(clave);
		}
		repoinfo+="\n - Indicadores: ";
		for (String clave:indicators.keySet()) {
		     repoinfo+="\n Clave: " + clave + indicators.get(clave);
		}
		return repoinfo;
	}
	@Override
	public Collection<Metric> getAllMetrics() {
		// TODO Auto-generated method stub
		return metrics.values();
	}

}
