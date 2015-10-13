
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tFullTeamInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tFullTeamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCoach" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sGoalKeepers" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sDefenders" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sMidFields" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sForwards" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFullTeamInfo", propOrder = {
    "sName",
    "sCountryFlag",
    "sCountryFlagLarge",
    "sCoach",
    "iCompeted",
    "sGoalKeepers",
    "sDefenders",
    "sMidFields",
    "sForwards"
})
public class TFullTeamInfo {

    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sCountryFlag;
    @XmlElement(required = true)
    protected String sCountryFlagLarge;
    @XmlElement(required = true)
    protected String sCoach;
    protected int iCompeted;
    @XmlElement(required = true)
    protected ArrayOfString sGoalKeepers;
    @XmlElement(required = true)
    protected ArrayOfString sDefenders;
    @XmlElement(required = true)
    protected ArrayOfString sMidFields;
    @XmlElement(required = true)
    protected ArrayOfString sForwards;

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
     * Obtient la valeur de la propriété sCountryFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlag() {
        return sCountryFlag;
    }

    /**
     * Définit la valeur de la propriété sCountryFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlag(String value) {
        this.sCountryFlag = value;
    }

    /**
     * Obtient la valeur de la propriété sCountryFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlagLarge() {
        return sCountryFlagLarge;
    }

    /**
     * Définit la valeur de la propriété sCountryFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlagLarge(String value) {
        this.sCountryFlagLarge = value;
    }

    /**
     * Obtient la valeur de la propriété sCoach.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCoach() {
        return sCoach;
    }

    /**
     * Définit la valeur de la propriété sCoach.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCoach(String value) {
        this.sCoach = value;
    }

    /**
     * Obtient la valeur de la propriété iCompeted.
     * 
     */
    public int getICompeted() {
        return iCompeted;
    }

    /**
     * Définit la valeur de la propriété iCompeted.
     * 
     */
    public void setICompeted(int value) {
        this.iCompeted = value;
    }

    /**
     * Obtient la valeur de la propriété sGoalKeepers.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSGoalKeepers() {
        return sGoalKeepers;
    }

    /**
     * Définit la valeur de la propriété sGoalKeepers.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSGoalKeepers(ArrayOfString value) {
        this.sGoalKeepers = value;
    }

    /**
     * Obtient la valeur de la propriété sDefenders.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSDefenders() {
        return sDefenders;
    }

    /**
     * Définit la valeur de la propriété sDefenders.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSDefenders(ArrayOfString value) {
        this.sDefenders = value;
    }

    /**
     * Obtient la valeur de la propriété sMidFields.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSMidFields() {
        return sMidFields;
    }

    /**
     * Définit la valeur de la propriété sMidFields.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSMidFields(ArrayOfString value) {
        this.sMidFields = value;
    }

    /**
     * Obtient la valeur de la propriété sForwards.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSForwards() {
        return sForwards;
    }

    /**
     * Définit la valeur de la propriété sForwards.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSForwards(ArrayOfString value) {
        this.sForwards = value;
    }

}
