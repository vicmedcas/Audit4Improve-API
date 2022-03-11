/**
 * 
 */
package us.muit.fs.a4i.model.daos;


/**
 * <p>Interfaz para desacoplar el mecanismo de construcción de una entidad de información del servidor remoto que aloja la información</p>
 * <p>El algoritmo de construcción en esta versión es: establecer el identificador unívoco del objeto a construir en el servidor e invocar construyeObjeto</p>
 * <p>La identidad se refiera al identificador unívoco del objeto que se quiere construir, la semántica puede depender del tipo</p>
 * @author IsabelRomán
 *
 */
public interface RemoteBuilder<T> {
	public void setId(String id);
	public T construyeObjeto();
}
