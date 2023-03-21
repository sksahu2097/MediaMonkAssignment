package com.media.monk.service;

import java.util.List;

import com.media.monk.model.Message;

public interface MessageService {
	List<Message> getAllMessage();
	Message getMessageByKey(String key);
	void insertMessage(Message message);
}
