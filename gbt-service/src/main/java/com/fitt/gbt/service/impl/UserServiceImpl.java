package com.fitt.gbt.service.impl;

import com.fitt.gbt.dao.repository.UserRepository;
import com.fitt.gbt.model.User;
import com.fitt.gbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>@Description: 用户业务实现类</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
