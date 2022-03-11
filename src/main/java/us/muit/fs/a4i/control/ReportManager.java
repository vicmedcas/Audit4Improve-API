/**
 * 
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.model.entities.BasicReport;

/**
 * <p>Interfaz con los métodos disponibles para manejar informes, independientemente del sistema de persistencia utilizado</p>
 * <p>En las primeras versiones sólo se guardarán los informes a local, posteriormente también se podrán leer</p>
 * @author Isabel Román
 *
 */
public interface ReportManager {
	
	/**
	 * <p>Guarda el informe</p>
	 * @param report
	 */
	public void saveReport(BasicReport report);
	public void setReport(BasicReport report);
	/**
	 * <p>Establece el formateador a usar</p>
	 * @param El gestor de formato a utilizar
	 */
	public void setFormater(ReportFormater formater);
	
}
