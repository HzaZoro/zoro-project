package com.zoroa.provide.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.zoroa.api.pojo.ResultBean;
import com.zoroa.api.service.InfoService;

/**
 * 提供的服务类
 * @author Administrator
 */
@RestController
public class ProvideService implements InfoService{

	@Value("${server.port}")
	String port;
	
	@Override
	public ResultBean<String> getInfo(String userName, Integer age) {
		ResultBean<String> resultBean = new ResultBean<String>();
		resultBean.setStatus("200");
		resultBean.setMsg("访问成功");
		resultBean.setData("port:"+port+"userName:"+userName+"age:"+age);
		return resultBean;
	}

	@Override
	public ResultBean<String> getHeaderInfo(String token, String tokenId) {
		ResultBean<String> resultBean = new ResultBean<String>();
		resultBean.setStatus("200");
		resultBean.setMsg("访问成功");
		resultBean.setData("port:"+port+"token:"+token+"tokenId:"+tokenId);
		return resultBean;
	}
	
}
