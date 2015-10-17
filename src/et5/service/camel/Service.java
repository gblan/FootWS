package et5.service.camel;

import javax.mail.MessagingException;

import org.apache.camel.Exchange;

import et5.service.utils.Utils;

public class Service {
	
	public void obtenirParcours(Exchange ex){
		/*
		Info info = new Info();
		InfoSoapType soap = info.getInfoSoap();
		*/
		
		// 1. Récupérer le pays dans 'ex'
			// 1.bis Récupérer le mail si il est présent
		// 2. Faire appel a la méthode obtenirParcours(pays) dans FootballService.java
		// 3. Mettre l'XML dans 'ex'
			// 3.bis : remettre le mail dans 'ex'
	}
	
	public void envoiEmail(Exchange ex){
		// 1. Récupérer le @email et l'XML dans 'ex'
		String to = "";
		String subject = "";
		
		// 2. Transformer l'XML -> HTML (.xslt)
		String message = "";
		
		try {
			Utils.sendSMTPMailUsingAppliEmail(to, subject, message);
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
