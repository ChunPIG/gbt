package com.fitt.gbt.mongo.service;

import com.fitt.gbt.mongo.domain.Region;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>@description: 区域服务业务接口</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-30</p>
 * <p>@version: 1.0</p>
 */

public interface RegionService {

	/**
	 * 新增区域
	 *
	 * @param region
	 */
	void add(Region region);

	/**
	 * 根据ID删除ID
	 *
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 更新区域信息
	 *
	 * @param region
	 */
	void update(Region region);

	/**
	 * 查询所有
	 *
	 * @return
	 */
	List<Region> findAll();

	/**
	 * 根据ID查询区域信息
	 *
	 * @param id
	 * @return
	 */
	Region findById(String id);

	/**
	 * 分页查询区域信息
	 *
	 * @param offset 第几页-默认0第一条
	 * @param rows   每页容量-默认10条
	 * @return
	 */
	Page<Region> findByPage(int offset, int rows);
}
