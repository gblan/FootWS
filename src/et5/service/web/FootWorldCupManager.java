package et5.service.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsConsumer;
import org.apache.camel.component.jms.JmsEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

public class FootWorldCupManager {

	/* parameters for wsdl acces */
	private final String responseQueue = "activemq:foot.responseQueue";
	private final String requestQueue = "activemq:foot.requestQueue";
	private CamelContext camelcontext = new DefaultCamelContext();
	private JmsConsumer consumer;

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

	/**
	 * WARNING : 
	 * for external deployment (1 bundle jar and 1 service jar), use camelcontext.start
	 * for bundle deployment (1 bundle jar with activator), use only activemq component)
	 */
	public void connect() {
		try {
			/* FOR external deployment */
			
//			// Creation d'un contexte JNDI
//			Context jndiContext = new InitialContext();
//		
//			// Lookup de la fabrique de connexion et de la destination
//			ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");
//			camelcontext.addComponent("jms-test", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
//			camelcontext.start();
			
			/* For bundle deployment ONLY */
			camelcontext.addComponent("activemq", new ActiveMQComponent());
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
		try {
			return receiveResponseString(teamName);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * XML -> via mail
	 * 
	 * @param teamName
	 * @param mail
	 * @return int
	 */
	public void getRouteTeamAsynchronous(String teamName, String mail) {
		Map<String, Object> headers = new HashMap<String,Object>();
		headers.put(operationNameHeader, "obtenir_parcours_mail");
		headers.put(countryHeader, teamName);
		headers.put(mailHeader, mail);
		sendMessageWithHeader(teamName, headers);
		try {
			receiveResponseInt(teamName);
		} catch (Exception e) {
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
	public String getCountryInfoSynchronous(String countryInfo) throws IOException, JAXBException {
		Map<String, Object> headers = new HashMap<String,Object>();
		headers.put(operationNameHeader, "obtenir_information_pays");
		headers.put(countryHeader, countryInfo);
		sendMessageWithHeader(countryInfo,headers);
		try {
			return receiveResponseString(countryInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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
	 * @throws Exception 
	 */
	public synchronized String receiveResponseString(final String teamName) throws Exception{
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);		
		consumer = responseEndPoint.createConsumer(new Processor() {
			public void process(Exchange e) throws Exception {
				if(e.getIn().getHeader(countryHeader).equals(teamName)){
					resultString = "";
					//					System.out.println("###resultString : "+resultString);
					if(!e.getIn().getHeaders().containsKey("ERROR")){
						resultString = e.getIn().getBody().toString();

					}
					//					System.out.println("###resultString : "+resultString);

					/* Pour notifier la reception bloquante */
					synchronized (consumer) {
						consumer.notify();
					}
				}
			}			
		});
		/* demarrage du consumer pour reception de la reponse */
		consumer.start();

		/* pour réveiller la reception */
		synchronized (consumer) {
			consumer.wait();
		}

		consumer.stop();

		return resultString;
	}

	/**
	 * 
	 * @param teamName
	 * @return
	 * @throws Exception 
	 */
	public int receiveResponseInt(final String teamName) throws Exception{
		JmsEndpoint responseEndPoint = (JmsEndpoint)camelcontext.getEndpoint(responseQueue);	

		consumer = responseEndPoint.createConsumer(new Processor() {
			public void process(Exchange e) throws Exception {
				if(e.getIn().getHeader(countryHeader).equals(teamName)){
					resultInt = 0;

					int status = (int) e.getIn().getHeader("STATUS");
					resultInt = status;

				}

				/* Pour notifier la reception bloquante */
//				synchronized (consumer) {
//					consumer.notify();
//				}			
			}
		});

		/* demarrage du consumer pour reception de la reponse */
		consumer.start();

		/* pour réveiller la reception */
//		synchronized (consumer) {
//			consumer.wait();
//		}

		consumer.stop();

		return resultInt;
	}

}
