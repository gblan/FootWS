package et5.service.web;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.mail.MessagingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBException;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import et5.service.foot.FootServiceManager;
import et5.service.route.Route;
import et5.service.utils.Utils;
import eu.dataaccess.footballpool.Info;

public class FootWorldCupManager {
	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int CORRECT_SEND = 0;

	/* parameters for wsdl acces */
	private static final String responseQueue = "activemq:foot.responseQueue";
	private static final String requestQueue = "activemq:foot.requestQueue";
	private CamelContext camelcontext = new DefaultCamelContext();
	
	public FootWorldCupManager() {

	}
	
	public void connect() throws Exception {
		// Creation d'un contexte JNDI
		Context jndiContext = new InitialContext();
		
		// Lookup de la fabrique de connexion et de la destination
		ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");		

		camelcontext.addComponent("jms-test", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		camelcontext.start();		
	}
	/**
	 * @param teamName
	 * @return XML -> to string via JMS
	 * @throws IOException 
	 * 
	 */
	public String getRouteTeamSynchronous(String teamName) throws IOException {
		FootServiceManager fsm = new FootServiceManager(new Info());
		Route route = fsm.getCountryRoute(teamName);
		
		try {
			Utils.marshalToFile("et5.service.route", route, teamName+".xml");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Utils.fileToString(teamName+".xml");
	}

	/**
	 * XML -> via mail
	 * @param teamName
	 * @param mail
	 * @return int 
	 */
	public int getRouteTeamAsynchronous(String teamName, String mail) {
		/* ${headers.operationName} == 'obtenir_parcours_mail' */
		
		
		if (!Utils.mailValidator(mail)) {
			return MAIL_FORMAT_ERROR;
		} else {
			FootServiceManager fsm = new FootServiceManager(new Info());
			try {
				Utils.sendHTMLMailUsingSMTPAppliEmail(mail, "route of "+teamName, fsm.obtenirParcours(teamName));
			} catch (MessagingException | JAXBException | IOException e) {
				return MAIL_TRANSPORT_ERROR;
			}
		}
		return CORRECT_SEND;
	}


	/**
	 * @param message
	 * @param header
	 * @throws Exception
	 * envoi du code produit dans la queue
	 */
	public void sendMessageWithHeader(String message, String header) throws Exception {
		ProducerTemplate pt = camelcontext.createProducerTemplate();
		pt.sendBodyAndHeader(requestQueue, message, header);
	}
}
