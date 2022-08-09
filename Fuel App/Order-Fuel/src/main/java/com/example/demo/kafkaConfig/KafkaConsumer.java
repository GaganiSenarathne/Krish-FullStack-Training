package com.example.demo.kafkaConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import fuelApp.model.InventoryReserved;

@EnableKafka
@Configuration 
public class KafkaConsumer {
	
	@Value("localhost:9093")
    private String boostrapServer;


    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,InventoryReserved>> factory(
            ConsumerFactory<String, InventoryReserved> consumerFactory
    ){
        ConcurrentKafkaListenerContainerFactory<String,InventoryReserved> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    ConsumerFactory<String,InventoryReserved> consumerFactory(){
    	
//    	Mapping KAFKA Consumer variables
    	
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServer);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group-03");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
                new JsonDeserializer<>(InventoryReserved.class));
    }


}
