package com.bee.sample.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bee.sample.ch1.vo.User;

@Controller
public class HelloworldController {

	@RequestMapping("/say.html")
	public @ResponseBody String say() {
		return "Hello Spring Boot!!!";
	}

	@GetMapping("/ftl/showUser.html")
	public ModelAndView showUserInfo(Long id) {
		ModelAndView view = new ModelAndView();
		User user = new User();
		user.setId(2);
		user.setName("yjj");
		view.addObject("user", user);
		view.setViewName("/ftl/userInfo");
		return view;
	}

	@GetMapping("/beetl/showUser.html")
	public ModelAndView showUserInfoBeetl(Long id) {
		ModelAndView view = new ModelAndView();
		User user = new User();
		user.setId((Integer.valueOf(id.toString())));
		user.setName("tttt");
		
		view.addObject(user);
		view.setViewName("/beetl/userInfo.btl");
		return view;
	}
	
	@PostMapping(path="/savejsonorder.json")
	@ResponseBody
	public String saveOrederByJson(@RequestBody User user){
		return user.getName();
	}
}
