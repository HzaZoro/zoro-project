package com.zoroa.api.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoroa.api.pojo.ResultBean;

@RequestMapping(value="infoService")
public interface InfoService {
	
	/**
	 * 获取信息接口
	 * @param userName
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/getInfo",method=RequestMethod.GET)
	public ResultBean<String> getInfo(@RequestParam(value="userName") String userName ,@RequestParam(value="age") Integer age);
	
	/**
	 * 获取header请求头信息
	 * @param token
	 * @param tokenId
	 * @return
	 */
	@RequestMapping(value="/getHeaderInfo",method=RequestMethod.GET)
	public ResultBean<String> getHeaderInfo(@RequestHeader(value="token") String token,@RequestHeader(value="tokenId") String tokenId);
}
