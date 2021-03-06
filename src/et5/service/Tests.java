package et5.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Endpoint;

import org.oorsprong.websamples.ArrayOftLanguage;
import org.oorsprong.websamples.CapitalCity;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.TCountryInfo;

import et5.service.foot.FootServiceManager;
import et5.service.route.Route;
import et5.service.web.FootWorldCup;
import et5.utils.UtilsIO;
import et5.utils.UtilsMail;

/**
 * CLasse de tests
 */
public class Tests {

//	public static void main(String[] args) throws IOException, JAXBException, AddressException, MessagingException{

//		 FootServiceManager fs = new FootServiceManager(new Info());
//		//
//		 String country = "Germany";
//		Route r = fs.getCountryRoute(country);
//		System.out.println(UtilsIO.marshalToString("et5.service.route", r));
//
//
//		String route = UtilsIO.fileToString("resources/example/routeGermany.xml");
//		System.out.println(route);
//		System.out.println(UtilsIO.routeTransformXMLStringIntoHTMLString(UtilsIO.fileToString("resources/example/routeGermany.xml")));
//		UtilsIO.transformXMLFileintoHTMLFile("resources/example/routeGermany.xml", "resources/example/routeGermany.html", "resources/displayHTMLroute.xslt");
//		String message = UtilsIO.readFile("resources/example/routeGermany.html", Charset.forName("UTF-8"));
//		UtilsMail.sendHTMLMailUsingSMTPAppliEmail("julien.preisner@u-psud.fr","Objet Message", message);
//	}
	
	/* pour lancer le ws local (route) */
	public static void main(String[] args) {
		FootWorldCup impl = new FootWorldCup();		
		Endpoint endpoint = Endpoint.create(impl);
		
		endpoint.publish("http://localhost:8090/ws");
		
		System.err.println("Saisir (char + return) pour arreter le endpoint ");	
		Scanner sc = new Scanner(System.in);
		try{
			sc.next();
		}catch(NoSuchElementException e){
			
		}finally {
			endpoint.stop();
			System.out.println("Endpoint stoppe !");
			sc.close();			
		}

	}
	
}
