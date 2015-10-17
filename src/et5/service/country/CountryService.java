package et5.service.country;

import org.oorsprong.websamples.ArrayOftContinent;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.TContinent;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TLanguage;

public class CountryService {

	private static String NO_COUNTRY_FOUND="No country found by that name";
	
	/**
	 * @param country
	 * @return all information about a country (continent, capital city, phone code, flag, languages)
	 */
	public String getCountryInformation(String country) {
		CountryInfoService cis = new CountryInfoService();
		CountryInfoServiceSoapType portCountry = cis.getCountryInfoServiceSoap();
		
		StringBuilder string = new StringBuilder();

		String code = portCountry.countryISOCode(country);
		if (code.equals(NO_COUNTRY_FOUND))
			return NO_COUNTRY_FOUND;

		TCountryInfo tinfo = portCountry.fullCountryInfo(code);

		string.append("\n Country : " + country);
		String codeContinent = tinfo.getSContinentCode();
		ArrayOftContinent arrayOC = portCountry.listOfContinentsByCode();
		for (TContinent tc : arrayOC.getTContinent()) {
			if (tc.getSCode().equals(codeContinent)) {
				string.append("\n Continent : " + tc.getSName());
				break;
			}
		}

		string.append("\n Capital : " + tinfo.getSCapitalCity());
		string.append("\n Phone code : 00" + tinfo.getSPhoneCode());

		string.append("\n Flag : " + tinfo.getSCountryFlag());
		string.append("\n Language(s) : ");

		for (TLanguage language : tinfo.getLanguages().getTLanguage()) {
			string.append("\n\t " + language.getSName());
		}

		return string.toString();
	}

}
