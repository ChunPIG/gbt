package com.fitt.gbt.products.domain;

import lombok.Data;

import java.util.Date;

/**
 * <p>@description: 产品对象</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
@Data
public class Products {
	private String id;
	private String productType;
	private String productName;
	private Date createTime;
}
