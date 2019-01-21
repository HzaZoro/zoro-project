package com.zoroa.provide.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProvideController {
	
	boolean flag = true;
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return port + ":hello";
	}
	
	@ResponseBody
	@RequestMapping(value="getInfo",method=RequestMethod.GET)
	public Map<String,String> getInfo(@RequestParam String userName){
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", port+":"+userName);
		return map;
	}
	
	@RequestMapping(value="/getHeaderInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> getHeaderInfo(@RequestHeader("token") String token,@RequestHeader("tokenId") String tokenId){
		Map<String,String> param = new HashMap<String,String>();
		param.put("token", token);
		param.put("tokenId", tokenId);
		return param;
	}
	
}
