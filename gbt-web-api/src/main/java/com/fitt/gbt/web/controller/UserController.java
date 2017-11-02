package com.fitt.gbt.web.controller;

import com.fitt.gbt.common.config.DataSourceConfig;
import com.fitt.gbt.model.User;
import com.fitt.gbt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>@Description: 用户控制器</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/*@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;*/
	@Autowired
	private DataSourceConfig dataSourceConfig;

	@ResponseBody
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "Hello, Spring Boot!";
	}

	@ResponseBody
	@GetMapping
	public List<User> findAll() {
		if (null != dataSourceConfig) {
			logger.info("datasource=[url={}, username={}, password={}]",
					dataSourceConfig.getUrl(),
					dataSourceConfig.getUsername(),
					dataSourceConfig.getPassword());
		}

		return userService.findAll();
	}
}
