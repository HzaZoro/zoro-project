package com.zoroa.consumer.Exception;

/**
 * 自定义异常
 * @author Administrator
 *
 */

public class MyException extends Exception{
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
