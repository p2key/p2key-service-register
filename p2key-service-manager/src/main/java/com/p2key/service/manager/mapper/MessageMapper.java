package com.p2key.service.manager.mapper;

import com.p2key.service.manager.dto.MessageDTO;
import com.p2key.service.manager.enums.Result;

public class MessageMapper {
	public static MessageDTO getFailMessage() {
		MessageDTO message = new MessageDTO();
		message.setResult(Result.FAIL);
		message.setMessage("Something is wrong!");
		return message;
	}
}
