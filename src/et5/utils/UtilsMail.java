package et5.utils;

import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import et5.service.utils.SMTPAuthenticator;
/**
 * class utils contains utils static methods
 */
public class UtilsMail {
	private static final String APPLI_PROPERTIES = "resources/appliMail.properties";
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/**
	 * @param to
	 * @param subject
	 * @param content
	 * @throws Exception 
	 */
	public static void sendHTMLMailUsingSMTPAppliEmail(String to, String subject,
			String content) throws Exception {

		String appliEmail = UtilsIO.readPropertyFile(APPLI_PROPERTIES, "Appli.Email");
		String appliPassword = UtilsIO.readPropertyFile(APPLI_PROPERTIES,"Appli.Password");
		String appliPort = UtilsIO.readPropertyFile(APPLI_PROPERTIES, "Appli.Port");
		String applihostname = UtilsIO.readPropertyFile(APPLI_PROPERTIES,"Appli.HostName");
		sendSMTPMail(appliEmail, to, appliPassword, applihostname, appliPort,subject, content, "text/html; charset=utf-8");
	}

	/**
	 * Method that send a message to the adress "to" in param using JavaMail
	 * 
	 * @param from
	 * @param to
	 * @param fromPassword
	 * @param hostName
	 * @param port
	 * @param subject
	 * @param content
	 * @param messageType 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	private static void sendSMTPMail(String from, String to,
			String fromPassword, String hostName, String port, String subject,
			String content, String messageType) throws AddressException, MessagingException {

		// Properties used for logging
		Properties props = new Properties();
		props.setProperty("mail.host", hostName); // smtp.gmail.com ou
													// smtp.free.fr ou
													// smtp.u-psud.fr
		props.setProperty("mail.smtp.port", port); // 587
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
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Write subject and content
		message.setSubject(subject);
		message.setContent(content,messageType);
		message.setSentDate(new Date());
		// Send message
		Transport.send(message);
	}



	/**
	 * @param mail
	 * @return true/false if the param is a mail adress
	 */
	public static boolean mailValidator(String mail) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		return pattern.matcher(mail).matches();
	}

}
