package com.mulcam.demo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@GetMapping("/staticMap")
	@ResponseBody
	public String staticMap() {
		InputStream is;
		Properties props = new Properties();
		try {
			is = new FileInputStream("/Workspace/naver.properties");
			props.load(is);
			is.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		String accessId = props.getProperty("accessId");
		String secretKey = props.getProperty("secertKey");
		
		return "accessId: " + accessId + "<br>secretKey: " + secretKey;
	}
}