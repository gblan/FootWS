package et5.service.camel;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.camel.Exchange;

import et5.service.country.CountryManager;
import et5.service.foot.FootServiceManager;
import et5.utils.UtilsIO;
import et5.utils.UtilsMail;
import eu.dataaccess.footballpool.Info;

public class Service {
	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int NO_COUNTRY_FOUND_EXCEPTION = 3;
	private static final int CORRECT_SEND = 0;

	public void obtenirParcours(Exchange ex) throws JAXBException, IOException {
		FootServiceManager fsm = new FootServiceManager(new Info());
		String parcoursXML = fsm.obtenirParcours((String) ex.getIn().getHeader("COUNTRY"));

		/* if error */
		if(parcoursXML.equals("")){
			ex.getOut().setHeader("ERROR", "COUNTRY_NOT_FOUND");
		}else{
		/* data */
			ex.getOut().setBody(parcoursXML);
		}
	
		/* set headers from incoming message */
		ex.getOut().setHeader("COUNTRY", (String) ex.getIn().getHeader("COUNTRY"));

		if(ex.getIn().getHeader("MAIL") != null){
			ex.getOut().setHeader("MAIL", (String) ex.getIn().getHeader("MAIL"));

		}
	}

	/**
	 * A l'image de Route.java et des fichiers xslt et xsd, faire la meme pour
	 * un type de message XML qui indique juste si tout s'est bien passe ou
	 * pas???
	 * 
	 * @param ex
	 */
	public void envoiEmail(Exchange ex) {
		String country = (String) ex.getIn().getHeader("COUNTRY");
		String mail = (String) ex.getIn().getHeader("MAIL");
		int status = CORRECT_SEND;

		if(ex.getIn().getHeader("ERROR")!=null){
			status = NO_COUNTRY_FOUND_EXCEPTION;
		}else if (!UtilsMail.mailValidator((String) ex.getIn().getHeader("MAIL"))) {
			status = MAIL_FORMAT_ERROR;
		} else {
			try {
				String html = UtilsIO.routeTransformXMLStringIntoHTMLString((String) ex.getIn().getBody());
				UtilsMail.sendHTMLMailUsingSMTPAppliEmail(mail, "route of " + country, html);

			} catch (Exception e) {
				status = MAIL_TRANSPORT_ERROR;
			}
		}

		/* set headers from incoming message */
		ex.getOut().setHeaders(ex.getIn().getHeaders());

		/* status */
		ex.getOut().setHeader("STATUS", status);

	}
	
	public void obtenirInformationPays(Exchange ex) throws JAXBException, IOException {
		CountryManager cm = new CountryManager();
		String informationPaysXML = cm.obtenirInformationPays((String) ex.getIn().getHeader("COUNTRY"));

		/* if error */
		if(informationPaysXML.equals("")){
			ex.getOut().setHeader("ERROR", "COUNTRY_NOT_FOUND");
		}else{
		/* data */
			ex.getOut().setBody(informationPaysXML);
		}
	
		/* set headers from incoming message */
		ex.getOut().setHeader("COUNTRY", (String) ex.getIn().getHeader("COUNTRY"));

	}
	
}
