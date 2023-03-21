package com.media.monk.service;

import java.util.List;

import com.media.monk.model.Message;
import com.media.monk.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public List<Message> getAllMessage() {
		return messageRepository.findAll();
	}

	
	@Override
	public Message getMessageByKey(String key) {
		Message msg = messageRepository.getMessageByKey(key);
		return msg;
	}

	@Override
	public void insertMessage(Message message) {
		messageRepository.save(message);
		System.out.println("Values Inserted successfully !! "+ message);
	}

}
