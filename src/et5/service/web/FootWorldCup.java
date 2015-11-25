package et5.service.web;

import javax.jms.ConnectionFactory;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import et5.service.utils.Utils;

/**
 * Cette classe est l'impl�mentation d'un web-service
 */
@WebService
public class FootWorldCup {
	private static final String responseQueue = "activemq:foot.responseQueue";
	private static final String requestQueue = "activemq:foot.requestQueue";
	//private CamelContext camelcontext;

	/**
	 * Cette methode est declaree dans le WSDL
	 * @param name
	 * @return String,
	 */
	@WebMethod
	public String getRouteTeamSynchronous(String teamName){
		// TODO return XML -> to string
		return null;
	}
	
	@WebMethod
	public int getRouteTeamAsynchronous(String teamName, String mail){
		/* ${headers.operationName} == 'obtenir_parcours_mail' */

		// TODO XML -> via mail
		// return error code
		if(!Utils.mailValidator(mail)){
			return -1;
		}else{
			
		}
		return 0;
	}
	
	/*public void connect() throws Exception {
		// Creation d'un contexte JNDI
		Context jndiContext = new InitialContext();
		
		// Lookup de la fabrique de connexion et de la destination
		ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");		

		camelcontext = new DefaultCamelContext();
		camelcontext.addComponent("jms-test", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		camelcontext.start();		
	}


//	 * envoi du code produit dans la queue
	public void sendMessageWithHeader(String message, String header) throws Exception {
		ProducerTemplate pt = camelcontext.createProducerTemplate();
		pt.sendBodyAndHeader(requestQueue, message, header);
	}*/
	
}
