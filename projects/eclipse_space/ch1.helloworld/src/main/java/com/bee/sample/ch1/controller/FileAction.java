package com.bee.sample.ch1.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileAction {

	@PostMapping("/fileUpload.html")
	@ResponseBody
	public String handleFormUpload(String name, MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			InputStream ins=file.getInputStream();
			//处理上传内容
			File fileDes = new File("D:/upload/"+fileName);
			file.transferTo(fileDes);
			return "success";
		}
		
		return "failure";
	}
}
