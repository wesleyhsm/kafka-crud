package com.consumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StringConsumerListener {
	
	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(StringConsumerListener.class);
	
	@KafkaListener(groupId = "group-0", topics = "wesley-topic", containerFactory = "stringContainerfactory")
	public void create(String message) {
		log.info("CREATE ::: message= {}", message);
	}
	
	@KafkaListener(groupId = "group-1", topics = "wesley-topic", containerFactory = "stringContainerfactory")
	public void log(String message) {
		log.info("LOG ::: message= {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "wesley-topic", containerFactory = "stringContainerfactory")
	public void history(String message) {
		log.info("history ::: message= {}", message);
	}
}
