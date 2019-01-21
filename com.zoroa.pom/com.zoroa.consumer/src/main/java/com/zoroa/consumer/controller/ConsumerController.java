package com.zoroa.consumer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import com.zoroa.api.pojo.ResultBean;
import com.zoroa.consumer.config.User;
import com.zoroa.consumer.service.ApiService;
import com.zoroa.consumer.service.InfoApiService;

@Controller
public class ConsumerController {
	
	@Autowired
	ApiService apiService;
	
	@Autowired
	InfoApiService	infoApiService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	User user;
	
	@RequestMapping(value="hello",method=RequestMethod.GET)
	@ResponseBody
	public String sayHello()  {
//		throw new MyException();
		String transfer = apiService.transfer();
		
		System.err.println(user.toString());
		return transfer;
	}
	
	@RequestMapping(value="getInfo",method=RequestMethod.GET)
	@ResponseBody
	public String getInfo() {
		String name = "jack";
		Map<String, String> info = apiService.getInfo(name);
		String userName = info.get("userName");
		return userName;
	}
	
	@RequestMapping(value="getHeaderInfo",method=RequestMethod.GET)
	@ResponseBody
	public String getHeaderInfo() throws Exception {
		String token = "headerToken";
		String tokenId = "headerTokenId";
		Map<String, String> info = apiService.getHeaderInfo(token, tokenId);
		String str = objectMapper.writeValueAsString(info);
		return str;
	}
	
	@RequestMapping(value="/getTotal",method=RequestMethod.GET)
	@ResponseBody
	public ResultBean<String> getTotalInfo() throws Exception{
		
		ResultBean<String> info = infoApiService.getInfo("getInfoUserName", 20);
		
		ResultBean<String> info2 = infoApiService.getHeaderInfo("getHeaderToken", "getHeaderTokenId");
		
		String json1 = objectMapper.writeValueAsString(info);
		
		String json2 = objectMapper.writeValueAsString(info2);
		
		ResultBean<String> resultBean = new ResultBean<String>();
		resultBean.setStatus("200");
		resultBean.setMsg("访问成功");
		resultBean.setData(json1 + ">>>>>>" + json2);
		
		return resultBean;
	}
	
}
