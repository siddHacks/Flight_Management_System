package com.flight_reservation_app.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void emailSending(String toAddress, String filePath) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary of Flight");
			messageHelper.setText("Please find the Attached");
			messageHelper.addAttachment("Itinerary", new File(filePath));
			javaMailSender.send(message);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}

}
