/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import us.muit.fs.a4i.config.Context;
import us.muit.fs.a4i.exceptions.MetricException;

/**
 * @author Isabel Román
 *
 */
public class Metric<T> {
	private static Logger log=Logger.getLogger(Metric.class.getName());
	/**
	 * Obligatorio
	 */
	private String name;
	/**
	 * Obligatorio
	 */
	private T value;
	/**
	 * Obligatorio
	 * Fecha en la que se tomó la medida (por defecto cuando se crea el objeto)
	 */
	private Date date;
	
	private String description;
	private String source;
	private String unit;
	
	private Metric(MetricBuilder<T> builder){
		
		this.description=builder.description;
		this.name=builder.name;
		this.value=builder.value;
		this.source=builder.source;
		this.unit=builder.unit;
		this.date=builder.date;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static class MetricBuilder<T>{
		private String description;
		private String name;
		private Date date;
		private T value;
		private String source;
		private String unit;
		public MetricBuilder(String metricName, T metricValue) throws MetricException {
			HashMap<String,String> metricDefinition=null;
			//el nombre incluye java.lang, si puede eliminar si se manipula la cadena
			//hay que quedarse sólo con lo que va detrás del último punto o meter en el fichero el nombre completo
			//Pero ¿y si se usan tipos definidos en otras librerías? usar el nombre completo "desambigua" mejor
			log.info("Verifico La métrica de nombre "+metricName+" con valor de tipo "+metricValue.getClass().getName());
			try {
			metricDefinition=Context.getContext().getChecker().definedMetric(metricName,metricValue.getClass().getName());
					
			if(metricDefinition!=null) {				
				this.name=metricName;
				this.value=metricValue;			
				this.date=Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
				this.description=metricDefinition.get("description");
				this.unit=metricDefinition.get("unit");
			}else {
				throw new MetricException("Métrica "+metricName+" no definida o tipo "+metricValue.getClass().getName()+" incorrecto");
			}
			}catch(IOException e) {
				throw new MetricException("El fichero de configuración de métricas no se puede abrir");
			}
			
			
		}
		public MetricBuilder<T> description(String description){
			this.description=description;
			return this;
		}
		public MetricBuilder<T> source(String source){
			this.source=source;
			return this;
		}
		public MetricBuilder<T> unit(String unit){
			this.unit=unit;
			return this;
		}
		public Metric<T> build(){
			return new Metric<T>(this);			
		}
	}
	
	@Override
	public String toString() {
		String info;
		info="Métrica para "+description+", con valor=" + value + ", source=" + source
				+ ", unit=" + unit +" fecha de la medida=  "+ date;
		return info;
	}
	
}
