package et5.service.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.mail.MessagingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConsumer;
import org.apache.camel.component.jms.JmsEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

import et5.service.foot.FootServiceManager;
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
		connect();
	}

	/**
	 * @param teamName
	 * @return XML -> to string via JMS
	 * @throws IOException
	 * @throws JAXBException
	 * 
	 */
	public String getRouteTeamSynchronous(String teamName) throws IOException, JAXBException {
		Map<String, Object> headers = new HashMap<String,Object>();
		headers.put("OPERATION_NAME", "obtenir_parcours_xml");
		headers.put("COUNTRY", teamName);
		int messageID = sendMessageWithHeader(teamName,headers);
		
		return receiveResponseString(messageID);
	}

	/**
	 * XML -> via mail
	 * 
	 * @param teamName
	 * @param mail
	 * @return int
	 */
	public int getRouteTeamAsynchronous(String teamName, String mail) {
		Map<String, Object> headers = new HashMap<String,Object>();
		headers.put("OPERATION_NAME", "obtenir_parcours_mail");
		headers.put("COUNTRY", teamName);
		headers.put("MAIL", mail);
		int messageID = sendMessageWithHeader(teamName,headers);
		
		return receiveResponseInt(messageID);

	}

	
	public void connect() {
		try {
			// Creation d'un contexte JNDI
			Context jndiContext = new InitialContext();

			// Lookup de la fabrique de connexion et de la destination
			ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");

			camelcontext.addComponent("jms-test", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			camelcontext.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param message
	 * @param header
	 * envoi du code produit dans la queue
	 * @param headers 
	 */
	public int sendMessageWithHeader(String message, Map<String, Object> headers){
		ProducerTemplate pt = camelcontext.createProducerTemplate();
		pt.sendBodyAndHeaders(requestQueue, message, headers);
		//TODO recuperer l'id du messag envoyé et le retourner
		return 0;
	}
	
	/**
	 * TODO
	 * @return
	 * @throws Exception
	 */
	public String receiveResponseString(final int idMessage){
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);		
		
		JmsConsumer consumer;
		try {
			consumer = responseEndPoint.createConsumer(new Processor() {
				final String response = "";

				public void process(Exchange e) throws Exception {
					e.getIn().getBody().toString();
				}});
			/* d�marrage du consumer pour r�ception de la r�ponse */
			consumer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/**
	 * TODO
	 * @return
	 * @throws Exception
	 */
	public int receiveResponseInt(final int idMessage){
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);			
		JmsConsumer consumer;
		
		final int response = 0;

		try {
			consumer = responseEndPoint.createConsumer(new Processor() {

				public void process(Exchange e) throws Exception {
					if(e.getIn().getMessageId().equals(Integer.toString(idMessage))){
						 e.getIn().getBody().toString();
					}
				}});
			/* d�marrage du consumer pour r�ception de la r�ponse */
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return response;
	}
}
