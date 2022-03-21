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
import us.muit.fs.a4i.exceptions.IndicatorException;

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
	//Una vez establecido el tipo de informe no se podrá cambiar
	private Type type=null;
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
		metrics=new HashMap<String,Metric>();
		indicators=new HashMap<String,Indicator>();
		
	}
	public Report(String id){
		metrics=new HashMap<String,Metric>();
		indicators=new HashMap<String,Indicator>();
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
			log.info("La métrica está en el informe");
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
		log.info("Añadida métrica "+met+" Con nombre "+met.getName());
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
	 * <p>Calcula el indicador solicitado y lo incluye en el informe, si se necesita alguna métrica que no exista la calculadora la busca y la incluye<p>
	 */
	@Override
	public void calcIndicator(String name) {
		try {
			calc.calcIndicator(name, this);
		} catch (IndicatorException e) {
			log.info("No se puede calcular esta indicador, no se incluirá");
		}
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
    public void setIndicatorsCalculator(IndicatorsCalculator calc) throws IndicatorException {
		log.info("Se establece la calculadora de indicadores que va a usar este informe");
		if(this.type==null) {
			this.type=calc.getReportType();
		}else if(this.type!=calc.getReportType()){
			throw new IndicatorException("La calculadora no concuerda con el tipo de informe");
		}				
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		//Sólo lo cambio si no estaba aún establecido
		if (this.type==null) {
		this.type = type;
		}
	}
	@Override
	public void calcAllIndicators() {
		// TODO Auto-generated method stub
		
	}

}
