package et5.client.console;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class ConsoleHTTPClient {
	
	private void connect(){
		
	}
	
	private void sendRequest(){
		Scanner scanner = new Scanner(System.in);
		String msg;
		
		while(true) {
			System.out.println("Entrer le nom d'une equipe nationale pour obtenir son parcours lors "
					+ "de la Coupe du Monde de Football 2014 (QUIT pour arreter) :");
			msg = scanner.nextLine();
			
			if (msg.equals("QUIT")) {
				break;
			}
			
			// TODO : transmettre la requete http
			
			System.out.println(" >> Requete envoyee,  ID = ");
		}
		scanner.close();
	}
	
	private void readResponse(){
		System.out.println(">> Reponse obtenue, requete correlID: --> ");
		// Afficher le parcours
		// Ouvrir le navigateur web par defaut avec l'URL de google maps renvoye
		// attention : difference entre unix/windows : gerer les 2 cas
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
			ConsoleHTTPClient client = new ConsoleHTTPClient();
			client.connect();
			client.readResponse();
			client.sendRequest();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
