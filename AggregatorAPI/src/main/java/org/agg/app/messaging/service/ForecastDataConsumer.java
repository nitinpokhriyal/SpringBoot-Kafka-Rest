package org.agg.app.messaging.service;

import org.agg.app.model.ForecastData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ForecastDataConsumer {
	private final Logger logger = LoggerFactory.getLogger(ForecastDataConsumer.class);

	@KafkaListener(topics = "forecastData", groupId = "group_id")
	public void consume(ForecastData message) {
		logger.info(String.format("$$ -> Consumed Message -> %s", message.getForecastId()));
	}

}
