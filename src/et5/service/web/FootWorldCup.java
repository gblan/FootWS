package et5.service.web;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Cette classe est l'impl�mentation d'un web-service
 */
@WebService
public class FootWorldCup {

	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int CORRECT_SEND = 0;

	/**
	 * Cette methode est declaree dans le WSDL
	 * @param name
	 * @return String,
	 */
	@WebMethod
	public String getRouteTeamSynchronous(String teamName){
		// TODO return XML -> to string via JMS
		return null;
	}
	
	@WebMethod
	public int getRouteTeamAsynchronous(String teamName, String mail){
		/* ${headers.operationName} == 'obtenir_parcours_mail' */

		// TODO XML -> via mail
		// return error code
//		if(!Utils.mailValidator(mail)){
//			return MAIL_FORMAT_ERROR;
//		}else{
//			FootServiceManager fsm = new FootServiceManager(new Info());			
//			try {
//				Utils.sendHTMLMailUsingSMTPAppliEmail(mail, "route of XXX", fsm.obtenirParcours(teamName));
//			} catch (MessagingException e) {
//				return MAIL_TRANSPORT_ERROR;
//			}
//		}
		return CORRECT_SEND;
	}
		
}
