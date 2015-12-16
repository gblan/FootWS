package et5.service.weather;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import et5.service.country.Country.MeteoLocation;
import et5.utils.UtilsIO;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class WeatherManager {
	
	/* parameters for wsdl acces */
	private GlobalWeatherSoap soap;

	/**
	 * @param info
	 * Constructor need info parameter for wsdl access
	 */
	public WeatherManager(GlobalWeather gw) {
		this.soap = gw.getGlobalWeatherSoap();
	}
	
	/**
	 * @param country
	 * @return all city where there is a meteo station in the param country
	 */
	public List<String> getListCityInCountry(String country){
		List<String> listCity = new ArrayList<>();
		String xmlCities = soap.getCitiesByCountry(country);
		Document doc = UtilsIO.loadXML(xmlCities);		
		
		NodeList nodeList = doc.getDocumentElement().getElementsByTagName("City");
		for(int i=0;i<nodeList.getLength();i++){
			listCity.add(nodeList.item(i).getTextContent());
		}
		return listCity;
	}
	
	/**
	 * @param city
	 * @return weather in a city 
	 * @throws IllegalAccessException 
	 */
	public MeteoLocation getCityWeather(String city, String country) throws SOAPFaultException, IllegalAccessException {
		MeteoLocation meteoLocation = new MeteoLocation();
		boolean cityFound = false;
		String xmlWeather = soap.getWeather(city, country);
		if(xmlWeather.equals("Data Not Found")){
			List<String> listCityCountry = getListCityInCountry(country);
			for (String cityList : listCityCountry) {
				if(cityList.contains(city) || cityList.contains(city.substring(0, 3))){
					city = cityList;
					cityFound = true;
					break;
				}
			}
			
			if(!cityFound && listCityCountry.size()>0){
				city = listCityCountry.get(0);
			}else{
				throw new IllegalAccessException("No weather available");
			}

			xmlWeather = soap.getWeather(city, country);
			
			if(xmlWeather.equals("Data Not Found")){
				xmlWeather = soap.getWeather(listCityCountry.get(0), country);
			}
		}
		System.out.println(xmlWeather);
		Document doc = UtilsIO.loadXML(xmlWeather);		

		meteoLocation.setLocation(doc.getElementsByTagName("Location").item(0).getTextContent());
		meteoLocation.setTime(doc.getElementsByTagName("Time").item(0).getTextContent());
		meteoLocation.setWind(doc.getElementsByTagName("Wind").item(0).getTextContent());
		if(doc.getElementsByTagName("SkyConditions").item(0) != null){
			meteoLocation.setSkyConditions(doc.getElementsByTagName("SkyConditions").item(0).getTextContent());
		}
		meteoLocation.setRelativeHumidity(doc.getElementsByTagName("RelativeHumidity").item(0).getTextContent());
		meteoLocation.setTemperature(doc.getElementsByTagName("Temperature").item(0).getTextContent());
		
		return meteoLocation;
	}
	
}
