package et5.service;
import java.util.List;

import et5.service.foot.FootService;
import eu.dataaccess.footballpool.Info;

/**
 * CLasse de tests
 */
public class Main {
	
	public static void main(String[] args) {

		FootService fs = new FootService(new Info());
		
		String country = "Germany";
		List<Integer> idPays = fs.getAllMatchesTeam(country);
		System.out.println("Route of '"+country+"' : \n");
		for (int id : idPays) {
			System.out.println(fs.getInfoMatchById(id));
		}
		
		System.out.println(fs.getCountryInformation(country));
	}


}
