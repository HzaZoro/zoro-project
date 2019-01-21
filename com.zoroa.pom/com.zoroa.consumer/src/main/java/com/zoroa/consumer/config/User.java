package com.zoroa.consumer.config;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
//@PropertySource(value="classpath:config/application-config.properties")
@PropertySource(value="classpath:com/zoroa/consumer/config/application-user.properties")
public class User {
	
	private String name;
	private String gender;
	private String age;
	private String home;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + ", home=" + home + "]";
	}
	
	
	
}
