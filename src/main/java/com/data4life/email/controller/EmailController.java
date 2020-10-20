package com.data4life.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data4life.email.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@GetMapping(value = "/send_email")
	public String sendEmail() {
		emailService.sendEmail();
		return "success";

	}
}
