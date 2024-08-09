package com.example.mail.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mail.service.MailService;

import jakarta.mail.MessagingException;

@RestController
public class MailController {
	@Autowired
	private MailService mailService;
	String msg = "";

	@GetMapping("/sendmail")
	public String sendMail() {

		try {
			System.out.println("Inside Controller");
			msg = mailService.sendMail();
			ResponseEntity.ok().body(msg);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			msg = e.getMessage();
			// return ResponseEntity.ok().body(e.getMessage());
		}

		return msg;
	}

}
