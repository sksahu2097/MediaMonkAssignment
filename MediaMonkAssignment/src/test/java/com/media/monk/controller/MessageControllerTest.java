package com.media.monk.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.media.monk.model.Message;
import com.media.monk.service.MessageService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private MessageService messageService;

	@InjectMocks
	private MessageController messageController;

	@BeforeEach // this method runs before every test method runs
	public void setUp() throws Exception {
		// This line is use to run the controller as a standlone setup
		mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
	}

	@Test
	public void getMessageByKeyTest() throws Exception {
		Message msg = new Message().setKey("santosh").setValue("sahu");
		when(messageService.getMessageByKey("santosh")).thenReturn(msg);

		MockHttpServletResponse response = mockMvc.perform(get("/message-check/santosh"))
				.andReturn().getResponse();
		assertEquals(200, response.getStatus());
	}

}
