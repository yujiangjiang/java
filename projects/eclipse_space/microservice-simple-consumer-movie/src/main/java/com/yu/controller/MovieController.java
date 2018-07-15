package com.yu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yu.vo.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	//通过配置文件的方式
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		String url = this.userServiceUrl+id;
		return this.restTemplate.getForObject(url, User.class);
	}

	public String getUserServiceUrl() {
		return userServiceUrl;
	}

	public void setUserServiceUrl(String userServiceUrl) {
		this.userServiceUrl = userServiceUrl;
	}
	
	
}
