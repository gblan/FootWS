package et5.service.camel;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

public class Log {
	private static final Logger logger = Logger.getLogger(Log.class); 

	/**
	 * Log exchange
	 * @param exchange
	 */
	public void log(Exchange ex){
		logger.info("["+ex.getExchangeId()+"] : "+ex.getIn().getBody(String.class));
		/* transfers informations in logging */
		ex.getOut().setBody(ex.getIn().getBody());
		ex.getOut().setHeaders(ex.getIn().getHeaders());
	}
}
