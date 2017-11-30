package com.fitt.gbt.gbtkafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <p>@description: Kafka消息消费者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-09</p>
 * <p>@version: 1.0</p>
 */
//@Component
public class KafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

//	@KafkaListener(topics = {"airag-repo-test"})
	public void processMessage(String content) {
		logger.info("接收到信息： {}", content);
	}
}
