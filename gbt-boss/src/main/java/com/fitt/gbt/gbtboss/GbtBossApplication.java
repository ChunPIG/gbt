package com.fitt.gbt.gbtboss;

import com.fitt.gbt.gbtboss.server.MainServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <p>@description: 程序入口</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-25</p>
 * <p>@version: 1.0</p>
 */
@SpringBootApplication
public class GbtBossApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(GbtBossApplication.class, args);
		MainServer.startServer();
	}
}
