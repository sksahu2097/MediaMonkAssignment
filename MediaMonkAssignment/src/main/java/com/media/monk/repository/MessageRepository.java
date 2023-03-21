package com.media.monk.repository;

import com.media.monk.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	@Query("select * from message where key = :key")
	public Message getMessageByKey(@Param("key") String key);
}
