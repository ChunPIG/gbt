package com.fitt.gbt.gbtrmq.controller;

import com.fitt.gbt.gbtrmq.producer.CallbackProducer;
import com.fitt.gbt.gbtrmq.producer.FanoutProducer;
import com.fitt.gbt.gbtrmq.producer.Hello1Producer;
import com.fitt.gbt.gbtrmq.producer.Hello2Producer;
import com.fitt.gbt.gbtrmq.producer.HelloProducer;
import com.fitt.gbt.gbtrmq.producer.TopicProducer;
import com.fitt.gbt.gbtrmq.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description: https://www.cnblogs.com/boshen-hzb/p/6841982.html </p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping("/rabbit")
public class HelloController {
	@Autowired
	private HelloProducer helloProducer;

	@Autowired
	private Hello1Producer hello1Producer;

	@Autowired
	private Hello2Producer hello2Producer;

	@Autowired
	private UserProducer userProducer;

	@Autowired
	private TopicProducer topicProducer;

	@Autowired
	private FanoutProducer fanoutProducer;

	@Autowired
	private CallbackProducer callbackProducer;

	private static int cnt = 10;

	@PostMapping("/hello")
	public void oneToOne() {
		helloProducer.send();
	}

	@PostMapping("/hello2")
	public void oneToMany() {
		for (int i = 0; i < cnt; i++) {
			helloProducer.send();
		}
	}

	@PostMapping("/hello3")
	public void manyToMany() {
		String message = "message";
		for (int i = 0; i < cnt; i++) {
			hello1Producer.send(message + i);
			hello2Producer.send(message + i);
		}
	}

	@PostMapping("/user")
	public void user() {
		userProducer.send();
	}

	@PostMapping("/topic")
	public void topic() {
		topicProducer.send();
	}

	@PostMapping("/fanout")
	public void fanout() {
		fanoutProducer.send();
	}

	@PostMapping("/callback")
	public void callback() {
		callbackProducer.send();
	}
}
