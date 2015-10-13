
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tStadiumInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tStadiumInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sStadiumName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iSeatsCapacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sCityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sWikipediaURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGoogleMapsURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tStadiumInfo", propOrder = {
    "sStadiumName",
    "iSeatsCapacity",
    "sCityName",
    "sWikipediaURL",
    "sGoogleMapsURL"
})
public class TStadiumInfo {

    @XmlElement(required = true)
    protected String sStadiumName;
    protected int iSeatsCapacity;
    @XmlElement(required = true)
    protected String sCityName;
    @XmlElement(required = true)
    protected String sWikipediaURL;
    @XmlElement(required = true)
    protected String sGoogleMapsURL;

    /**
     * Obtient la valeur de la propriété sStadiumName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSStadiumName() {
        return sStadiumName;
    }

    /**
     * Définit la valeur de la propriété sStadiumName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSStadiumName(String value) {
        this.sStadiumName = value;
    }

    /**
     * Obtient la valeur de la propriété iSeatsCapacity.
     * 
     */
    public int getISeatsCapacity() {
        return iSeatsCapacity;
    }

    /**
     * Définit la valeur de la propriété iSeatsCapacity.
     * 
     */
    public void setISeatsCapacity(int value) {
        this.iSeatsCapacity = value;
    }

    /**
     * Obtient la valeur de la propriété sCityName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCityName() {
        return sCityName;
    }

    /**
     * Définit la valeur de la propriété sCityName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCityName(String value) {
        this.sCityName = value;
    }

    /**
     * Obtient la valeur de la propriété sWikipediaURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWikipediaURL() {
        return sWikipediaURL;
    }

    /**
     * Définit la valeur de la propriété sWikipediaURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWikipediaURL(String value) {
        this.sWikipediaURL = value;
    }

    /**
     * Obtient la valeur de la propriété sGoogleMapsURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGoogleMapsURL() {
        return sGoogleMapsURL;
    }

    /**
     * Définit la valeur de la propriété sGoogleMapsURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGoogleMapsURL(String value) {
        this.sGoogleMapsURL = value;
    }

}
