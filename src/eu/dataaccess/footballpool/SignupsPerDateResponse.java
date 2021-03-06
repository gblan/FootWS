
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignupsPerDateResult" type="{http://footballpool.dataaccess.eu}ArrayOftSignupCount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signupsPerDateResult"
})
@XmlRootElement(name = "SignupsPerDateResponse")
public class SignupsPerDateResponse {

    @XmlElement(name = "SignupsPerDateResult", required = true)
    protected ArrayOftSignupCount signupsPerDateResult;

    /**
     * Obtient la valeur de la propriété signupsPerDateResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public ArrayOftSignupCount getSignupsPerDateResult() {
        return signupsPerDateResult;
    }

    /**
     * Définit la valeur de la propriété signupsPerDateResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public void setSignupsPerDateResult(ArrayOftSignupCount value) {
        this.signupsPerDateResult = value;
    }

}
