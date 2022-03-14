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
public class Indicator<T> {
	private static Logger log=Logger.getLogger(Indicator.class.getName());
	protected Date date;
	protected String source;
	protected String description;
	protected String name;
	protected T value;
	protected String unit;
	
	private Indicator(IndicatorBuilder<T> builder){
		
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
	
	public String getName() {
		return name;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public T getValue() {
		return value;
	}
	public static class IndicatorBuilder<T>{
		private String description;
		private String name;
		private Date date;
		private T value;
		private String source;
		private String unit;
		public IndicatorBuilder(String indicatorName, T indicatorValue) {
			this.name=indicatorName;
			this.value=indicatorValue;
			this.date=Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
		}
		public IndicatorBuilder<T> description(String description){
			this.description=description;
			return this;
		}
		public IndicatorBuilder<T> source(String source){
			this.source=source;
			return this;
		}
		public IndicatorBuilder<T> unit(String unit){
			this.unit=unit;
			return this;
		}
		public Indicator<T> build(){
			return new Indicator<T>(this);			
		}
	}
	@Override
	public String toString() {
		String info;
		info="Indicador para "+description+", con valor=" + value + ", source=" + source
				+ ", unit=" + unit +" fecha de cálculo=  "+ date;
		return info;
	}
	
}