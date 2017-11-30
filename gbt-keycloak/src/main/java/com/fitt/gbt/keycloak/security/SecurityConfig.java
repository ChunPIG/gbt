//package com.fitt.gbt.keycloak.security;
//
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
///**
// * <p>@description: ebSecurityConfigurerAdapter扩展配置类</p>
// * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
// * <p>@author: Miles[ZhengCongChun]</p>
// * <p>@created: 2017-11-16</p>
// * <p>@version: 1.0</p>
// */
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//	/**
//	 * Registers the KeyCloakAuthenticationProvider with the authentication manager.
//	 * Spring Security 中角色都默认带上了前缀 ROLE_
//	 *
//	 * @return
//	 */
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//		KeycloakAuthenticationProvider provider = keycloakAuthenticationProvider();
//		provider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//		builder.authenticationProvider(provider);
//	}
//
//	/**
//	 * Keycloak Spring Security Adapter 默认会从你的 classpath 中找一个叫做 keycloak.json 的文件
//	 *
//	 * @return
//	 */
//	@Bean
//	public KeycloakConfigResolver keycloakConfigResolver() {
//		return new KeycloakSpringBootConfigResolver();
//	}
//
//	@Bean
//	@Override
//	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//	}
//
//	/**
//	 * 定义安全限制的地方
//	 * 把带有“user” 角色的路径 “/products” 给保护起来
//	 *
//	 * @param security
//	 * @throws Exception
//	 */
//	@Override
//	protected void configure(HttpSecurity security) throws Exception {
//		super.configure(security);
//		security
//				.authorizeRequests()
//				.antMatchers("/products").hasRole("test")
//				.anyRequest().permitAll();
//	}
//}
