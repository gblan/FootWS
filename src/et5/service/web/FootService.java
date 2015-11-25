package et5.service.web;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Cette classe est l'impl�mentation d'un web-service
 */
@WebService
public class FootService {

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
		// TODO XML -> via mail
		// return error code
		return 0;
	}
	
}
