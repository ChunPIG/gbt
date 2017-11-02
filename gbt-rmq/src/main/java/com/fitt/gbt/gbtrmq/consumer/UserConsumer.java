package com.fitt.gbt.gbtrmq.consumer;

import com.fitt.gbt.gbtrmq.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>@description: 用户消息消费者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
@RabbitListener(queues = "user")
public class UserConsumer {
	private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);


	@RabbitHandler
	public void process(User user) {
		logger.info(".......process() receive user:{}", user);
	}
}
