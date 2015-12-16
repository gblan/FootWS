package et5.service.web;

import java.io.File;

import javax.xml.ws.Endpoint;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ActivatorWS implements BundleActivator{
	Endpoint endpoint;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("\n\n COUCOU \n\n");
		//System.out.println(new File("deploy/jndi.properties").exists());
		FootWorldCup impl = new FootWorldCup();		
		endpoint = Endpoint.create(impl);
		endpoint.publish("http://localhost:8090/ws");
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		endpoint.stop();
	}

}
