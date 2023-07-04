package com.producer.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StringProducerService {

	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(StringProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {		
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("wesley-topic", message);
		future.whenComplete((result, ex) -> {
	         if (ex == null) {
	        	 log.info("Send message with sucesss=[{}], Partition=[{}], Offset=[{}]", message, 
	        			 result.getRecordMetadata().partition(), result.getRecordMetadata().offset());            
	         } else {
	        	 log.error("Unable to send message=[{}]  due to : {}", message, ex.getMessage());	             
	         }
	     });
	}
}
