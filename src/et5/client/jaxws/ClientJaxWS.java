package et5.client.jaxws;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Scanner;

/** Sites : 
 * 
 * http://blog.netapsys.fr/conception-dun-modele-client-serveur-avec-jax-ws/
 * http://www.jmdoudoux.fr/java/dej/chap-service-web.htm
 * https://www-01.ibm.com/support/knowledgecenter/SSEQTP_8.5.5///com.ibm.websphere.nd.multiplatform.doc/ae/twbs_jmsasyncresplistener.html
 * https://docs.oracle.com/middleware/1213/wls/WSGET/jax-ws-jmstransport.htm#WSGET3638
 * http://www.mastertheintegration.com/camel/camel-and-web-services/calling-a-jax-ws-web-service-from-camel.html
 * 
 *
 */
public class ClientJaxWS {
	//private ConnectionFactory connectionFactory;

	private void connect() throws MalformedURLException{
		
        // URL wsdlLocation = new URL("http://localhost:8585/DemoService?wsdl");
		
		/*
		// Creation d'un contexte JNDI
		Context jndiContext = new InitialContext();

		// Lookup de la fabrique de connexion et de la destination
		connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");
		*/

	}
	
	private void sendRequest(){
		Scanner scanner = new Scanner(System.in);
		String msg;
		
		while(true) {
			// 1. Demande ce que souhaite faire l'utilisateur
			System.out.println("Pour obtenir le parcours d'une equipe nationale durant la Coupe du Monde 2014 : tapez 1");
			System.out.println("Pour afficher la carte d'une ville : tapez 2");
			System.out.println("Pour arreter le programme : tapez 'QUIT'");
			msg = scanner.nextLine().trim();
	
			if (msg.toLowerCase().equals("quit"))
				break;
			
			if (msg.equals("1")){
				// 2. Demande le pays
				System.out.println("Entrez le pays :");
				msg = scanner.nextLine().trim();
				
				// 3. Ajoute les elements necessaires pour distinguer le choix de l'utilisateur

			}
			else if (msg.equals("2")){
				// 2. Demande la ville
				msg = scanner.nextLine().trim();

				// 3. Ajoute les elements necessaires pour distinguer le choix de l'utilisateur
			}
			
			// 4. Envoi le message
			
			System.out.println(">> Requete envoyee : ID=[]");
		} 
		scanner.close();
		System.out.println("Bye !");
	}
	
	private void readResponse(){
		System.out.println(">> Reponse obtenue : ID=[]");
		
		// 1. Transforme l'element recu (XML) en HTML
		
		// 2. Ouvre l'element recu (HTML) dans le navigateur par defaut de l'utilisateur
		try {
			openDefaultBrowser("");
			System.out.println("Ouverture du navigateur par defaut OK");
		} catch (Exception e) {
			System.err.println("Impossible d'ouvrir l'element HTML dans le navigateur par defaut. " + e.getMessage());
		}
		
	}
	
	/**
	 * Open the user default browser and go to the url passed as a parameter
	 * Tested on Windows 7, 8, Ubuntu
	 * https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152
	 * @param url
	 * @throws IOException
	 */
	public static void openDefaultBrowser(String url) throws IOException{
		URI uri = URI.create(url);
		Desktop.getDesktop().browse(uri);
	}
	
	public static void main(String[] args) throws IOException {
		try {
			ClientJaxWS client = new ClientJaxWS();
			client.connect();
			client.readResponse();
			client.sendRequest();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}