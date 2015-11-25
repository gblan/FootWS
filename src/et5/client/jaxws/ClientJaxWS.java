package et5.client.jaxws;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

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

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String msg;
		String city;

		//FootServiceService s = new FootServiceService();
		// port = s.getFootServicePort();

		while (true) {
			// 1. Demande ce que souhaite faire l'utilisateur
			System.out.println("Web service permettant d'obtenir le parcours d'une equipe nationale durant la Coupe du Monde 2014");
			System.out.println("Pour arreter le programme : tapez 'quit'");
			msg = scanner.nextLine().trim();
			if (msg.equals("quit")) {
				break;
			}

			// 2. Demande le pays
			System.out.println("Entrez le pays (en Anglais):");
			city = scanner.nextLine().trim();

			// 3. Ajoute les elements necessaires pour distinguer le choix de
			// l'utilisateur
			System.out.println("Veuillez maintenant choisir le mode de réception");
			System.out.println("Pour le mode synchrone (réception par file JMS puis affichage navigateur), tapez 1");
			System.out.println("Pour le mode asynchrone (réception par e-mail), tapez 2");
			int choix = Integer.parseInt(scanner.nextLine().trim());
			if (choix == 1) {
				/* FIXME afficher l'xml dans une page web avec le xslt */
				//port.getRouteTeamSynchronous(city);

			} else if (choix == 2) {
				System.out.println("Veuillez saisir votre e-mail :");
				String mail = scanner.nextLine().trim();
				/* FIXME valeur de retour de la methode */
				//port.getRouteTeamAsynchronous(city, mail);

			} else {
				System.out.println("Erreur dans la saisie!");

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
}