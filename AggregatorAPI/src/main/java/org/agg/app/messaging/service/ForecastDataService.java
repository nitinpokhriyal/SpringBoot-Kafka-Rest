package org.agg.app.messaging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.agg.app.model.ForecastData;
import org.springframework.stereotype.Service;

@Service
public class ForecastDataService {
	
	private static Map<Integer,ForecastData>  map=new HashMap<Integer,ForecastData>();

	public ForecastData getForecastDataById(Integer id){
		 return map.get(id);
	} 
	
	public List<ForecastData> getForecastData(){
		 Set<Entry<Integer,ForecastData>> set=map.entrySet();
		 List<ForecastData> data=new ArrayList<ForecastData>();
		 for(Entry entry:set){
			 data.add((ForecastData)entry.getValue());
		 }
		 return data;
	}
	
	
}
