package com.fitt.gbt.gbtrmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>@description: 简单消息消费者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
@RabbitListener(queues = "hello")
public class Hello2Consumer {
	private static final Logger logger = LoggerFactory.getLogger(Hello2Consumer.class);


	@RabbitHandler
	public void process(String message) {
		logger.info(".......process() 2 receive message:{}", message);
	}
}
