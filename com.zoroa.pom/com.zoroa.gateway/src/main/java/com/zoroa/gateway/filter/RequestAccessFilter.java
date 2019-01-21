package com.zoroa.gateway.filter;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 在定义了该过滤器后,通过@Bean 的方式，来让过滤器生效
 * 
 * @author Administrator
 *
 */
public class RequestAccessFilter extends ZuulFilter{
	
	/**
	 * 定义根据什么规则进行过滤
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String accessToken = request.getParameter("accessToken");
		if(StringUtils.isBlank(accessToken)) {
			//让zuul过滤该请求，不对其进行路由
			currentContext.setSendZuulResponse(false);
			//并设置了返回的状态码
			currentContext.setResponseStatusCode(401);
			//设置返回的信息
			currentContext.setResponseBody("AccessToken is Empty");
			return null;
		}
		return null;
	}
	
	/**
	 * 该方法用来开启是否进行过滤
	 * true:代表该过滤器会对所有请求都生效
	 * 可以通过具体的配置，来定义需要过滤哪些请求
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	/**
	 * 该方法用来定义过滤顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
	/**
	 * 定义过滤器的请求生命周期，pre代表在请求被路由之前执行
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
}
