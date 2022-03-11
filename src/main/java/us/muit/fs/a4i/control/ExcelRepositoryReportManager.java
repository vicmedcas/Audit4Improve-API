/**
 * 
 */
package us.muit.fs.a4i.control;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import us.muit.fs.a4i.model.entities.BasicReport;

/**
 * @author isa
 *
 */
public class ExcelRepositoryReportManager extends ExcelReportManager {
	ExcelRepositoryReportManager(){
		this.fileName="RepositoriesReports";
	}
    @Override
	public void save(){
    	try {
			HSSFSheet sheet=getSheet();
			
			super.save();
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	
    }
	@Override
	public void saveReport(BasicReport report) {
		try {
			this.report=report;
			save();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
