package com.fitt.gbt.gbtkafka;

import com.fitt.gbt.gbtkafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <p>@description: 程序总入口</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-11-09</p>
 * <p>@version: 1.0</p>
 */
@SpringBootApplication
//@EnableScheduling
public class GbtKafkaApplication {
//	@Autowired
//	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(GbtKafkaApplication.class, args);
	}

	/**
	 * 每隔一分钟执行一次
	 */
//	@Scheduled(fixedDelay = 10000)
//	public void testKafka() throws Exception {
//		System.err.println("发送消息");
//		kafkaProducer.send();
//	}
}
