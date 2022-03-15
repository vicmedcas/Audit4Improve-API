package us.muit.fs.a4i.persistence;

import us.muit.fs.a4i.control.ReportManagerI;
import us.muit.fs.a4i.exceptions.ReportNotDefinedException;
import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.model.remote.RemoteEnquirer;

public interface PersistenceManager {

	void setReport(ReportI report);
	void setFormater(ReportFormater formater);
	
	void saveReport() throws ReportNotDefinedException;
	
	void deleteReport()throws ReportNotDefinedException;
	
}