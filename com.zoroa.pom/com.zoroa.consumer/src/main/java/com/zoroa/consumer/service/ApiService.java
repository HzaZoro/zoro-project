package com.zoroa.consumer.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoroa.consumer.service.impl.SchedualHytrix;

@FeignClient(value="provide-service",fallback=SchedualHytrix.class)
public interface ApiService {
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	public String transfer();
	
	@RequestMapping(value="/getInfo",method=RequestMethod.GET)
	public Map<String,String> getInfo(@RequestParam("userName") String name);
	
	@RequestMapping(value="/getHeaderInfo",method=RequestMethod.GET)
	public Map<String,String> getHeaderInfo(@RequestHeader("token") String token,@RequestHeader("tokenId") String tokenId);
}
