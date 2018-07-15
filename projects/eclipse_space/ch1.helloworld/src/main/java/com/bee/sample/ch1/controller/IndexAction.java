package com.bee.sample.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	
	@RequestMapping("/index.html")
	public String index(){
		return "/index";
	}
}
