package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.List;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

public interface ReportI {
	
	Metric getMetricByName(String name);
	
	Collection<Metric> getAllMetrics();

	void addMetric(Metric met);

	Indicator getIndicatorByName(String name);

	void addIndicator(Indicator ind);

	void calcIndicator(String name);

	void setId(String id);

	String getId();
	
	void setIndicatorsCalculator(IndicatorsCalculator calc) throws IndicatorException;
	
	void calcAllIndicators();

}