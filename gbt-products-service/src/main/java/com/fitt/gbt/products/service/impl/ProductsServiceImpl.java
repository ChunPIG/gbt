package com.fitt.gbt.products.service.impl;

import com.fitt.gbt.products.domain.Products;
import com.fitt.gbt.products.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@description: 产品服务实现类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	@Override
	public String hello() {
		return "Hello World";
	}

	@Override
	public List<Products> list() {
		List<Products> products = new ArrayList<>();
		return products;
	}
}
