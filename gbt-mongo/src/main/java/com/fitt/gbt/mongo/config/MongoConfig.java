package com.fitt.gbt.mongo.config;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * @Description: Mongodb手动配置MongoTemplate配置类
 * @Copyright: Copyright(C) 2016 by FITT
 * @Author: Miles[ZhengCongChun]
 * @Created: 2017年11月28日 下午4:58:49
 * @version: 1.0
 */
//@Configuration
//@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

	/**
	 * MongoDB连接基本属性
	 */
	private String mongoHost = "112.74.163.67";
	private int mongoPort = 27017;
	private String dbName = "aospro";
	private String username = "aospro";
	private String password = "aospro123";

	/**
	 * MongoDB集合对应的实体类包路径
	 */
	private static final String MONGO_BASE_PACKAGE = "com.fitt.gbt.mongo.domain";

	@Autowired
	private ApplicationContext appCtx;

	@Override
	protected String getDatabaseName() {
		return this.dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClientURI uri = new MongoClientURI(getMongoUri());
		MongoClient client = new MongoClient(uri);
		return client;
	}

	/**
	 * 获取mongodb链接uri mongodb://username:password@ip:port/dbname
	 * 
	 * @return
	 */
	private String getMongoUri() {
		StringBuffer uri = new StringBuffer();
		uri.append("mongodb://").append(username).append(":").append(password).append("@").append(mongoHost).append("/")
				.append(dbName);

		return uri.toString();
	}

	@Override
	protected Collection<String> getMappingBasePackages() {
		Collection<String> packages = new HashSet<String>();
		packages.add(MONGO_BASE_PACKAGE);
		return packages;
	}

	@Override
//	@Bean
	public MongoTemplate mongoTemplate() {
		// return new MongoTemplate(mongo(), getDatabaseName());
		return null;
	}

}
