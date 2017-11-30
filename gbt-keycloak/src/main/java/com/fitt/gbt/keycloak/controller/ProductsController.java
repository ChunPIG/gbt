package com.fitt.gbt.keycloak.controller;

import com.fitt.gbt.keycloak.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>@description: 产品web控制器</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-16</p>
 * <p>@version: 1.0</p>
 */
@Controller
public class ProductsController {
	@Autowired
	private ProductsService productsService;

	@GetMapping(path = "/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productsService.getProducts());
		return "products";
	}

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/";
	}
}
