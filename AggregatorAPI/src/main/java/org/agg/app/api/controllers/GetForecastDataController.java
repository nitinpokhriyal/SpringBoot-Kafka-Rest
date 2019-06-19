package org.agg.app.api.controllers;

import java.util.List;

import org.agg.app.exceptions.RecordNotFoundException;
import org.agg.app.messaging.service.ForecastDataProducerService;
import org.agg.app.messaging.service.ForecastDataService;
import org.agg.app.model.ForecastData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetForecastDataController {
	
	@Autowired 
	private ForecastDataService forecastDataService;
	
	@Autowired
	private ForecastDataProducerService forecastDataProducerService;
	
	@RequestMapping("/forecast/{id}")
	public ForecastData getForecastDataById(@PathVariable String id){
		ForecastData data= forecastDataService.getForecastDataById(new Integer(id));
		if(data==null)
		 	throw new RecordNotFoundException("Invalid  id : " + id);
		
		return data;
	}
	 
	@RequestMapping("/forecast")
	public List<ForecastData> getForecastData(){
		return forecastDataService.getForecastData();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/forecast")
	public void addForecastData(@RequestBody ForecastData data){
		forecastDataProducerService.sendMessage(data);
		//System.out.println(data.getZone());
	}
}
