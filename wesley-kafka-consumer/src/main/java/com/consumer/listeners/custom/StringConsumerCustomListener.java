package com.consumer.listeners.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StringConsumerCustomListener {

	@AliasFor(annotation = KafkaListener.class, attribute = "topics")
	String[] topics() default "wesley-topic";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
	String containerFactory() default "stringContainerfactory";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "groupId")
	String groupId() default "";
}