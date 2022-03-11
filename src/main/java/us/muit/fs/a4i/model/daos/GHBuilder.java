/**
 * 
 */
package us.muit.fs.a4i.model.daos;

import java.util.logging.Logger;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 * <p>Clase abstracta con los métodos comunes a los constructores que recogen la información del servicio GitHub</p>
 * <p>Para las consultas a github se recurre a la API github-API</p>
 * <p>Actualmente sólo incluye el establecimiento del identificador de entidad y la obtención del objeto GitHub para las consultas</p>
 * @author Isabel Román
 *
 */
public abstract class GHBuilder<T> implements RemoteBuilder<T> {
	private static Logger log=Logger.getLogger(GHBuilder.class.getName());
	
	/**
	 * <p>El método construyeObjeto depende del tipo de entidad a construir y por lo tanto se delega la implementación a las clases hijas</p>
	 */
	@Override
	abstract public T construyeObjeto();
	/**
	 * <p>Referencia al objeto GitHub que permite hacer consultas al servidor Github</p>
	 * <p>Se crea al invocar por primera vez getConnectiony se mantiene mientras el GHBuilder esté vivo</p>
	 */
	private GitHub github=null;
	
	/**
	 * <p>Identificador unívoco de la entidad a recuperar en el servidor remoto</p>
	 * <p>Puede establecerse en el propio constructor o posteriormente usando setId, lo que permite reutilizar un objeto constructor para otros objetos del mismo tipo</p>
	 */
	
	protected String entityId;
	

	
	

	
	public GHBuilder() {
		
	}
	
	/**
	 * 	<p>Constructor con el que además se establece la identidad del objeto a construir</p>	
	 * @param id
	 */
	public GHBuilder(String id) {
		entityId=id;
		
		log.info("Creando el objeto GHBuilder");
	}
	
	/**
	 * <p>Permite establecer el valor del identificador unívoco de la entidad a construir, con lo que se puede reutilizar el mismo Builder para distintos objetos del mismo tipo</p>
	 */
	@Override
	public void setId(String id) {
		entityId=id;
	}

	
	/**
	 * <p>El objeto para contectarse al GitHub se crea la primera vez que se invoca getConnection</p>
	 * @return devuelve un objeto GitHub que permite la consulta al remoto
	 */
	protected GitHub getConnection() {
		
		if(github==null) try {
	
			   log.info("Creando el objeto GitHub");
		       github = GitHubBuilder.fromEnvironment().build();
	
		
		}catch(Exception e) {
		log.info(e+" No se puede crear la instancia GitHub\n");
		log.info("Recuerde que debe configurar las variables de entorno GITHUB_LOGIN y GITHUB_OAUTH con su nombre de usuario y token respectivamente");
	}	
		return github;
	}

}
