package et5.client.jaxws;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import javax.xml.ws.WebServiceException;

import et5.client.web.FootWorldCup;
import et5.client.web.FootWorldCupService;
import et5.utils.Utils;

/**
 * Sites :
 * 
 * http://blog.netapsys.fr/conception-dun-modele-client-serveur-avec-jax-ws/
 * http://www.jmdoudoux.fr/java/dej/chap-service-web.htm
 * https://www-01.ibm.com/support/knowledgecenter/SSEQTP_8.5.5///com.ibm.
 * websphere.nd.multiplatform.doc/ae/twbs_jmsasyncresplistener.html
 * https://docs.oracle.com/middleware/1213/wls/WSGET/jax-ws-jmstransport.htm#
 * WSGET3638
 * http://www.mastertheintegration.com/camel/camel-and-web-services/calling-a-
 * jax-ws-web-service-from-camel.html
 * 
 */
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
		try{
			fwcs = new FootWorldCupService();
			port = fwcs.getFootWorldCupPort();
		}catch(WebServiceException e){
			System.err.println("Impossible de se connecter au web service FootWorldCupService : "+e.getMessage());
		}
		while (true) {
			// 1. Demande ce que souhaite faire l'utilisateur
			System.out.println(
					"Web service permettant d'obtenir le parcours d'une equipe nationale durant la Coupe du Monde 2014");

			// 2. Demande le pays
			System.out.println("Entrez le pays (en Anglais):");
			country = scanner.nextLine().trim();

			// 3. Ajoute les elements necessaires pour distinguer le choix de
			// l'utilisateur
			System.out.println("Veuillez maintenant choisir le mode de réception");
			System.out.println("Pour le mode synchrone (réception par file JMS puis affichage navigateur), tapez 1");
			System.out.println("Pour le mode asynchrone (réception par e-mail), tapez 2");
			int choix = Integer.parseInt(scanner.nextLine().trim());
			if (choix == 1) {
				
				/* afficher l'xml dans une page web avec le xslt */
				ClientJaxWS.transformAndDisplayRouteTeam(port.getRouteTeamSynchronous(country),country);
			
			} else if (choix == 2) {
				System.out.println("Veuillez saisir votre e-mail :");
				String mail = scanner.nextLine().trim();
				
				/* valeur de retour de la methode */
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

			} else {
				System.out.println("Erreur dans la saisie!");

			}

			System.out.println("Pour arreter le programme : tapez 'quit'");
			System.out.println("Pour obtenir un nouveau parcours d'équipe, saisir : tapez 'Entrer'");
			msg = scanner.nextLine().trim();
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
	 * Open the user default browser and go to the url passed as a parameter
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
			Utils.transformXMLStringintoHTMLFile(xmlContent, temp.getAbsolutePath());
			openDefaultBrowser(temp);
			
		} catch (Exception e) {
			System.err.println("Impossible to transform and display the route team. " + e.getMessage());
		} finally {
			if(temp != null)
				temp.deleteOnExit();	// delete the file when the JVM terminates itself
		}
	}
	
}