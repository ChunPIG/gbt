package com.fitt.gbt.mongo.repository.impl;

import com.fitt.gbt.mongo.repository.RegionRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * <p>@description: 区域持久化操作自定义接口实现类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-30</p>
 * <p>@version: 1.0</p>
 */
public class RegionRepoImpl implements RegionRepoCustom {
	@Autowired
	private MongoTemplate mongoTemplate;
}
