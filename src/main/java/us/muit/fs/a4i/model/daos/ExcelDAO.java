/**
 * 
 */
package us.muit.fs.a4i.model.daos;

import java.util.logging.Logger;

import us.muit.fs.a4i.control.ReportManager;


/**
 * @author Isabel román
 * @param <T> Clase correspondiente al tipo local que se va a manejar
 *
 */
public class ExcelDAO<T> implements Dao<T> {
private static Logger log=Logger.getLogger(ExcelDAO.class.getName());
	
	private RemoteBuilder<T> factory;
	
	public ExcelDAO(RemoteBuilder<T> constructor) {
		factory=constructor;
		
		log.info("Creando el objeto ExcelDAO");
	}
	
	@Override
	public void setRemoteBuilder(RemoteBuilder<T> constructor) {
		factory=constructor;
		
	}
	
	@Override
	public T create(String id){
		factory.setId(id);
		return (T) factory.construyeObjeto();
	}

	@Override
	public void save(T t) {
		// TODO Este método tiene que guardar los datos de la entidad que se pase en el excel
		
	}

	@Override
	public void delete(T t) {
		// TODO Este método tiene que eliminar los datos de la entidad que se pase del excel
		
	}

	@Override
	public void delete(String id) {
		// TODO Este método tiene que eliminar los datos de la entidad con identificador id del excel
		
	}

	@Override
	public void setReportManager(ReportManager reportmanager) {
		// TODO Auto-generated method stub
		
	}
}
