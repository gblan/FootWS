
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
 *         &lt;element name="CountryNamesResult" type="{http://footballpool.dataaccess.eu}ArrayOftCountryInfo"/>
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
    "countryNamesResult"
})
@XmlRootElement(name = "CountryNamesResponse")
public class CountryNamesResponse {

    @XmlElement(name = "CountryNamesResult", required = true)
    protected ArrayOftCountryInfo countryNamesResult;

    /**
     * Obtient la valeur de la propriété countryNamesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public ArrayOftCountryInfo getCountryNamesResult() {
        return countryNamesResult;
    }

    /**
     * Définit la valeur de la propriété countryNamesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryInfo }
     *     
     */
    public void setCountryNamesResult(ArrayOftCountryInfo value) {
        this.countryNamesResult = value;
    }

}
