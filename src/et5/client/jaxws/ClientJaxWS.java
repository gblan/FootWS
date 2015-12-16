package et5.client.jaxws;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.NoSuchElementException;
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
		String msg = "";
		String country;

		/* Appel des methodes du web service */
		FootWorldCupService fwcs;
		FootWorldCup port = null;

		// Tentative de connexion au WS 'FootWorldCupService'
		try {
			fwcs = new FootWorldCupService();
			port = fwcs.getFootWorldCupPort();
		} catch (WebServiceException e) {
			System.err.println("Impossible de se connecter au web service FootWorldCupService : " + e.getMessage());
			scanner.close();
			System.exit(-1);
		}

		System.out.println("Connexion au Web Service 'FootWorldCupService' reussie.");
		System.out.println(
				"==================================================================================================");
		System.out.println(
				"Web service permettant d'obtenir le parcours d'une equipe nationale durant la Coupe du Monde 2014");
		System.out.println(
				"==================================================================================================");

		try {
			while (true) {
				// 1. Demande le pays
				System.out.println("Saisir un pays (en Anglais) :");
				String countryInput = scanner.nextLine().trim().toLowerCase();
				country = countryInput.substring(0, 1).toUpperCase() + countryInput.substring(1).toLowerCase();
				// 2. Ajoute les elements necessaires pour distinguer le choix
				// de l'utilisateur
				System.out.println("Veuillez maintenant choisir le mode de reception :");
				System.out.println("\tPour le mode synchrone (reception par file JMS puis affichage navigateur) \t Tapez 1");
				System.out.println("\tPour le mode asynchrone (reception par e-mail) \t\t Tapez 2");
				System.out.println("\tPour obtenir uniquement des informations sur le pays \t\t Tapez 3");
				int choix = Integer.parseInt(scanner.nextLine().trim());

				// Affiche le resultat dans le navigateur web (page HTML)
				if (choix == 1) {
					String htmlPage = port.getRouteTeamSynchronous(country);
					if (htmlPage.equals("")) {
						System.out.println("Le pays '" + country
								+ "' n'est pas disponible, veuillez saisir le nom du pays (en anglais) ayant participe a la coupe du monde 2014");
					} else {
						ClientJaxWS.transformAndDisplayRouteTeam(htmlPage, country);
					}
				}
				// Envoie le resultat par mail
				else if (choix == 2) {
					System.out.println("Veuillez saisir votre e-mail :");

					/* repositionnement du buffer en debut de ligne */
					scanner.reset();
					/* lecture de la donnee */
					String mail = scanner.nextLine().trim();

					/* valeur de retour de la methode */
					// FIXME, voir si on renvoie qq chose ou pas
					port.getRouteTeamAsynchronous(country, mail);
//					int t = port.getRouteTeamAsynchronous(country, mail);
//					switch (t) {
//					case CORRECT_SEND:
//						System.out.println("envoi de la reponse effectue, veuillez consulter votre boite de reception ("
//								+ mail + ")");
//						break;
//					case MAIL_FORMAT_ERROR:
//						System.out.println("mauvais format de l'e-mail, veuillez reessayer");
//						break;
//					case MAIL_TRANSPORT_ERROR:
//						System.out.println("erreur de transmission de l'e-mail, veuillez reessayer");
//						break;
//
//					default:
//						break;
//					}
					System.out.println("envoi de la reponse effectue, veuillez consulter votre boite de reception ("
					+ mail + ")");
				} else if(choix == 3){
					String htmlPage = port.getCountryInformation(country);
					if (htmlPage.equals("")) {
						System.out.println("Le pays '" + country
								+ "' n'est pas disponible, veuillez saisir le nom du pays (en anglais) ayant participe a la coupe du monde 2014");
					} else {
						ClientJaxWS.transformAndDisplayCountryInformation(htmlPage, country);
					}
				} else {
					System.out.println("Erreur dans la saisie! Veuillez saisir 1 ou 2.");
				}

				System.out.println("Pour arreter le programme : tapez 'quit'");
				System.out.println("Pour faire une nouvelle recherche, saisissez n'importe quoi d'autre");

				msg = scanner.nextLine().trim().toLowerCase();

				if (msg.equals("quit")) {
					break;
				}
			}
		} catch (NoSuchElementException e) {
		} finally {
			System.err.println("Fin du programme.");
			scanner.close();
			System.exit(-1);
		}
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
	 * Open the user default browser and go to the url of the file passed as a
	 * parameter Tested on Windows 7, 8, Ubuntu, MacOS
	 * https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152
	 * 
	 * @param url
	 * @throws IOException
	 */
	public static void openDefaultBrowser(File file) throws IOException {
		Desktop.getDesktop().browse(file.toURI());
	}

	/**
	 * The XML content passed as a parameter is transformed into HTML content
	 * and displayed in the default web browser of the user
	 * 
	 * @param xmlContent
	 * @param country
	 *            used in the temporary file name
	 */
	public static void transformAndDisplayRouteTeam(String xmlContent, String country) {
		File temp = null;
		try {
			temp = File.createTempFile("result-" + country, ".html");
			UtilsIO.routeTransformXMLStringintoHTMLFile(xmlContent, temp.getAbsolutePath());
			openDefaultBrowser(temp);

		} catch (Exception e) {
			System.err.println("Impossible to transform and display the route team. " + e.getMessage());
		} finally {
			if (temp != null)
				temp.deleteOnExit(); // delete the file when the JVM terminates
										// itself
		}
	}
	

	private static void transformAndDisplayCountryInformation(String xmlContent, String country) {
		File temp = null;
		try {
			temp = File.createTempFile("infos-" + country, ".html");
			UtilsIO.countryInfosTransformXMLStringintoHTMLFile(xmlContent, temp.getAbsolutePath());
			openDefaultBrowser(temp);

		} catch (Exception e) {
			System.err.println("Impossible to transform and display the route team. " + e.getMessage());
		} finally {
			if (temp != null)
				temp.deleteOnExit(); // delete the file when the JVM terminates
										// itself
		}
	}

}