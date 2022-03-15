/**
 * 
 */
package us.muit.fs.a4i.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import us.muit.fs.a4i.model.entities.Metric;

/**
 * <p>Clase para la gestión de los parámetros de contexto</p>
 * <p>Único punto para acceso a variables que pueden ser leídas por cualquiera, configuradas sólo por la clase context</p>
 * @author Isabel Román
 *
 */
public class Context {
	
	private static Logger log=Logger.getLogger(Context.class.getName());
	private static Properties prop =null;
	private static String confFile="a4i.conf";
	
	private Context(){		
	}	
	/**
	 * <p>Consulta el tipo de persistencia que se quiere utilizar</p>
	 * @return El tipo de persistencia usado (NOTA: deuda técnica, podría convenir usar un enumerado, para controlar mejor los tipos disponibles)
	 * @throws IOException si hay problemas al consultar las propiedades
	 */
	public static String getPersistenceType() throws IOException  {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("persistence.type");
	}
	/**
	 * <p>Consulta el tipo de remoto que se quiere manejar</p>
	 * @return El tipo de remoto (NOTA: deuda técnica, podría convenir usar un enumerado, para controlar mejor los tipos disponibles)
	 * @throws IOException si hay problemas al consultar las propiedades
	 */
	public static String getRemoteType() throws IOException {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("remote.type");
	}
	/**
	 * <p>Consulta el nombre del fichero para la configuración de indicadores</p>
	 * @return El nombre del fichero
	 * @throws IOException si hay problemas al consultar las propiedades
	 */
	public static String getIndicatorsFile() throws IOException {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("indicators.file");
	}
	/**
	 * <p>Consulta el nombre de todas las propiedades leídas</p>
	 * @return Conjunto con todos los nombres de las propiedades de configuración leídas
	 * @throws IOException si hay problemas al leer las propiedades
	 */
	public static Set<String> getPropertiesNames() throws IOException{
		if(prop==null) {
			setProperties();
		}
		return prop.stringPropertyNames();
	}
	/**
	 * <p>Por defecto usa el fichero a41.conf que se encuentre en la carpeta/main/resources</p>
	 * <p>Si se quiere cambiar se puede usar el método setConfigurationFile, pasando la ruta completa del fichero</p>
	 * @param filename nombre del fichero de configuración, ruta completa
	 * @throws IOException problemas al abrir el fichero
	 */
	public static void setConfigurationFile(String filename) throws IOException {
		log.info("Cambiando la configuración de la aplicación");
		confFile=filename;
		/*La próxima vez que se pida un parámetro de configuración se usarán los datos del nuevo fichero*/
		setProperties();
	}
	/**
	 * <p>Crea las propiedades y lee el fichero para rellenarlas</p>
	 * <p>La creación "rara" del objeto Contexto para usar el método de instancia getFile, es necesario para poder usar getClass y localizar el fichero de configuración en la carpeta "resources"</p>
	 * <p>El objeto Context (referencia me) se elimina al terminar, no sirve para nada más</p>
	 * @throws IOException si hay problemas leyendo el fichero
	 */
	private static void setProperties() throws IOException {
		log.info("Lectura del fichero de configuración");
		Context me=new Context();
		prop = new Properties();
		String filePath=me.getFile();
		log.info("Usando el fichero "+filePath);
		FileInputStream file= new FileInputStream(filePath);
	    me=null;
		prop.load(file);
	}
	/**
	 * <p>Recurso necesario para poder usar getClass() y localizar la ubicación de la carpeta recursos, sólo se puede usar si se instancia el objeto</p>
     *
	 */
	private String getFile() {
		 return getClass().getClassLoader().getResource(confFile).getFile();		
	}
}
