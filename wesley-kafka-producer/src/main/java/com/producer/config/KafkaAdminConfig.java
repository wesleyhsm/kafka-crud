package com.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {

	@Autowired
	public KafkaProperties kafkaProperties;
	
	@Bean
	KafkaAdmin kafkaConfiguration() {
		Map<String, Object> mapConfigs = new HashMap<String, Object>();
		mapConfigs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		
		return new KafkaAdmin(mapConfigs);
	}
	
	@Bean
	KafkaAdmin.NewTopics topics(){
		return new KafkaAdmin.NewTopics(
				TopicBuilder.name("wesley-topic").partitions(2).replicas(1).build()
		);
	}
}
