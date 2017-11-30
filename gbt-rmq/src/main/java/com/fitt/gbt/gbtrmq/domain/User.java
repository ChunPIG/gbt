package com.fitt.gbt.gbtrmq.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>@description: 用户实体类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-30</p>
 * <p>@version: 1.0</p>
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 2928510432232897258L;

	private String username;

	private String password;

	private Date createTime = new Date();
}
