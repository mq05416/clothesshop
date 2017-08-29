package com.spring.helper;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {
	public static boolean sendMail(String to, String subject, String text) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("luannv.aptech2015@gmail.com", "luangaabc");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress("luannv.aptech2015@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
		
		/*String result;
		   // Recipient's email ID needs to be mentioned.
		   //String to = "abcd@gmail.com";

		   // Sender's email ID needs to be mentioned
		   String from = "luannv.aptech2015@gmail.com";

		   // Assuming you are sending email from localhost
		   String host = "localhost";

		   // Get system properties object
		   Properties properties = System.getProperties();

		   // Setup mail server
		   properties.setProperty("mail.smtp.auth", "true");
		   properties.setProperty("mail.smtp.starttls.enable", "true");
		   properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		   properties.setProperty("mail.smtp.port", "587");
		   properties.setProperty("mail.smtp.host", host);

		   // Get the default Session object.
		   Session mailSession = Session.getDefaultInstance(properties);

		   try{
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(mailSession);
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));
		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));
		      // Set Subject: header field
		      message.setSubject("This is the Subject Line!");
		     
		      // Send the actual HTML message, as big as you like
		      message.setContent("<h1>This is actual message</h1>",
		                            "text/html" );
		      // Send message
		      Transport.send(message);
		      result = "Sent message successfully....";
		      return true;
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		      return false;
		   }*/
	}
}
