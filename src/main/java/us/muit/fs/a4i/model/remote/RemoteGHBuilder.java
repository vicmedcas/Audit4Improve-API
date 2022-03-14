/**
 * 
 */
package us.muit.fs.a4i.model.remote;

import java.util.logging.Logger;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import us.muit.fs.a4i.model.entities.ReportI;

/**
 * <p>Clase abstracta con los métodos comunes a los constructores que recogen la información del servicio GitHub</p>
 * <p>Para las consultas a github se recurre a la API github-API</p>
 * <p>Actualmente sólo incluye el establecimiento del identificador de entidad y la obtención del objeto GitHub para las consultas</p>
 * @author Isabel Román
 *
 */
public abstract class RemoteGHBuilder implements RemoteBuilder {
	private static Logger log=Logger.getLogger(RemoteGHBuilder.class.getName());
	

	/**
	 * <p>Referencia al objeto GitHub que permite hacer consultas al servidor Github</p>
	 * <p>Se crea al invocar por primera vez getConnectiony se mantiene mientras el GHBuilder esté vivo</p>
	 */
	private GitHub github=null;
	
	
		
	public RemoteGHBuilder() {
		
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
