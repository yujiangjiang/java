package com.yu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yu.vo.User;

@RestController
public class MovieController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MovieController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBanalceClient;

	// 通过配置文件的方式
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		// String url = this.userServiceUrl + id;
		String url = "http://microservice-provider-user/" + id;
		return this.restTemplate.getForObject(url, User.class);
	}

	//注意，restTemplate.getForObject()和loadBanalceClient.choose()不能写在同一个方法，会冲突
	@GetMapping("log-instance")
	public void logUserInstance() {
		ServiceInstance serviceInstance = this.loadBanalceClient
				.choose("microservice-provider-user");
		//
		MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(),
				serviceInstance.getHost(), serviceInstance.getPort());
	}

	public String getUserServiceUrl() {
		return userServiceUrl;
	}

	public void setUserServiceUrl(String userServiceUrl) {
		this.userServiceUrl = userServiceUrl;
	}

}
