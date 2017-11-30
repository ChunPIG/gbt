package com.fitt.gbt.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>@Description: 数据库配置信息</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Miles[ZhengCongChun]</p>
 * <p>@Created: 2017-07-18</p>
 * <p>@version: 1.0</p>
 */
@Data
@Component
@EnableConfigurationProperties(DataSourceConfig.class)
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
	private String url;
	private String username;
	private String password;
}
