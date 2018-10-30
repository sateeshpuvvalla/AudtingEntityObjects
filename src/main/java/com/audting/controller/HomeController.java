package com.audting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "AuditingEntityObjects sever is running";
	}

}
