package com.zoroa.consumer.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zoroa.consumer.service.ApiService;

@Service
public class SchedualHytrix implements ApiService {

	@Override
	public String transfer() {
		String str = "这是一个断路器";
		return str;
	}

	@Override
	public Map<String, String> getInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getHeaderInfo(String token, String tokenId) {
		// TODO Auto-generated method stub
		return null;
	}

}
