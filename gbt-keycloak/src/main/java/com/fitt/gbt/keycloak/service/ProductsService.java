package com.fitt.gbt.keycloak.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>@description: 产品服务</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-11-16</p>
 * <p>@version: 1.0</p>
 */
@Service
public class ProductsService {
	public List<String> getProducts() {
		return Arrays.asList("iPad", "iPod", "iPhone", "iMac");
	}
}
