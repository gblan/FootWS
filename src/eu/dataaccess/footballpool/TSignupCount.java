
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour tSignupCount complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tSignupCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dSignup" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iAverage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSignupCount", propOrder = {
    "dSignup",
    "iCount",
    "iTotal",
    "iAverage"
})
public class TSignupCount {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dSignup;
    protected int iCount;
    protected int iTotal;
    protected int iAverage;

    /**
     * Obtient la valeur de la propriété dSignup.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDSignup() {
        return dSignup;
    }

    /**
     * Définit la valeur de la propriété dSignup.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDSignup(XMLGregorianCalendar value) {
        this.dSignup = value;
    }

    /**
     * Obtient la valeur de la propriété iCount.
     * 
     */
    public int getICount() {
        return iCount;
    }

    /**
     * Définit la valeur de la propriété iCount.
     * 
     */
    public void setICount(int value) {
        this.iCount = value;
    }

    /**
     * Obtient la valeur de la propriété iTotal.
     * 
     */
    public int getITotal() {
        return iTotal;
    }

    /**
     * Définit la valeur de la propriété iTotal.
     * 
     */
    public void setITotal(int value) {
        this.iTotal = value;
    }

    /**
     * Obtient la valeur de la propriété iAverage.
     * 
     */
    public int getIAverage() {
        return iAverage;
    }

    /**
     * Définit la valeur de la propriété iAverage.
     * 
     */
    public void setIAverage(int value) {
        this.iAverage = value;
    }

}
