package et5.service.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class Mail {
	private static final Logger logger = Logger.getLogger(Mail.class);

	/**
	 * Method that send a message to the adress "to" in param Works with GMAIL
	 * 
	 * @param from
	 * @param to
	 * @param mdpfrom
	 * @param subject
	 * @param content
	 */
	public static void sendMailSMTP(String from, String to, String mdpfrom,
			String subject, String content) {
		/* properties used for loggin */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");

		/* authentication object */
		Authenticator auth = new SMTPAuthenticator(from, mdpfrom);

		/* session used to send the message */
		Session session = Session.getInstance(props, auth);

		try {
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
			logger.info("Sent message successfully....");
		} catch (MessagingException mex) {
			logger.error("error when sending the message...."
					+ mex.getMessage());
		}
	}
}
