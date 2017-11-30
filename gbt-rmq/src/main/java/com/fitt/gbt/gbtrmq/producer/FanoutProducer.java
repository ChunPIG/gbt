package com.fitt.gbt.gbtrmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>@description: 广播\订阅消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
public class FanoutProducer {
	private static final Logger logger = LoggerFactory.getLogger(FanoutProducer.class);

	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	public void send() {
		String msgString="fanoutSender :hello i am hzb";
		System.out.println(msgString);
		this.rabbitMQTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
	}
}
