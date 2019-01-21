package com.zoroa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zoroa.gateway.filter.RequestAccessFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GateWayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
	
	/**
	 * 需要通过这种方式，才能让该过滤器生效
	 * @return
	 */
	@Bean
	public RequestAccessFilter requestAccessFilter() {
		return new RequestAccessFilter();
	}
	
}
