package com.fitt.gbt.mongo.service.impl;

import com.fitt.gbt.mongo.domain.Region;
import com.fitt.gbt.mongo.repository.RegionRepo;
import com.fitt.gbt.mongo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>@description: 区域服务业务接口实现类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-30</p>
 * <p>@version: 1.0</p>
 */
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepo regionRepo;

	@Override
	public void add(Region region) {
		regionRepo.save(region);
	}

	@Override
	public void deleteById(String id) {
		regionRepo.delete(id);
	}

	@Override
	public void update(Region region) {
		regionRepo.save(region);
	}

	@Override
	public List<Region> findAll() {
		return regionRepo.findAll();
	}

	@Override
	public Region findById(String id) {
		return regionRepo.findOne(id);
	}

	@Override
	public Page<Region> findByPage(int offset, int rows) {
		return regionRepo.findAll(new PageRequest(offset, rows));
	}
}
