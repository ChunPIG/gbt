package com.fitt.gbt.mongo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * <p>@description: 区域对象</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-30</p>
 * <p>@version: 1.0</p>
 */
@Data
@Document(collection = "region_new")
public class Region implements Serializable {
	private static final long serialVersionUID = -1598638832232979041L;

	@Id
	@JsonProperty("id")
	private String id;

	@Field
	@JsonProperty("region_name")
	private String regionName;

	@Field
	@JsonProperty("level")
	private String level;

	@DBRef
	@JsonProperty("parent")
	private Region parent;
}
