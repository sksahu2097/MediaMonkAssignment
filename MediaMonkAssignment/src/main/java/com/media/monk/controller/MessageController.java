package com.media.monk.controller;

import com.media.monk.model.Message;
import com.media.monk.model.ResponsePayload;
import com.media.monk.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("message-check")
public class MessageController {
    
	@Autowired
	MessageService messageService;
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
    @GetMapping("/{key}")
    public ResponseEntity<ResponsePayload> getMessageByKey(@PathVariable String key) {
    	logger.info("Get Message by id = {}", key);
        //hook service
    	Message msg = messageService.getMessageByKey(key);
        ResponsePayload payload = new ResponsePayload();
        if (msg == null) {
        	payload.setMessage("value is not present for this key = "+ key)
        	.setSuccess(false)
        	.setStatus(HttpStatus.BAD_REQUEST.value());
        } else {
        	payload.setMessage("value found")
        	.setResult(msg.getValue())
        	.setSuccess(true)
        	.setStatus(HttpStatus.OK.value());
        }
        return new ResponseEntity<>(payload, HttpStatus.valueOf(payload.getStatus()));
    }
    
}
