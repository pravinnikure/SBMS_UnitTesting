package com.app.restapi.costomeexception;

import lombok.Data;

@Data
public class ErrorMessage 
{
	
	private String meassage;
	private String module;
	private String code;
	private String date;
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String meassage, String module, String code, String date) {
		super();
		this.meassage = meassage;
		this.module = module;
		this.code = code;
		this.date = date;
	}
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
