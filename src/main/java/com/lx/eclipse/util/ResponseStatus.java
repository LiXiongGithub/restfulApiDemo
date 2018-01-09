package com.lx.eclipse.util;

import com.alibaba.fastjson.JSON;

public class ResponseStatus {
	private String status;
	private String msg;
	private String code;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	/**
	 * 带参构造
	 * @param status
	 * @param msg
	 * @param code
	 */
	public ResponseStatus(String status, String msg, String code) {
		super();
		this.status = status;
		this.msg = msg;
		this.code = code;
	}
	/**
	 * 无参构造
	 */
	public ResponseStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 重写toString为json
	 */
	@Override
	public String toString() {
		try {
			return JSON.toJSONString(this);
		} catch (Exception e) {
			// TODO: handle exception
			return "{}";
		}
	
	}
	
	
	//create在内部类外，在外部类中
	public static ResponseStatusBuilder create() {//2.create方法，返回内部类对象
		return new ResponseStatusBuilder();
	}
	/**
	 * --------------------------------build模式
	 * @return
	 */
	public static class ResponseStatusBuilder{//1.穿件内部类，参数与外部相同
		private String status;
		private String msg;
		private String code;
		
		public ResponseStatusBuilder status(String status) {
			this.status = status;
			return this;
		}
		
		public ResponseStatusBuilder msg(String msg) {
			this.msg = msg;
			return this;
		}
		
		public ResponseStatusBuilder code(String code) {
			this.code = code;
			return this;
		}
		
		
		public ResponseStatus build(){//3.创建build方法，调外部class的带参构造方法，给外部对象赋值
			return new ResponseStatus(status, msg, code);
		}
		
	}
	public static void main(String[] args) {
		ResponseStatusBuilder builder = ResponseStatus.create();
		ResponseStatus response =builder.msg("注册成功").status("200").code("20001").build();
		String json  =response.toString();
		System.out.println(json);

	}
}
