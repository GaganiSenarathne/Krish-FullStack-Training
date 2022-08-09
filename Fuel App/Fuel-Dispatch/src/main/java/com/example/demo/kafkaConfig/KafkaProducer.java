package com.example.demo.kafkaConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.demo.model.Dispatch;


@Configuration
public class KafkaProducer {
	
	@Value("localhost:9092") // KAFKA Bootstrap Server
    private String bootstrapServer;
	
	public Map<String,Object> producerConfig(){
		
//		Mapping KAFKA Producer configurations
		
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    ProducerFactory<String, Dispatch> producerFactory() {
//    	Return the Producer instance 
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    KafkaTemplate<String, Dispatch> kafkaTemplate(ProducerFactory<String, Dispatch> producerFactory) {
//    	Return the KAFKA Template instance
        return new KafkaTemplate<>(producerFactory);
    }
	

}
