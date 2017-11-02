package com.fitt.gbt.products.controller;

import com.fitt.gbt.products.domain.Products;
import com.fitt.gbt.products.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>@description: com.fitt.gbt.products.controller</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);


	@Autowired
	private ProductsService productsService;

	@GetMapping("/hello")
	public String hello() {
		logger.info("......hello()");
		return productsService.hello();
	}

	@GetMapping
	public List<Products> list() {
		logger.info("......list()");
		return productsService.list();
	}
}
