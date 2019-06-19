package org.agg.app.model;

import java.util.Date;

public class ForecastData{
	
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long forecastId;
	private Date forecastDate;
	private String zone;
	 
	/*public ForecastData(Long forecastId,Date forecastDate,String zone){
		super();
		this.forecastId=forecastId;
		this.forecastDate=forecastDate;
		this.zone=zone;
	}*/
	
	
	public Long getForecastId() {
		return forecastId;
	}
	public void setForecastId(Long forecastId) {
		this.forecastId = forecastId;
	}
	public Date getForecastDate() {
		return forecastDate;
	}
	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
}
