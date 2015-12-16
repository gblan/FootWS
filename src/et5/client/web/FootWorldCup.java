
package et5.client.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FootWorldCup", targetNamespace = "http://web.service.et5/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FootWorldCup {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRouteTeamSynchronous", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetRouteTeamSynchronous")
    @ResponseWrapper(localName = "getRouteTeamSynchronousResponse", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetRouteTeamSynchronousResponse")
    @Action(input = "http://web.service.et5/FootWorldCup/getRouteTeamSynchronousRequest", output = "http://web.service.et5/FootWorldCup/getRouteTeamSynchronousResponse")
    public String getRouteTeamSynchronous(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCountryInformation", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetCountryInformation")
    @ResponseWrapper(localName = "getCountryInformationResponse", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetCountryInformationResponse")
    @Action(input = "http://web.service.et5/FootWorldCup/getCountryInformationRequest", output = "http://web.service.et5/FootWorldCup/getCountryInformationResponse")
    public String getCountryInformation(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "getRouteTeamAsynchronous", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetRouteTeamAsynchronous")
    @ResponseWrapper(localName = "getRouteTeamAsynchronousResponse", targetNamespace = "http://web.service.et5/", className = "et5.service.web.GetRouteTeamAsynchronousResponse")
    @Action(input = "http://web.service.et5/FootWorldCup/getRouteTeamAsynchronousRequest", output = "http://web.service.et5/FootWorldCup/getRouteTeamAsynchronousResponse")
    public void getRouteTeamAsynchronous(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
