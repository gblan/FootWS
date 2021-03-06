
package et5.client.web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FootWorldCupService", targetNamespace = "http://web.service.et5/", wsdlLocation = "http://localhost:8090/ws?wsdl")
public class FootWorldCupService
    extends Service
{

    private final static URL FOOTWORLDCUPSERVICE_WSDL_LOCATION;
    private final static WebServiceException FOOTWORLDCUPSERVICE_EXCEPTION;
    private final static QName FOOTWORLDCUPSERVICE_QNAME = new QName("http://web.service.et5/", "FootWorldCupService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8090/ws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FOOTWORLDCUPSERVICE_WSDL_LOCATION = url;
        FOOTWORLDCUPSERVICE_EXCEPTION = e;
    }

    public FootWorldCupService() {
        super(__getWsdlLocation(), FOOTWORLDCUPSERVICE_QNAME);
    }

    public FootWorldCupService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FOOTWORLDCUPSERVICE_QNAME, features);
    }

    public FootWorldCupService(URL wsdlLocation) {
        super(wsdlLocation, FOOTWORLDCUPSERVICE_QNAME);
    }

    public FootWorldCupService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FOOTWORLDCUPSERVICE_QNAME, features);
    }

    public FootWorldCupService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FootWorldCupService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FootWorldCup
     */
    @WebEndpoint(name = "FootWorldCupPort")
    public FootWorldCup getFootWorldCupPort() {
        return super.getPort(new QName("http://web.service.et5/", "FootWorldCupPort"), FootWorldCup.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FootWorldCup
     */
    @WebEndpoint(name = "FootWorldCupPort")
    public FootWorldCup getFootWorldCupPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web.service.et5/", "FootWorldCupPort"), FootWorldCup.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FOOTWORLDCUPSERVICE_EXCEPTION!= null) {
            throw FOOTWORLDCUPSERVICE_EXCEPTION;
        }
        return FOOTWORLDCUPSERVICE_WSDL_LOCATION;
    }

}
