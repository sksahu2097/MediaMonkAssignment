package com.media.monk.controller;

import com.media.monk.model.ResponsePayload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message-check")
public class MessageController {
    
    @GetMapping("/{key}")
    public ResponseEntity<ResponsePayload> getMessageByKey(@PathVariable String key) {
        //hook service
        ResponsePayload payload = new ResponsePayload().setMessage("value found").setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(payload, HttpStatus.valueOf(payload.getStatus()));
    }
    
}
