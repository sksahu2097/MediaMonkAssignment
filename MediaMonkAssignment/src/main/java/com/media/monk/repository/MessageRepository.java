package com.media.monk.repository;

import java.util.List;

import com.media.monk.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	@Query(value = "select * from Message m where m.key = :key", nativeQuery = true)
	public List<Message> getMessageByKey(@Param("key") String key);
}
