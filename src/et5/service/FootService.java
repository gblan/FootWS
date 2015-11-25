package et5.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Cette classe est l'implementation d'un web-service
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
		// TODO return XML -> to stringt
		return null;
	}
	
	@WebMethod
	public String getRouteTeamAsynchronous(String teamName, String mail){
		// TODO XML -> via mail
		// return error code
		return null;
	}
	
}
