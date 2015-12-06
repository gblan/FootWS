package et5.service.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
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

public class FootWorldCupManager {

	/* parameters for wsdl acces */
	private final String responseQueue = "activemq:foot.responseQueue";
	private final String requestQueue = "activemq:foot.requestQueue";
	private CamelContext camelcontext = new DefaultCamelContext();

	// Message Header 
	private final String countryHeader = "COUNTRY";
	private final String operationNameHeader = "OPERATION_NAME";
	private final String mailHeader = "MAIL";
	String resultString = "";
	int resultInt;

	private FootWorldCupManager() {
		connect();
	}
	
	/** Instance unique pré-initialisée */
	private static FootWorldCupManager INSTANCE = new FootWorldCupManager();
 
	/** Point d'accès pour l'instance unique du singleton */
	public static FootWorldCupManager getInstance(){
		return INSTANCE;
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
			System.err.println("Impossible de se connecter JNDI/JMS : " + e.getMessage());
			e.printStackTrace();
		}
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
		headers.put(operationNameHeader, "obtenir_parcours_xml");
		headers.put(countryHeader, teamName);
		sendMessageWithHeader(teamName,headers);
		return receiveResponseString(teamName);
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
		headers.put(operationNameHeader, "obtenir_parcours_mail");
		headers.put(countryHeader, teamName);
		headers.put(mailHeader, mail);
		sendMessageWithHeader(teamName, headers);
		return receiveResponseInt(teamName);
	}

	/**
	 * @param message
	 * @param headers
	 */
	public void sendMessageWithHeader(String message, Map<String, Object> headers){
		ProducerTemplate pt = camelcontext.createProducerTemplate();
		pt.sendBodyAndHeaders(requestQueue, message, headers);
	}

	/**
	 * 
	 * @param teamName
	 * @return
	 */
	public String receiveResponseString(final String teamName){
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);		
		JmsConsumer consumer;
		try {
			consumer = responseEndPoint.createConsumer(new Processor() {
				public void process(Exchange e) throws Exception {
					if(e.getIn().getHeader(countryHeader).equals(teamName)){
						resultString = e.getIn().getBody().toString();
					}
				}			
			});
			/* demarrage du consumer pour reception de la reponse */
			consumer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultString;
	}

	/**
	 * 
	 * @param teamName
	 * @return
	 */
	public int receiveResponseInt(final String teamName){
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);			
		JmsConsumer consumer;
		try {
			consumer = responseEndPoint.createConsumer(new Processor() {
				public void process(Exchange e) throws Exception {
					if(e.getIn().getHeader(countryHeader).equals(teamName)){
						resultInt = Integer.parseInt((String) e.getIn().getHeader("STATUS"));
					}
				}});
			
			/* demarrage du consumer pour reception de la reponse */
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultInt;
	}
}
