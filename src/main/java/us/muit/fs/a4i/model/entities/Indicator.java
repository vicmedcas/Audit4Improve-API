/**
 * 
 */
package us.muit.fs.a4i.model.entities;

/**
 * @author Isabel Román
 *
 */
abstract public class Indicator<T,S,U> {
	protected String description;
	protected String name;
	protected T value;
	protected String unit;
	abstract public T calculateValueFrom(Metric<S> a,Metric<U> b);	
	
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
	
}