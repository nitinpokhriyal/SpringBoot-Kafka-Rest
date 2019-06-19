package org.agg.app.messaging.service;

import org.agg.app.model.ForecastData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class ForecastDataProducerService {

	private static final Logger logger = LoggerFactory.getLogger(ForecastDataProducerService.class);
	private static final String TOPIC = "forecastData";

	@Autowired
	private KafkaTemplate<String, ForecastData> kafkaTemplate;

	public void sendMessage(ForecastData forecastData) {
		logger.info(String.format("#### -> Producing message -> %s", forecastData.getForecastId()));
		//this.kafkaTemplate.send(TOPIC, message);
		Message<ForecastData> message = MessageBuilder
                .withPayload(forecastData)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

		kafkaTemplate.send(message);
	}

}
