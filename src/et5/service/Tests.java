package et5.service;

import java.util.Scanner;

import javax.xml.ws.Endpoint;

import et5.service.web.FootWorldCup;

/**
 * CLasse de tests
 */
public class Tests {

//	public static void main(String[] args) throws IOException{
//			MessagingException, IOException, JAXBException {

		// FootService fs = new FootService(new Info());
		//
		// String country = "Germany";
		// List<Integer> idPays = fs.getAllMatchesTeam(country);
		// System.out.println("Route of '"+country+"' : \n");
		// for (int id : idPays) {
		// System.out.println(fs.getInfoMatchById(id));
		// }
		//
		// System.out.println(fs.getCountryInformation(country));
		//
		// ConsoleHTTPClient.openDefaultBrowser("https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152");

//		CountryService cs = new CountryService();
//		System.out.println(cs.getCountryInformation("Italy"));
		// FootService fs = new FootService(new Info());
		//
		// String country = "Germany";
		// List<Integer> idPays = fs.getAllMatchesTeam("Germany");
		// System.out.println("Route of '" + country + "' : \n");
		// for (int id : idPays) {
		// Match x = fs.getInfoMatchById(id);
		// System.out.println(x);
		// }
		//
		// System.out.println(fs.getCountryRoute(country));
//		Service serv = new Service();
//		serv.obtenirParcours(null);

//		FootServiceManager fs = new FootServiceManager(new Info());
//		fs.getInfoMatchById(99);
//		String route = Utils.fileToString("resources/example/routeGermany.xml");
//		System.out.println(route);
//		
//		Utils.transformationXMLFromString(route, "resources/example/routeGermany.html", "resources/displayHTMLroute.xslt");
//		Utils.transformationXMLFromFile("resources/example/routeGermany.xml", "resources/example/routeGermany.html", "resources/displayHTMLroute.xslt");
//		String message = Utils.readFile("resources/example/routeGermany.html", Charset.forName("UTF-8"));
//		Utils.sendHTMLMailUsingSMTPAppliEmail("julien.preisner@u-psud.fr","Objet Message", message);
//	}
	
	/* pour lancer le ws local (route) */
	public static void main(String[] args) {
		FootWorldCup impl = new FootWorldCup();		
		Endpoint endpoint = Endpoint.create(impl);
		
		endpoint.publish("http://localhost:8090/ws");
		
		System.err.println("Saisir (car + return) pour arreter le endpoint ");	
		Scanner sc = new Scanner(System.in);
		sc.next();
		
		endpoint.stop();
		System.out.println("Endpoint stopp� !");
		sc.close();
	}

}
