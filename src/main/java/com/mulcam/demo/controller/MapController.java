package com.mulcam.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.demo.entity.StaticMap;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@Value("${naver.accessId}")
	private String accessId;
	
	@Value("${naver.secretKey}")
	private String secretKey;
	
	@GetMapping("/staticMap")
	public String staticForm() {
		String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?w=300&h=300&amp;center=127.1054221,37.3591614&level=16";
		url += "&X-NCP-APIGW-API-KEY-ID=" + accessId;
		url += "&X-NCP-APIGW-API-KEY=" + secretKey;
		
		return "map/staticForm";
	}
	
	@PostMapping("/staticMap")
	public String staticMap(StaticMap map, Model model) throws UnsupportedEncodingException {
		String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster"
				+ "?w=" + map.getWidth()
				+ "&h=" + map.getHeight()
				+ "&center=" + map.getLng() + "," + map.getLat()
				+ "&level=" + map.getLevel()
				+ "&maptype=" + map.getMaptype()
				+ "&format=" + map.getFormat()
				+ "&scale=" + map.getScale()
				+ "&lang=" + map.getLang()
				+ "&X-NCP-APIGW-API-KEY-ID=" + accessId
				+ "&X-NCP-APIGW-API-KEY=" + secretKey;
		
		String marker = "type:d|size:mid|pos:127.0724 37.538313";
		marker = URLEncoder.encode(marker, "utf-8");	//	" "(blank) 때문에 해야함
		url += "&markers=" + marker;
		
		marker = "type:t|size:tiny|pos:127.0824 37.538313|label:광진구청|color:red";
		marker = URLEncoder.encode(marker, "utf-8");	//	" "(blank) 때문에 해야함
		url += "&markers=" + marker;
		
		model.addAttribute("url", url);
		return "map/staticResult";
	}

}