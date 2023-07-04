package com.consumer.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class StringConsumerConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Bean
	ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> mapConfigs = new HashMap<String, Object>();
		mapConfigs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		mapConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		mapConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, String>(mapConfigs);
	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, String> stringContainerfactory(ConsumerFactory<String, String> consumerFactory){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory);
		
		return factory;
	}
}
