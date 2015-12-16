package et5.service.web;


import javax.jws.WebMethod;
import javax.jws.WebService;

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
		FootWorldCupManager fwcm = FootWorldCupManager.getInstance();
		String result = "";
		try {
			result = fwcm.getRouteTeamSynchronous(teamName);
		} catch (Exception e) {
			System.err.println("Erreur lors de la récuperation du parcours du pays [" + teamName + "] en mode synchrone. " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@WebMethod
	public void getRouteTeamAsynchronous(String teamName, String mail){
		FootWorldCupManager fwcm = FootWorldCupManager.getInstance();
		fwcm.getRouteTeamAsynchronous(teamName, mail);
	}
	
	@WebMethod
	public String getCountryInformation(String countryName){
		FootWorldCupManager fwcm = FootWorldCupManager.getInstance();
		String result = "";
		try {
			result = fwcm.getCountryInfoSynchronous(countryName);
		} catch (Exception e) {
			System.err.println("Erreur lors de la récuperation des informations du pays [" + countryName + "] en mode synchrone. " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}
