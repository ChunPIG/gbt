package com.fitt.gbt.products.service;

import com.fitt.gbt.products.domain.Products;

import java.util.List;

/**
 * <p>@description: 产品服务接口</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
public interface ProductsService {
	/**
	 * Hello World API
	 * @return
	 */
	String hello();


	/**
	 * 获取产品列表
	 * @return
	 */
	List<Products> list();
}
