package et5.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.xml.bind.JAXBException;

import et5.service.foot.FootService;
import eu.dataaccess.footballpool.Info;

/**
 * CLasse de tests
 */
public class Tests {

	public static void main(String[] args) throws AddressException,
			MessagingException, IOException, JAXBException {

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

		FootService fs = new FootService(new Info());
		fs.getInfoMatchById(99);
//		Utils.transformationXML("routeGermany.xml", "routeGermany.html", "resources/displayHTMLroute.xslt");
//		String message = Utils.readFile("resources/example/routeGermany.html", Charset.forName("UTF-8"));
//		Utils.sendHTMLMailUsingSMTPAppliEmail("julien.preisner@u-psud.fr","Objet Message", message);
	}

}
