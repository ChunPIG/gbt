package com.fitt.gbt.api.gateway.service;

import com.fitt.gbt.api.gateway.common.ApiMapping;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>@description: com.fitt.gbt.api.gateway.service</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-11-02</p>
 * <p>@version: 1.0</p>
 */
@Service
public class UserServiceImpl {
	@ApiMapping("com.fitt.gbt.api.user.getId")
	public String getID() {
		return UUID.randomUUID().toString();
	}
}
