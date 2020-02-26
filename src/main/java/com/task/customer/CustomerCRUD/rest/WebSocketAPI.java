package com.task.customer.CustomerCRUD.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.task.customer.CustomerCRUD.service.CustomerServiceImpo;

@Controller
public class WebSocketAPI {

	private SimpMessagingTemplate template;
	@Autowired
	private CustomerServiceImpo customerService;
	
	
	@MessageMapping("/notifications")
	public void notifications(@RequestBody String customer) {

		template.convertAndSend("/topic/customers",customerService.findAll());
	}
}
