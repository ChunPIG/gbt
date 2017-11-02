package com.fitt.gbt.service;

import com.fitt.gbt.model.User;

import java.util.List;

/**
 * <p>@Description: 用户业务接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
public interface UserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAll();
}
