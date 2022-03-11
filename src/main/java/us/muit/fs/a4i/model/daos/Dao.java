/**
 * 
 */
package us.muit.fs.a4i.model.daos;

import us.muit.fs.a4i.control.ReportManager;
import us.muit.fs.a4i.model.daos.exceptions.UnknownEntityException;

/**
 * <p>Esta interfaz declara un modo genérico de manejo de la persistencia de entidades del tipo T</p>
 * <p>Básicamente declara operaciones CRUD (crear, leer, actualizar y borrar la entidad)</p>
 * @author Isabel Román
 * @version 0.0
 *
 */
public interface Dao<T> {
	/**
	 * Lee del remoto la entidad de tipo T correspondiente al identificador pasado como parámetro
	 * @param id identificador unívoco de la entidad buscada
	 * @return Entidad creada
	 */
	public T create(String id);
	
	/**
	 * Operación de escritura
	 * Persiste localmente la entidad T pasada como parámetro
	 * @param t entidad a persistir
	 */
	public void save (T t);

	/**
	 * Operación de borrado
	 * Elimina localmente la entidad pasada como parámetro
	 * @param t entidad a eliminar
	 */
	public void delete (T t);
	/**
	 * Operación de borrado
	 * Elimina del repositorio la entidad cuyo identificador unívoco corresponde con el parámetro
	 * @param id identificador unívoco de la entidad a borrar
	 */
	public void delete (String id);
	
	public void setRemoteBuilder(RemoteBuilder<T> constructor);
	public void setReportManager(ReportManager reportmanager);
}