package com.example.demo.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
	
public static final String MESSAGE_TOPIC = "topic_order_dispatch";
	
	@Bean
    NewTopic myTopic(){
//		Building the topic and returning the KAFKA Topic
        return TopicBuilder.name(MESSAGE_TOPIC).build();
    }


}
