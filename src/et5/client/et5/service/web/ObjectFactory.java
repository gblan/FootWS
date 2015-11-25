package et5.client.et5.service.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the et5.service.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRouteTeamSynchronousResponse_QNAME = new QName("http://web.service.et5/", "getRouteTeamSynchronousResponse");
    private final static QName _GetRouteTeamAsynchronous_QNAME = new QName("http://web.service.et5/", "getRouteTeamAsynchronous");
    private final static QName _GetRouteTeamAsynchronousResponse_QNAME = new QName("http://web.service.et5/", "getRouteTeamAsynchronousResponse");
    private final static QName _GetRouteTeamSynchronous_QNAME = new QName("http://web.service.et5/", "getRouteTeamSynchronous");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: et5.service.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRouteTeamSynchronousResponse }
     * 
     */
    public GetRouteTeamSynchronousResponse createGetRouteTeamSynchronousResponse() {
        return new GetRouteTeamSynchronousResponse();
    }

    /**
     * Create an instance of {@link GetRouteTeamSynchronous }
     * 
     */
    public GetRouteTeamSynchronous createGetRouteTeamSynchronous() {
        return new GetRouteTeamSynchronous();
    }

    /**
     * Create an instance of {@link GetRouteTeamAsynchronousResponse }
     * 
     */
    public GetRouteTeamAsynchronousResponse createGetRouteTeamAsynchronousResponse() {
        return new GetRouteTeamAsynchronousResponse();
    }

    /**
     * Create an instance of {@link GetRouteTeamAsynchronous }
     * 
     */
    public GetRouteTeamAsynchronous createGetRouteTeamAsynchronous() {
        return new GetRouteTeamAsynchronous();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRouteTeamSynchronousResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.et5/", name = "getRouteTeamSynchronousResponse")
    public JAXBElement<GetRouteTeamSynchronousResponse> createGetRouteTeamSynchronousResponse(GetRouteTeamSynchronousResponse value) {
        return new JAXBElement<GetRouteTeamSynchronousResponse>(_GetRouteTeamSynchronousResponse_QNAME, GetRouteTeamSynchronousResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRouteTeamAsynchronous }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.et5/", name = "getRouteTeamAsynchronous")
    public JAXBElement<GetRouteTeamAsynchronous> createGetRouteTeamAsynchronous(GetRouteTeamAsynchronous value) {
        return new JAXBElement<GetRouteTeamAsynchronous>(_GetRouteTeamAsynchronous_QNAME, GetRouteTeamAsynchronous.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRouteTeamAsynchronousResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.et5/", name = "getRouteTeamAsynchronousResponse")
    public JAXBElement<GetRouteTeamAsynchronousResponse> createGetRouteTeamAsynchronousResponse(GetRouteTeamAsynchronousResponse value) {
        return new JAXBElement<GetRouteTeamAsynchronousResponse>(_GetRouteTeamAsynchronousResponse_QNAME, GetRouteTeamAsynchronousResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRouteTeamSynchronous }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.et5/", name = "getRouteTeamSynchronous")
    public JAXBElement<GetRouteTeamSynchronous> createGetRouteTeamSynchronous(GetRouteTeamSynchronous value) {
        return new JAXBElement<GetRouteTeamSynchronous>(_GetRouteTeamSynchronous_QNAME, GetRouteTeamSynchronous.class, null, value);
    }

}
