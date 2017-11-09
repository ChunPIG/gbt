package com.fitt.gbt.gbtrmq.producer;

import com.fitt.gbt.gbtrmq.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>@description: 用户消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
public class TopicProducer {
	private static final Logger logger = LoggerFactory.getLogger(TopicProducer.class);

	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	public void send() {
		String message = "I am topic.message ======";
		logger.info(".......produce() send topic message={}", message);
		this.rabbitMQTemplate.convertAndSend("exchange", "topic.message", message);

		message = "I am topic.messages ########";
		logger.info(".......produce() send topic messages={}", message);
		this.rabbitMQTemplate.convertAndSend("exchange", "topic.messages", message);
	}
}
