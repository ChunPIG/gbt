package com.fitt.gbt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>@Description: 用户模型</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Data
@Entity(name = "person")
public class User extends BaseModel {
	@Id
	@Column(name = "user_id")
	@JsonProperty("user_id")
	private String userId;
	@Column(name = "login_name")
	@JsonProperty("login_name")
	private String loginName;
	@Column(name = "user_name")
	@JsonProperty("user_name")
	private String userName;
	@Column(name = "user_password")
	@JsonProperty("user_password")
	private String userPassword;
	@Column(name = "mobile")
	@JsonProperty("mobile")
	private String mobile;
	@Column(name = "company")
	@JsonProperty("company")
	private String company;
	@Column(name = "region_name")
	@JsonProperty("region_name")
	private String regionName;
	@Column(name = "department")
	@JsonProperty("department")
	private String department;
	@Column(name = "employee_type")
	@JsonProperty("employee_type")
	private Integer employeeType;
	@Column(name = "enabled")
	@JsonProperty("enabled")
	private Integer enabled;
}
