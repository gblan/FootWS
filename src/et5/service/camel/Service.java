package et5.service.camel;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;

import et5.service.foot.FootService;
import et5.service.utils.Utils;
import eu.dataaccess.footballpool.Info;

public class Service {
	
	public void obtenirParcours(Exchange ex) throws JAXBException{
		// 1. Récupérer le pays dans 'ex'
		// 2. Faire appel a la méthode obtenirParcours(pays) dans FootballService.java
		// 3. Mettre l'XML dans 'ex'
		JAXBContext context = JAXBContext.newInstance("et5.service.route");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Info info = new Info();
		FootService fs = new FootService(info);

	}
	
	public void envoiEmail(Exchange ex){
		// 1. Récupérer le @email et l'XML dans 'ex'
		String to = (String) ex.getIn().getHeader("TO");
		String subject = (String) ex.getIn().getHeader("SUBJECT");
		
		// 2. Transformer l'XML -> HTML (.xslt)
		String message = "";
		
		try {
			Utils.sendHTMLMailUsingSMTPAppliEmail(to, subject, message);
			// Ecrire XML en disant que l'envoi du mail a reussi
		} 
		catch (MessagingException e) {
			// Ecrire XML en disant que l'envoi du mail a échoué
		}
		// Mettre l'XML dans 'ex'
	}
	
	
	public void afficherCarte(Exchange ex){
		// 1. Récupérer la ville dans 'ex'
		// 2. Faire appel a la méthode afficherCarte(ville) dans FootballService.java
		// 3. Modifier ex pour retourner un XML qui contient l'URI (?)
	}
}
