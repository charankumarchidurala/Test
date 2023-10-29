package com.uhg.optumrx.ms.hemi.service;

import java.util.List;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	private static final Logger LOGGER = LogManager.getLogger(KafkaConsumerService.class);
	@Autowired
	private UserService userService;
	
	 @KafkaListener(id = "${spring.kafka.bootstrap-servers.id}",topics = "${spring.kafka.filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory",groupId = "${spring.kafka.bootstrap-servers.groupId}")
     public void listen(List<ConsumerRecord<?, GenericRecord>> consumerRecords, Acknowledgment acknowledgment) {

         //userService.filterListenerData(message);
     }

}
