package et5.service.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {
	
	/**
	 * Method that send a message to the adress "to" in param using JavaMail
	 * 
	 * Works with GMAIL
	 * 
	 * @param from
	 * @param to
	 * @param fromPassword
	 * @param hostName
	 * @param port
	 * @param subject
	 * @param content
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendSMTPMail(String from, String to, String fromPassword, String hostName, String port,
			String subject, String content) throws AddressException, MessagingException {
		
		// Properties used for logging
		Properties props = new Properties();
		props.setProperty("mail.host", hostName); 	// smtp.gmail.com
		props.setProperty("mail.smtp.port", port);  // 587
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Authentication object
		Authenticator auth = new SMTPAuthenticator(from, fromPassword);

		// Session used to send the message
		Session session = Session.getInstance(props, auth);

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From/to: header field of the header.
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				to));

		// Write subject and content
		message.setSubject(subject);
		message.setText(content);

		// Send message
		Transport.send(message);
	}
}
