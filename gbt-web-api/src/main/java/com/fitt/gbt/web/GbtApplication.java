package com.fitt.gbt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动入口
 * 启动方式：
 * 1.IDE直接run\debug GbtApplication
 * 2.终端: mvn install && jar -jar target/gbt-0.0.1-SNAPSHOT.jar
 */
@SpringBootApplication
public class GbtApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbtApplication.class, args);
	}
}
