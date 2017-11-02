package com.fitt.gbt.gbtrmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>@description: 简单的消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
public class HelloProducer {
	private static final Logger logger = LoggerFactory.getLogger(HelloProducer.class);

	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	public void send() {
		String message = "Hello" + new Date();
		logger.info(".......produce() send message={}", message);
		this.rabbitMQTemplate.convertAndSend("hello", message);
	}
}
