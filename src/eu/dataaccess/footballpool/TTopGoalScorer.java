
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tTopGoalScorer complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tTopGoalScorer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iGoals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopGoalScorer", propOrder = {
    "sName",
    "iGoals",
    "sCountry",
    "sFlag",
    "sFlagLarge"
})
public class TTopGoalScorer {

    @XmlElement(required = true)
    protected String sName;
    protected int iGoals;
    @XmlElement(required = true)
    protected String sCountry;
    @XmlElement(required = true)
    protected String sFlag;
    @XmlElement(required = true)
    protected String sFlagLarge;

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
     * Obtient la valeur de la propriété iGoals.
     * 
     */
    public int getIGoals() {
        return iGoals;
    }

    /**
     * Définit la valeur de la propriété iGoals.
     * 
     */
    public void setIGoals(int value) {
        this.iGoals = value;
    }

    /**
     * Obtient la valeur de la propriété sCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountry() {
        return sCountry;
    }

    /**
     * Définit la valeur de la propriété sCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountry(String value) {
        this.sCountry = value;
    }

    /**
     * Obtient la valeur de la propriété sFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlag() {
        return sFlag;
    }

    /**
     * Définit la valeur de la propriété sFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlag(String value) {
        this.sFlag = value;
    }

    /**
     * Obtient la valeur de la propriété sFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlagLarge() {
        return sFlagLarge;
    }

    /**
     * Définit la valeur de la propriété sFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlagLarge(String value) {
        this.sFlagLarge = value;
    }

}
