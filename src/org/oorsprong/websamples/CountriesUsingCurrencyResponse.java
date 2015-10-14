
package org.oorsprong.websamples;

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
 *         &lt;element name="CountriesUsingCurrencyResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftCountryCodeAndName"/>
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
    "countriesUsingCurrencyResult"
})
@XmlRootElement(name = "CountriesUsingCurrencyResponse")
public class CountriesUsingCurrencyResponse {

    @XmlElement(name = "CountriesUsingCurrencyResult", required = true)
    protected ArrayOftCountryCodeAndName countriesUsingCurrencyResult;

    /**
     * Obtient la valeur de la propriété countriesUsingCurrencyResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountryCodeAndName }
     *     
     */
    public ArrayOftCountryCodeAndName getCountriesUsingCurrencyResult() {
        return countriesUsingCurrencyResult;
    }

    /**
     * Définit la valeur de la propriété countriesUsingCurrencyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountryCodeAndName }
     *     
     */
    public void setCountriesUsingCurrencyResult(ArrayOftCountryCodeAndName value) {
        this.countriesUsingCurrencyResult = value;
    }

}
