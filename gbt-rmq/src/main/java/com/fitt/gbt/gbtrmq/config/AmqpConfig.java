package com.fitt.gbt.gbtrmq.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>@description: 消息队列配置类</p>
 * http://docs.spring.io/spring-amqp/docs/1.4.5.RELEASE/reference/html/
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
@Configuration
public class AmqpConfig {
	private static final String EXCHANGE = "spring-boot-exchange";
	private static final String ROUTING_KEY = "spring-boot-routingKey";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses("192.168.20.155:5672");
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("airag123");
		connectionFactory.setHost("/");
		// 必须设置true, 才可进行消息回调
		connectionFactory.setPublisherConfirms(true);

		return connectionFactory;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	// 必须是prototype类型
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());

		return template;
	}

//	在发送消息时通过调用RabbitTemplate中的如下方法
//	public void convertAndSend(String exchange, String routingKey, final Object object, CorrelationData correlationData)
//	exchange:交换机名称
//	routingKey:路由关键字
//	object:发送的消息内容
//	correlationData:消息ID

	/**
	 * 针对消费者配置
	 * 1. 设置交换机类型
	 * 2. 将队列绑定到交换机
	 * <p>
	 * <p>
	 * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
	 * HeadersExchange ：通过添加属性key-value匹配
	 * DirectExchange:按照routingkey分发到指定队列
	 * TopicExchange:多关键字匹配
	 */
	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange(EXCHANGE);
	}

	@Bean
	public Queue queue() {
		return new Queue("spring-boot-queue", true); //队列持久

	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTING_KEY);
	}

	@Bean
	public SimpleMessageListenerContainer messageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
		container.setQueues(queue());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {

			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("receive msg : " + new String(body));
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
			}
		});
		return container;
	}
}
