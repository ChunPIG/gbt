package com.fitt.gbt.gbtrmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * <p>@description: 用户消息生产者</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Component
public class CallbackProducer implements  RabbitTemplate.ConfirmCallback {
	private static final Logger logger = LoggerFactory.getLogger(CallbackProducer.class);

	@Autowired
	private RabbitTemplate rabbitTemplatenew;

	public void send() {
		rabbitTemplatenew.setConfirmCallback(this);
		String msg="callbackSender : i am callback sender";
		System.out.println(msg );
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		System.out.println("callbackSender UUID: " + correlationData.getId());
		this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("callback confirm: " + correlationData.getId());
	}
}
