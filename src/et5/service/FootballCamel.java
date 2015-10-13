package et5.service;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;

public class FootballCamel {
	private static final Logger logger = Logger.getLogger(FootballCamel.class);

	/**
	 * method get TeamRouteCamel
	 * @param exchange
	 */
	public void getTeamRouteCamel(Exchange ex) {
		Info info = new Info();
		InfoSoapType soap = info.getInfoSoap();
		
	}
}
