
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
 *         &lt;element name="StadiumInfoResult" type="{http://footballpool.dataaccess.eu}tStadiumInfo"/>
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
    "stadiumInfoResult"
})
@XmlRootElement(name = "StadiumInfoResponse")
public class StadiumInfoResponse {

    @XmlElement(name = "StadiumInfoResult", required = true)
    protected TStadiumInfo stadiumInfoResult;

    /**
     * Obtient la valeur de la propriété stadiumInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link TStadiumInfo }
     *     
     */
    public TStadiumInfo getStadiumInfoResult() {
        return stadiumInfoResult;
    }

    /**
     * Définit la valeur de la propriété stadiumInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TStadiumInfo }
     *     
     */
    public void setStadiumInfoResult(TStadiumInfo value) {
        this.stadiumInfoResult = value;
    }

}
