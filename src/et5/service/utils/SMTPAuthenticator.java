package et5.service.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Class to perform secure authentication for smtp mail sending
 */
public class SMTPAuthenticator extends Authenticator {
	private PasswordAuthentication authentication;

	public SMTPAuthenticator(String login, String password) {
		authentication = new PasswordAuthentication(login, password);
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}
