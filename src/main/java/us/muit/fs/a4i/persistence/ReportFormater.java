/**
 * 
 */
package us.muit.fs.a4i.persistence;

import java.awt.Color;
import java.awt.Font;

import us.muit.fs.a4i.model.entities.Indicator;

/**
 * <p>Interfaz genérica para establecer el estilo de los informes si se persisten en un medio visual</p>
 * @author Isabel Román
 *
 */
public interface ReportFormater {
	Color getMetricColor();
	void setMetricColor(Color color);
	Font getMetricFont();
	void setMetricFont(Font font);
	Color getIndicatorColor();
	void setIndicatorColor(Indicator.State state, Color color);
	Font getIndicatorFont();
	void setIndicatorFont(Indicator.State state, Font font);
}
