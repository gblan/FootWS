package et5.service;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.oorsprong.websamples.CapitalCity;
import org.oorsprong.websamples.CapitalCityResponse;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.FullCountryInfo;
import org.oorsprong.websamples.FullCountryInfoResponse;

import et5.client.console.ConsoleHTTPClient;
import et5.service.country.CountryService;
import et5.service.foot.FootService;
import eu.dataaccess.footballpool.Info;

/**
 * CLasse de tests
 */
public class Main {
	
	public static void main(String[] args) throws AddressException, MessagingException, IOException {

//		FootService fs = new FootService(new Info());
//		
//		String country = "Germany";
//		List<Integer> idPays = fs.getAllMatchesTeam(country);
//		System.out.println("Route of '"+country+"' : \n");
//		for (int id : idPays) {
//			System.out.println(fs.getInfoMatchById(id));
//		}
//		
//		System.out.println(fs.getCountryInformation(country));
//
//		ConsoleHTTPClient.openDefaultBrowser("https://openclassrooms.com/forum/sujet/ouvrir-une-page-web-54152");
		
		CountryService cs = new CountryService();
		System.out.println(cs.getCountryInformation("Italy"));
		

	}


}
