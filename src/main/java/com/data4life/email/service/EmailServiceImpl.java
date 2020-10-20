package com.data4life.email.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.data4life.email.util.EmailSender;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired private EmailSender emailSender;

	@Override
	@Async
	public void sendEmail() {
		List<String> emails = getEmails();
		if(emails!=null && emails.size() > 0) {
			for(String email: emails) {
				try {
					System.out.println(email);
					emailSender.sendEmail(email);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}

	private List<String> getEmails() {
		List<String> emails = new ArrayList<>();
		for(int i=1;i<=1000000;i++) {
			emails.add("demo"+i+"@data4life.com");
		}
		return emails;
	}

}
