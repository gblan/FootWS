package et5.service.camel;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;

import org.apache.camel.Exchange;

import et5.service.foot.FootServiceManager;
import et5.service.route.Route;
import et5.utils.UtilsIO;
import et5.utils.UtilsMail;
import eu.dataaccess.footballpool.Info;

public class Service {
	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int CORRECT_SEND = 0;

	public void obtenirParcours(Exchange ex) throws JAXBException, IOException {
		FootServiceManager fsm = new FootServiceManager(new Info());
		Route route = fsm.getCountryRoute((String) ex.getIn().getHeader("COUNTRY"));

		/* data */
		ex.getOut().setBody(UtilsIO.marshalToString("et5.service.route", route));
		/* JMScorrelationID */
		ex.getOut().setHeader("JMSCorrelationID", ex.getIn().getMessageId());
	}

	/**
	 * A l'image de Route.java et des fichiers xslt et xsd, faire la meme pour
	 * un type de message XML qui indique juste si tout s'est bien passe ou
	 * pas???
	 * 
	 * @param ex
	 */
	public void envoiEmail(Exchange ex) {
		String country = (String) ex.getIn().getHeader("COUNTRY");
		String mail = (String) ex.getIn().getHeader("MAIL");
		int status = CORRECT_SEND;

		if (!UtilsMail.mailValidator((String) ex.getIn().getHeader("MAIL"))) {
			status = MAIL_FORMAT_ERROR;
		} else {
			FootServiceManager fsm = new FootServiceManager(new Info());
			try {
				String html = UtilsIO.transformXMLStringintoHTMLString(fsm.obtenirParcours(country));
				UtilsMail.sendHTMLMailUsingSMTPAppliEmail(mail, "route of " + country, html);

			} catch (MessagingException | JAXBException | IOException e) {
				status = MAIL_TRANSPORT_ERROR;
			}
		}

		/* JMScorrelationID */
		ex.getOut().setHeader("JMSCorrelationID", ex.getIn().getMessageId());
		/* status */
		ex.getOut().setHeader("STATUS", status);

	}
}
