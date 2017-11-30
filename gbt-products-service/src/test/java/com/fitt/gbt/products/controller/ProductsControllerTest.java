package com.fitt.gbt.products.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fitt.gbt.products.service.ProductsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>@description: com.fitt.gbt.products.controller</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-31</p>
 * <p>@version: 1.0</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerTest {
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Autowired
	private ProductsService productsService;

	String expectedJson;

	@Before
	public void setUp() throws JsonProcessingException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testHello() throws Exception {
		String expectedResult = "Hello World";
		String uri = "api/products/hello";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus();

		String content = result.getResponse().getContentAsString();

//		Assert.assertTrue("错误, 正确的返回值为200", status == 200);
//		Assert.assertTrue("数据一致", expectedResult.equals(content));
	}

	@Test
	public void testServiceHello() throws Exception {
		String expectedResult = "Hello World";
		String content = productsService.hello();

		Assert.assertTrue("数据一致", expectedResult.equals(content));
	}
}
