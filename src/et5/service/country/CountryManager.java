package et5.service.country;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.ws.soap.SOAPFaultException;

import org.oorsprong.websamples.ArrayOftContinent;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.TContinent;
import org.oorsprong.websamples.TCountryCodeAndName;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TLanguage;

import et5.service.country.Country.MeteoLocation;
import et5.service.weather.WeatherManager;
import et5.utils.UtilsIO;
import net.webservicex.GlobalWeather;

public class CountryManager {

	private static String NO_COUNTRY_FOUND="No country found by that name";
	
	/**
	 * @param country
	 * @return String route of a team passed in parameter
	 * @throws JAXBException
	 * @throws IOException
	 */
	public String obtenirInformationPays(String countryName) throws JAXBException, IOException {
		/* first letter uppercase and other letters lowercase*/
		try{
			Country country = getCountryInformation(countryName);
			return UtilsIO.marshalToString("et5.service.country", country);
		}catch(SOAPFaultException e){
			return "";
		}
	}
	
	/**
	 * @param countryName
	 * @return all information about a country (continent, capital city, phone code, flag, languages)
	 */
	private Country getCountryInformation(String countryName) throws IllegalArgumentException{
		Country country = new Country(); 
		CountryInfoService cis = new CountryInfoService();
		CountryInfoServiceSoapType portCountry = cis.getCountryInfoServiceSoap();
		List<TCountryCodeAndName> tmp = portCountry.listOfCountryNamesByName().getTCountryCodeAndName();
		
		for (TCountryCodeAndName tCountryCodeAndName : tmp) {
			System.out.println(tCountryCodeAndName.getSName());
		}
		
		String countryISOCode = portCountry.countryISOCode(countryName);
		if (countryISOCode.equals(NO_COUNTRY_FOUND)){
			throw new IllegalArgumentException("Wrong country Name");
		}

		TCountryInfo tinfo = portCountry.fullCountryInfo(countryISOCode);

		
		String codeContinent = tinfo.getSContinentCode();
		ArrayOftContinent arrayOC = portCountry.listOfContinentsByCode();
		for (TContinent tc : arrayOC.getTContinent()) {
			if (tc.getSCode().equals(codeContinent)) {
				country.setContinent(tc.getSName());
				country.setContinentCode(tinfo.getSContinentCode());
				break;
			}
		}

		country.setCountryName(countryName);
		country.setAdministrativeCapital(tinfo.getSCapitalCity());
		country.setCurrencyExchange(tinfo.getSCurrencyISOCode());
		country.setPhoneCodePrefix(tinfo.getSPhoneCode());
		country.setFlagURL(tinfo.getSCountryFlag());

		for (TLanguage language : tinfo.getLanguages().getTLanguage()) {
			country.getLanguages().add(language.getSName());

		}
		
		/* meteo */
		WeatherManager wm = new WeatherManager(new GlobalWeather());
		MeteoLocation meteo;
		try {
			meteo = wm.getCityWeather(country.getAdministrativeCapital(), countryName);
		} catch (SOAPFaultException | IllegalAccessException e) {
			meteo = new MeteoLocation();
		}
		
		country.setMeteoLocation(meteo);
		
		return country;
	}

}
