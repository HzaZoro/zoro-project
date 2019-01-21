package com.zoroa.consumer.Exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理类
 * @author Administrator
 *
 */

@ControllerAdvice
public class GlobalException {
	
	/**
	 * 全局异常处理方法
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Map<String,Object> errorException(HttpServletRequest request,Exception ex){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code", 500);
		result.put("msg", "全局异常错误:"+ex.getMessage());
		System.err.println(">>>>>>>>>Exception>>>>>>>>>> ");
		System.err.println(">>>>>>>>>Interface: "+request.getRequestURI());
		System.err.println(">>>>>>>>>msg: "+ex.getMessage());
		return result;
	}
	
	/**
	 * 自定义异常处理方法
	 * @return
	 */
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public Map<String,Object> myErrorException(Exception ex,HttpServletRequest request){
		
		StringBuffer requestURL = request.getRequestURL();
		System.err.println("URL:"+requestURL);
		String requestURI = request.getRequestURI();
		System.err.println("URI:"+requestURI);
		
		if(ex instanceof MyException) {
			System.err.println("类型符合MyException");
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code", 500);
		result.put("msg", "自定义异常错误");
		System.err.println("来自定义异常了");
		return result;
	}
	
}
