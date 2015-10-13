package et5.service;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;


public class LogginCamel {
	private static final Logger logger = Logger.getLogger(LogginCamel.class); 

	/**
	 * method print exchange
	 * @param exchange
	 */
	public void logginCamel(Exchange ex){
		logger.info("["+ex.getExchangeId()+"] : "+ex.getIn().getBody(String.class));						
	}
}
