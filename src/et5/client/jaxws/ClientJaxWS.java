package et5.client.jaxws;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import javax.xml.ws.WebServiceException;

import et5.client.web.FootWorldCup;
import et5.client.web.FootWorldCupService;
import et5.utils.UtilsIO;

public class ClientJaxWS {
	protected static final String RESPONSE_TYPE = "responseType";
	private static final int MAIL_FORMAT_ERROR = 1;
	private static final int MAIL_TRANSPORT_ERROR = 2;
	private static final int CORRECT_SEND = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String msg;
		String country;

		/* Appel des méthodes du web service*/
		FootWorldCupService fwcs;
		FootWorldCup port = null;
		
		// Tentative de connexion au WS 'FootWorldCupService'
		try{
			fwcs = new FootWorldCupService();
			port = fwcs.getFootWorldCupPort();
		}
		catch(WebServiceException e){
			System.err.println("Impossible de se connecter au web service FootWorldCupService : "+e.getMessage());
			System.exit(-1);
		}
		
		System.out.println("Connexion au Web Service 'FootWorldCupService' réussie.");
		System.out.println("==================================================================================================");
		System.out.println("Web service permettant d'obtenir le parcours d'une equipe nationale durant la Coupe du Monde 2014");
		System.out.println("==================================================================================================");
		
		while (true) {
			// 1. Demande le pays
			System.out.println("Saisir un pays (en Anglais) :");
			country = scanner.nextLine().trim().toLowerCase();

			// 2. Ajoute les elements necessaires pour distinguer le choix de l'utilisateur
			System.out.println("Veuillez maintenant choisir le mode de réception :");
			System.out.println("   Pour le mode synchrone (réception par file JMS puis affichage navigateur) \t Tapez 1");
			System.out.println("   Pour le mode asynchrone (réception par e-mail) \t\t Tapez 2");
			int choix = Integer.parseInt(scanner.nextLine().trim());
			
			// Affiche le resultat dans le navigateur web (page HTML)
			if (choix == 1) {
				ClientJaxWS.transformAndDisplayRouteTeam(port.getRouteTeamSynchronous(country),country);
			
			} 
			// Envoie le resultat par mail
			else if (choix == 2) {
				System.out.println("Veuillez saisir votre e-mail :");
				String mail = scanner.nextLine().trim();
				
				/* valeur de retour de la methode */
				//FIXME, voir si on renvoie qq chose ou pas
				switch (port.getRouteTeamAsynchronous(country, mail)) {
					case CORRECT_SEND:
						System.out.println("envoi de la réponse effectué, veuillez consulter votre boite de reception ("+mail+")");
						break;	
					case MAIL_FORMAT_ERROR:
						System.out.println("mauvais format de l'e-mail, veuillez réessayer");
						break;
					case MAIL_TRANSPORT_ERROR:
						System.out.println("erreur de transmission de l'e-mail, veuillez réessayer");
						break;
				
					default:
						break;
				}

			} 
			else {
				System.out.println("Erreur dans la saisie! Veuillez saisir 1 ou 2.");
			}

			System.out.println("Pour arreter le programme : tapez 'quit'");
			msg = scanner.nextLine().trim().toLowerCase();
			if (msg.equals("quit")) {
				break;
			}
		}
		scanner.close();
	}

	/**
	 * Open the user default browser and go to the url passed as a parameter
	 * Tested on Windows 7, 8, Ubuntu, MacOS
	 * https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152
	 * 
	 * @param url
	 * @throws IOException
	 */
	public static void openDefaultBrowser(String url) throws IOException {
		URI uri = URI.create(url);
		Desktop.getDesktop().browse(uri);
	}
	
	/**
	 * Open the user default browser and go to the url of the file passed as a parameter
	 * Tested on Windows 7, 8, Ubuntu, MacOS
	 * https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152
	 * 
	 * @param url
	 * @throws IOException
	 */
	public static void openDefaultBrowser(File file) throws IOException {
		Desktop.getDesktop().browse(file.toURI());
	}
	
	
	
	/**
	 * The XML content passed as a parameter is transformed into HTML content and
	 * displayed in the default web browser of the user
	 * 
	 * @param xmlContent
	 * @param country used in the temporary file name
	 */
	public static void transformAndDisplayRouteTeam(String xmlContent, String country){
		File temp = null;
		try {
			temp = File.createTempFile("result-" + country, ".html");
			UtilsIO.transformXMLStringintoHTMLFile(xmlContent, temp.getAbsolutePath());
			openDefaultBrowser(temp);
			
		} catch (Exception e) {
			System.err.println("Impossible to transform and display the route team. " + e.getMessage());
		} finally {
			if(temp != null)
				temp.deleteOnExit();	// delete the file when the JVM terminates itself
		}
	}
	
}