package com.fitt.gbt.gbtrmq.producer;

import com.fitt.gbt.gbtrmq.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>@description: 用户消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
public class UserProducer {
	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	public void send() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("就是不让你知道");
		logger.info(".......produce() send user={}", user);
		this.rabbitMQTemplate.convertAndSend("user", user);
	}
}
