package com.fitt.gbt.mongo.controller;

import com.fitt.gbt.mongo.domain.Region;
import com.fitt.gbt.mongo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description: com.fitt.gbt.mongo.controller</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-30</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping(value = "/regions")
public class RegionController {

	private static int offset = 0;
	private static int rows = 10;

	@Autowired
	private RegionService regionService;

	@GetMapping
	public Page<Region> findByPage(@RequestParam("page_no") String pageNo,
								   @RequestParam("page_size") String pageSize) {

		if (!StringUtils.isEmpty(pageNo)) { offset = Integer.valueOf(pageNo);}
		if (!StringUtils.isEmpty(pageSize)) { rows = Integer.valueOf(pageSize);}
		return regionService.findByPage(offset, rows);
	}
}
