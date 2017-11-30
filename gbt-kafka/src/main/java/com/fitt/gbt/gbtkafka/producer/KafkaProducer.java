package com.fitt.gbt.gbtkafka.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>@description: Kafka消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-09</p>
 * <p>@version: 1.0</p>
 */
//@Component
public class KafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

//	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send() {
		String msg = "producer send message test: " + new Date();
		kafkaTemplate.send("airag-repo-test", msg);

		kafkaTemplate.metrics();

		kafkaTemplate.execute(new KafkaOperations.ProducerCallback<String, String, Object>() {
			@Override
			public Object doInKafka(Producer<String, String> producer) {
				// TODO 编写Kafka原生的API操作
				return null;
			}
		});

		// 消息发送的监听器, 用户回调返回信息
		kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
			@Override
			public void onSuccess(String s, Integer integer, String s2, String s3, RecordMetadata recordMetadata) {
				logger.info("消息发送成功");
			}

			@Override
			public void onError(String s, Integer integer, String s2, String s3, Exception e) {
				logger.error("消息发送失败：{}", e.getMessage());
			}

			@Override
			public boolean isInterestedInSuccess() {
				return false;
			}
		});
	}
}
