package com.fitt.gbt.dao.repository;

import com.fitt.gbt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>@Description: 用户持久化接口</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
}
