package com.consumer.listeners.exception;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.consumer.listeners.StringConsumerListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(StringConsumerListener.class);
	
	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		
		log.info("EXCEPTION_HANDLER :::: pegar o erro");
		log.info("Payload ::: {}", message.getPayload());
		
		
		return null;
	}

}
