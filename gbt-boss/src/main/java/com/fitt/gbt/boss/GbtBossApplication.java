package com.fitt.gbt.boss;

import com.fitt.gbt.boss.cache.SocketCache;
import com.fitt.gbt.boss.server.MainServer;
import com.fitt.gbt.boss.time.SendMessageTask;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>@description: 程序入口</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-25</p>
 * <p>@version: 1.0</p>
 */
@SpringBootApplication
public class GbtBossApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(GbtBossApplication.class, args);
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
				1,  new BasicThreadFactory.Builder().namingPattern("send-message-pool-%d").daemon(true).build());
		scheduledExecutorService.scheduleAtFixedRate(new SendMessageTask(), 0, 60, TimeUnit.SECONDS);
		MainServer.startServer();


	}
}
