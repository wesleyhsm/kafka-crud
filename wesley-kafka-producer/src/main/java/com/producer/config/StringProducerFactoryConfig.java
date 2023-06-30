package com.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class StringProducerFactoryConfig {

	@Autowired
	public KafkaProperties kafkaProperties;
	
	@Bean
	ProducerFactory<String, String> producerFactory(){
		Map<String, Object> mapConfigs = new HashMap<String, Object>();
		mapConfigs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		mapConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		mapConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, String>(mapConfigs);
	}
	
	@Bean
	KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory){
		return new KafkaTemplate<>(producerFactory); 
	}
}
