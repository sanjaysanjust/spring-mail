package com.example.mail.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.*;
import jakarta.mail.internet.*;

@Service
public class MailService {

	public String sendMail() throws AddressException, MessagingException, IOException {

		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// Your Gmail credentials
			String username = "sanjaysanjust@gmail.com";
			String password = "sukishreya17!";

			// Create a session with authentication
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			// Create and configure the message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("sanjaysanjust@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sanjaysanjust@gmail.com"));
			msg.setSubject("Tutorials point email");
			msg.setContent("Tutorials point email", "text/html");
			msg.setSentDate(new java.util.Date());

			// Optional: Attachments
			/*
			 * MimeBodyPart messageBodyPart = new MimeBodyPart();
			 * messageBodyPart.setContent("Tutorials point email", "text/html"); Multipart
			 * multipart = new MimeMultipart(); multipart.addBodyPart(messageBodyPart);
			 * msg.setContent(multipart);
			 */

			// Send the message
			Transport.send(msg);

			System.out.println("Message Sent Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ===> " + e.getMessage());
			return e.getMessage();
		}
		return "Message SENT SUCEES ....";

	}
}
