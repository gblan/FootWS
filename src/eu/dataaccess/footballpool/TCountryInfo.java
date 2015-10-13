
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tCountryInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tCountryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sIsoCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPersons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCountryInfo", propOrder = {
    "iId",
    "sName",
    "sIsoCode",
    "iPersons"
})
public class TCountryInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sIsoCode;
    protected int iPersons;

    /**
     * Obtient la valeur de la propriété iId.
     * 
     */
    public int getIId() {
        return iId;
    }

    /**
     * Définit la valeur de la propriété iId.
     * 
     */
    public void setIId(int value) {
        this.iId = value;
    }

    /**
     * Obtient la valeur de la propriété sName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSName() {
        return sName;
    }

    /**
     * Définit la valeur de la propriété sName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSName(String value) {
        this.sName = value;
    }

    /**
     * Obtient la valeur de la propriété sIsoCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIsoCode() {
        return sIsoCode;
    }

    /**
     * Définit la valeur de la propriété sIsoCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIsoCode(String value) {
        this.sIsoCode = value;
    }

    /**
     * Obtient la valeur de la propriété iPersons.
     * 
     */
    public int getIPersons() {
        return iPersons;
    }

    /**
     * Définit la valeur de la propriété iPersons.
     * 
     */
    public void setIPersons(int value) {
        this.iPersons = value;
    }

}
