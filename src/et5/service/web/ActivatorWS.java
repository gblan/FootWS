package et5.service.web;

import java.util.Hashtable;

import javax.xml.ws.Endpoint;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import et5.service.camel.Service;

public class ActivatorWS implements BundleActivator{
	Endpoint endpoint;
	
	@Override
	public void start(BundleContext context) throws Exception {
		/* JNDI.properties added manually */
		Hashtable<String,String> MYHASH = new Hashtable<String,String>();		
		MYHASH. put("java.naming.factory.initial","org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		MYHASH. put("java.naming.provider.url","tcp://localhost:61616");
		MYHASH.  put("connectionFactoryNames","connectionFactory");
		MYHASH. put("queue.requestQueue","foot.requestQueue");
		MYHASH.  put("queue.responseQueue","foot.responseQueue");
				
//		System.out.println("\n\n MyHASH : "+MYHASH.toString());

		/* put jndi.properties into bundle INFORMATIONS */
		context.registerService(Service.class.getName(), new Service(), MYHASH);

		/* publish WSDL of service */
		FootWorldCup impl = new FootWorldCup();		
		endpoint = Endpoint.create(impl);
		endpoint.publish("http://localhost:8090/ws");
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		endpoint.stop();
	}

}
