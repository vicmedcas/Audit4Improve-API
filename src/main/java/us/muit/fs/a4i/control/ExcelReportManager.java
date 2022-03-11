/**
 * 
 */
package us.muit.fs.a4i.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import us.muit.fs.a4i.model.entities.BasicReport;



/**
 * <p>Clase que cotendrán las funciones de manejo de excel comunes al manejo de cualquier informe<p>
 * <p>Se utiliza la API apachePOI para manejar los ficheros excel</p>
 * <p>Las primeras versiones se centran en la escritura</p>
 * @author Isabel Román
 * @param <T>
 *
 */
public abstract class ExcelReportManager implements ReportManager, FileManager{
	private static Logger log=Logger.getLogger(ExcelReportManager.class.getName());
	/**
	 * <p>Referencia al gestor de estilo que se va a utilizar</p>
	 */
	protected ReportFormater formater;
	BasicReport report;
	FileInputStream inputStream=null;
	
	/**
	 * <p>Localización del fichero excel/<p>
	 */
	protected String filePath="";
	/**
	 * <p>Nombre del fichero excel</p>
	 */
	protected String fileName="";
	
	protected HSSFWorkbook wb=null;
	protected HSSFSheet sheet=null;
	
	public void setReport(BasicReport report) {
		this.report=report;
	}

	abstract public void saveReport(BasicReport report);

	@Override
	public void setFormater(ReportFormater formater) {
		log.info("Establece el formateador");
		this.formater=formater;
		
	}

	@Override
	public void setPath(String path) {
		this.filePath=path;
		
	}

	@Override
	public void setName(String name) {
		this.fileName=name;
		
	}
	/**
	 * El libro contendrán todos los informes de un tipo concreto
	 * Primero hay que abrir el libro
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	protected HSSFSheet getSheet() throws EncryptedDocumentException, IOException {
		if(wb==null) {
			inputStream = new FileInputStream(filePath+fileName+".xls");
			wb = (HSSFWorkbook) WorkbookFactory.create(inputStream);
			log.info("Generado workbook");
		  
		}
		if(sheet==null)
		{
			  int templateIndex=wb.getSheetIndex("Template");
			  HSSFSheet sheet = wb.cloneSheet(templateIndex);
			  int newIndex=wb.getSheetIndex(sheet);
			  /**
			  * No permite que dos hojas se llamen igual, primero habría que buscar si ya está y trabajar sobre ella
			  */
	          wb.setSheetName(newIndex, report.getId().replaceAll("/", "."));
			  log.info("Creeada hoja");
		}
		
	// 	CreationHelper createHelper = wb.getCreationHelper();  
        
		return sheet;
	}
 
    public void save() throws IOException {
    	 FileOutputStream out = new FileOutputStream(filePath+fileName+".xls");
    	 wb.write(out);
    	 out.close();
    }

}
