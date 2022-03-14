/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Isabel Román
 *
 */
public class Metric<T> {
	private static Logger log=Logger.getLogger(Metric.class.getName());
	private String description;
	private String name;
	/**
	 * Fecha en la que se tomó la medida
	 */
	private Date date;
	private T value;
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
		public MetricBuilder(String metricName, T metricValue) {
			this.name=metricName;
			this.value=metricValue;
			this.date=Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
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
