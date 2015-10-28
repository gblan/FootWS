package et5.service.camel;

import java.net.URI;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;

import et5.service.foot.FootService;
import et5.service.route.Route;
import et5.service.utils.Utils;
import eu.dataaccess.footballpool.Info;

public class Service {

	public void obtenirParcours(Exchange ex) throws JAXBException{
		// 1. Recuperer le pays dans 'ex'
		String pays = (String) ex.getIn().getHeader("COUNTRY");

		JAXBContext context = JAXBContext.newInstance("et5.service.route");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// 2. Faire appel a la methode obtenirParcours(pays) dans FootballService.java
		Info info = new Info();
		FootService fs = new FootService(info);

		/**
		 * TODO : lequel des 2?
		 */
		
		// Solution 1 ?
		String parcoursPaysXML = fs.obtenirParcours(pays);
		// 3. Mettre l'XML dans 'ex'
		ex.getOut().setBody(parcoursPaysXML); 

		// Solution 2 ?
		Route route = fs.getCountryRoute(pays);
		// 3. Mettre l'XML dans 'ex'
		ex.getOut().setBody(route);

		/* 
		 * TODO : modifier l'id de ex?
		 * Ex :
		 * ((JmsMessage)e.getOut()).getJmsMessage().setJMSCorrelationID(message.getMessageId());
		 */
	}

	/**
	 * A l'image de Route.java et des fichiers xslt et xsd, faire la meme pour un type
	 *  de message XML qui indique juste si tout s'est bien passe ou pas???
	 * @param ex
	 */
	public void envoiEmail(Exchange ex){
		// 1. Récupérer le @email et l'XML dans 'ex'
		String to = (String) ex.getIn().getHeader("TO");
		String subject = (String) ex.getIn().getHeader("SUBJECT");

		// 2. Transformer l'XML -> HTML (.xslt)
		String messageHTML = "";

		String responseXML = "";
		try {
			Utils.sendHTMLMailUsingSMTPAppliEmail(to, subject, messageHTML);
			// Ecrire XML en disant que l'envoi du mail a reussi
			responseXML = "ok";	// TODO
		} 
		catch (MessagingException e) {
			// Ecrire XML en disant que l'envoi du mail a echoue
			responseXML = "not ok"; // TODO
		}

		// 3. Mettre l'XML dans 'ex'
		ex.getOut().setBody(responseXML); 
		/* 
		 * TODO : modifier l'id de ex?
		 * Ex :
		 * ((JmsMessage)e.getOut()).getJmsMessage().setJMSCorrelationID(message.getMessageId());
		 */
	}


	/**
	 * A l'image de Route.java, faire en sorte d'avoir un xslt, xsd et une classe java 
	 * qui correspond a l'envoi XML de l'URI pour afficher la carte sur google maps???
	 * @param ex
	 */
	public void afficherCarte(Exchange ex){
		// 1. Récupérer la ville dans 'ex'
		String ville = (String) ex.getIn().getHeader("CITY");

		// 2. Faire appel a la méthode afficherCarte(ville) dans FootballService.java
		Info info = new Info();
		FootService fs = new FootService(info);
		URI uri = fs.afficherCarte(ville);

		// 3. Modifier ex pour retourner un XML qui contient l'URI (?)
		String responseXML = uri.toString();	// TODO : mettre l'URI dans l'XML
		ex.getOut().setBody(responseXML); 
		/* 
		 * TODO : modifier l'id de ex?
		 * Ex :
		 * ((JmsMessage)e.getOut()).getJmsMessage().setJMSCorrelationID(message.getMessageId());
		 */
	}
}
