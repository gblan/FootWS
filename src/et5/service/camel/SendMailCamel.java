package et5.service.camel;

import javax.mail.MessagingException;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import et5.service.utils.Utils;

public class SendMailCamel {
	private static final Logger logger = Logger.getLogger(SendMailCamel.class);

	/**
	 * method print exchange
	 * 
	 * @param exchange
	 */
	public void sendMailCamel(Exchange ex) {
		logger.info("[" + ex.getExchangeId() + "] : "
				+ ex.getIn().getBody(String.class));
		try {
			Utils.sendSMTPMail("", "", "", "", "", "", "");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}