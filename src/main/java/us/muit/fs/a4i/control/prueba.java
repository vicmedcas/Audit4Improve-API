/**
 * 
 */
package us.muit.fs.a4i.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import us.muit.fs.a4i.model.daos.ExcelDAO;

import us.muit.fs.a4i.model.daos.GHRepositoryReportBuilder;

import us.muit.fs.a4i.model.entities.RepositoryReport;

/**
 * @author isa
 *
 */
public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RepositoryReport repo;
	
		GHRepositoryReportBuilder builder = new GHRepositoryReportBuilder();
		
	
		ExcelDAO<RepositoryReport> dao = new ExcelDAO<RepositoryReport>(builder);
	   /**
	    * los nombres de la hojas no pueden contener barras
	    */
		repo=dao.create("MIT-FS/Audit4Improve-API");
	    System.out.println(repo);
	    ExcelRepositoryReportManager manager=new ExcelRepositoryReportManager();
	    System.out.println("Creado gestor de informe");
	    manager.setReport(repo);
	    try {
	    	HSSFSheet hoja=manager.getSheet();
			manager.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }

}
