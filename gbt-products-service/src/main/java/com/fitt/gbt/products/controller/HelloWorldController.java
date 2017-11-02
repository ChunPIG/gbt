package com.fitt.gbt.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description: com.fitt.gbt.products.controller</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-11-01</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {
	@GetMapping
	public String hello() {
		return "Hello World!";
	}
}
