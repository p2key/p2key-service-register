package com.p2key.service.manager.dto;

import com.p2key.service.manager.enums.Result;

public class MessageDTO {
	private Result result;
	private String message;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
