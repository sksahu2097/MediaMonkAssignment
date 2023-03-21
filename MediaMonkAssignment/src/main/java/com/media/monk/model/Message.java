package com.media.monk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "key")
	private String key;

	@Column(name = "value")
	private String value;

	public int getId() {
		return id;
	}

	public Message setId(int id) {
		this.id = id;
		return this;
	}

	public String getKey() {
		return key;
	}

	public Message setKey(String key) {
		this.key = key;
		return this;
	}

	public String getValue() {
		return value;
	}

	public Message setValue(String value) {
		this.value = value;
		return this;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", key=" + key + ", value=" + value + "]";
	}

}
