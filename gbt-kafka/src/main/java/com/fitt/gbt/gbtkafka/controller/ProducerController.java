package com.fitt.gbt.gbtkafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description: com.fitt.gbt.gbtkafka.controller</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-11-10</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping("/kafka")
public class ProducerController {
	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/send")
	public String send() {
		String topic = "airag-repo-test";
		String key = "airag-repo-test";
		String data = "hello122";
		kafkaTemplate.send(topic, key, data);
		return "SUCCESS";
	}

	@KafkaListener(id = "airag-repo-test", topics = "airag-repo-test")
	public void listenT1(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
	}

	@KafkaListener(id = "test-replicated-topic", topics = "test-replicated-topic")
	public void listenT2(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
	}
}
