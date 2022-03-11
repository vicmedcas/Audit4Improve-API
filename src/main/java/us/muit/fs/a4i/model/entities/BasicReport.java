/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * <p>Aspectos generales de todos los informes</p>
 * <p>Todos incluirán un conjunto de métricas de tipo numérico y otro de tipo Date</p>
 * @author Isabel Román
 *
 */
public abstract class BasicReport {
	private static Logger log=Logger.getLogger(BasicReport.class.getName());
	/**
	 * <p>Identificador unívoco de la entidad a la que se refire el informe</p>
	 */
	protected String id;
	/**
	 * Métricas
	 * Conteos básicos, métricas de tipo numérico 
	 * */
	 
	private HashMap<String,Metric<Integer>> basicCounts;
	/**
	 * Fechas de interés
	 */
		
	private HashMap<String,Metric<Date>> relevantDates;
	/**
	 * Busca si está la métrica solicitada en los conjuntos comunes de conteos y fechas
	 * @param name Nombre de la métrica buscada
	 * @return la métrica localizada
	 */
	BasicReport(){
		basicCounts=new HashMap<String,Metric<Integer>>();
		relevantDates=new HashMap<String,Metric<Date>>();
		
	}
	BasicReport(String id){
		basicCounts=new HashMap<String,Metric<Integer>>();
		relevantDates=new HashMap<String,Metric<Date>>();
		this.id=id;		
	}

	public Metric getMetricByName(String name) {
		log.info("solicitada métrica de nombre "+name);
		Metric metric=null;
		
		if (basicCounts.containsKey(name)){
			metric=basicCounts.get(name);
		}else if (relevantDates.containsKey(name)){
				metric=relevantDates.get(name);
			}
		return metric;
	}

	public void addCountMetric(Metric<Integer> met) {
		
		basicCounts.put(met.getName(), met);
		log.info("Añadida métrica de conteo "+met);

	}
	
	public void addRelevantDate(Metric<Date> met) {
		relevantDates.put(met.getName(), met);
		log.info("Añadida métrica de fecha "+met);
	}
	abstract public Indicator getIndicator(String name);

	abstract public void calcIndicator(String name);
    public void setId(String id) {
    	this.id=id;
    }
    public String getId() {
    	return id;
    }
	@Override
	public String toString() {
		String repoinfo;
		repoinfo="Información del Informe:\n - Métricas de conteo: ";
		for (String clave:basicCounts.keySet()) {
		     repoinfo+="\n Clave: " + clave + basicCounts.get(clave);
		}
		repoinfo+="\n - Fechas relevantes: ";
		for (String clave:relevantDates.keySet()) {
		     repoinfo+="\n Clave: " + clave + relevantDates.get(clave);
		}
		return repoinfo;
	}

}
