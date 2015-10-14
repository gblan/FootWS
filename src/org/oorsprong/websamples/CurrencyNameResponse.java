
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
 *         &lt;element name="CurrencyNameResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "currencyNameResult"
})
@XmlRootElement(name = "CurrencyNameResponse")
public class CurrencyNameResponse {

    @XmlElement(name = "CurrencyNameResult", required = true)
    protected String currencyNameResult;

    /**
     * Obtient la valeur de la propriété currencyNameResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyNameResult() {
        return currencyNameResult;
    }

    /**
     * Définit la valeur de la propriété currencyNameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyNameResult(String value) {
        this.currencyNameResult = value;
    }

}
