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
	 * <p>Identificador unívoco de la entidad a la que se refire el informe en el servidor remoto que se va a utilizar</p>
	 */
	private String entityId;
	
	private ReportI.ReportType type=null;
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
		createMaps();
		
	}
	public Report(String entiyId){
		createMaps();
		this.entityId=entityId;		
	}
	public Report(ReportType type){
		createMaps();
		this.type=type;		
	}
	public Report(ReportType type,String entityId){
		createMaps();
		this.type=type;	
		this.entityId=entityId;		
	}	
	private void createMaps() {
		metrics=new HashMap<String,Metric>();
		indicators=new HashMap<String,Indicator>();
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

    @Override
	public void setId(String entityId) {
    	this.entityId=entityId;
    }
    @Override
	public String getId() {
    	return entityId;
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
	@Override
	public ReportI.ReportType getType() {
		return type;
	}
	@Override
	public void setType(ReportI.ReportType type) {
		//Sólo se puede cambiar si no estaba aún establecido
		//Un informe no puede cambiar de tipo
		if (this.type==null) {
			this.type = type;
		}
	}


}
