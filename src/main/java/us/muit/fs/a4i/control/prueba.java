/**
 * 
 */
package us.muit.fs.a4i.control;



import us.muit.fs.a4i.model.remote.RemoteBuilder;
import us.muit.fs.a4i.model.remote.RepositoryGHBuilder;
import us.muit.fs.a4i.model.daos.exceptions.ReportNotDefinedException;

import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.persistence.ExcelReportManager;
import us.muit.fs.a4i.persistence.FileManager;
import us.muit.fs.a4i.persistence.PersistenceManager;
/**
 * @author isa
 *
 */
public class prueba {

	/**
	 * @param args
	 * @throws ReportNotDefinedException 
	 */
	public static void main(String[] args) throws ReportNotDefinedException {
		
	ReportManagerI manager;
	ReportI report;
	PersistenceManager persister;
	RemoteBuilder builder;
	manager=new ReportManager();
	builder=new RepositoryGHBuilder();
	
	persister=new ExcelReportManager();
	manager.setRemoteBuilder(builder);
	manager.setPersistenceManager(persister);
	
	report=manager.createReport("MIT-FS/Audit4Improve-API");
	
	try {
		FileManager file=(FileManager) persister;
		file.setName("test");
		manager.save();
	
	} catch (ReportNotDefinedException e) {
		System.out.println("Cuidado tiene que establecer el informe");
		e.printStackTrace();
	}
	


}
}
	
