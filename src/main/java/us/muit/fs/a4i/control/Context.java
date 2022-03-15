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
	
	public static String getPersistenceType() throws IOException  {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("persistence.type");
	}
	public static String getRemoteType() throws IOException {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("remote.type");
	}
	public static String getIndicatorsFile() throws IOException {
		if (prop==null) {
			setProperties();
		}
		return prop.getProperty("indicators.file");
	}
	public static Set<String> getPropertiesNames() throws IOException{
		if(prop==null) {
			setProperties();
		}
		return prop.stringPropertyNames();
	}
	/**
	 * <p>Por defecto usa el fichero a41.conf que se encuentre en la carpeta/main/resources</p>
	 * </p>Si se quiere cambiar se puede usar el método setConfigurationFile, pasando la ruta completa del fichero<p>
	 * @param filename
	 * @throws IOException
	 */
	public static void setConfigurationFile(String filename) throws IOException {
		log.info("Cambiando la configuración de la aplicación");
		confFile=filename;
		/*La próxima vez que se pida un parámetro de configuración se usarán los datos del nuevo fichero*/
		setProperties();
	}
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
	private String getFile() {
		 return getClass().getClassLoader().getResource(confFile).getFile();		
	}
}
