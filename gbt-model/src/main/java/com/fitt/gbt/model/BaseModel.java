package com.fitt.gbt.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>@Description: 基础模型对象</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Data
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 2390983430457304660L;
	private Date createTime;
	private Date endTime;
}
