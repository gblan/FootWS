package et5.service.web;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;

import et5.service.foot.FootServiceManager;
import et5.service.route.Route;
import et5.service.utils.Utils;
import eu.dataaccess.footballpool.Info;

public class FootWorldCupManager {
	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int CORRECT_SEND = 0;

	/**
	 * @param teamName
	 * @return XML -> to string via JMS
	 * 
	 */
	public String getRouteTeamSynchronous(String teamName) {
		FootServiceManager fsm = new FootServiceManager(new Info());
		Route route = fsm.getCountryRoute(teamName);
		
		try {
			Utils.marshal("et5.service.route", route, teamName+".xml");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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

}
