package com.data4life.email.util;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${org.mail.sender}")
	private String sender;

	public boolean sendEmail(String email) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom(sender);
			helper.setTo(new InternetAddress(email));
			helper.setSubject("Demo Subject");
			helper.setText("Demo Text");
			javaMailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
}
