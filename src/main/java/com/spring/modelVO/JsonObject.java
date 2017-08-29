package com.spring.modelVO;

import java.util.List;

import com.spring.model.Product;

public class JsonObject {
	private String jsonFunction;
	
	private Object jsonObject;

	public JsonObject() {
		super();
	}

	public JsonObject(String jsonFunction, Object jsonObject) {
		super();
		this.jsonFunction = jsonFunction;
		this.jsonObject = jsonObject;
	}

	public String getJsonFunction() {
		return jsonFunction;
	}

	public void setJsonFunction(String jsonFunction) {
		this.jsonFunction = jsonFunction;
	}

	public Object getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(Object jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	
	
	
	
	
}
