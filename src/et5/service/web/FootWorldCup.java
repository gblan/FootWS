package et5.service.web;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

/**
 * Cette classe est l'implementation d'un web-service
 */
@WebService
public class FootWorldCup {
	/**
	 * Cette methode est declaree dans le WSDL
	 * @param name
	 * @return String,
	 */
	@WebMethod
	public String getRouteTeamSynchronous(String teamName){
		FootWorldCupManager fwcm = new FootWorldCupManager();
		String result = "";
		try {
			result = fwcm.getRouteTeamSynchronous(teamName);
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@WebMethod
	public int getRouteTeamAsynchronous(String teamName, String mail){
		FootWorldCupManager fwcm = new FootWorldCupManager();
		return fwcm.getRouteTeamAsynchronous(teamName, mail);
	}
		
}
