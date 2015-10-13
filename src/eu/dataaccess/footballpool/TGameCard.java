
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour tGameCard complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tGameCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iMinute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sPlayerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bYellowCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bRedCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sTeamName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGameCard", propOrder = {
    "dGame",
    "iMinute",
    "sPlayerName",
    "bYellowCard",
    "bRedCard",
    "sTeamName",
    "sTeamFlag",
    "sTeamFlagLarge"
})
public class TGameCard {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dGame;
    protected int iMinute;
    @XmlElement(required = true)
    protected String sPlayerName;
    protected boolean bYellowCard;
    protected boolean bRedCard;
    @XmlElement(required = true)
    protected String sTeamName;
    @XmlElement(required = true)
    protected String sTeamFlag;
    @XmlElement(required = true)
    protected String sTeamFlagLarge;

    /**
     * Obtient la valeur de la propriété dGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDGame() {
        return dGame;
    }

    /**
     * Définit la valeur de la propriété dGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDGame(XMLGregorianCalendar value) {
        this.dGame = value;
    }

    /**
     * Obtient la valeur de la propriété iMinute.
     * 
     */
    public int getIMinute() {
        return iMinute;
    }

    /**
     * Définit la valeur de la propriété iMinute.
     * 
     */
    public void setIMinute(int value) {
        this.iMinute = value;
    }

    /**
     * Obtient la valeur de la propriété sPlayerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerName() {
        return sPlayerName;
    }

    /**
     * Définit la valeur de la propriété sPlayerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerName(String value) {
        this.sPlayerName = value;
    }

    /**
     * Obtient la valeur de la propriété bYellowCard.
     * 
     */
    public boolean isBYellowCard() {
        return bYellowCard;
    }

    /**
     * Définit la valeur de la propriété bYellowCard.
     * 
     */
    public void setBYellowCard(boolean value) {
        this.bYellowCard = value;
    }

    /**
     * Obtient la valeur de la propriété bRedCard.
     * 
     */
    public boolean isBRedCard() {
        return bRedCard;
    }

    /**
     * Définit la valeur de la propriété bRedCard.
     * 
     */
    public void setBRedCard(boolean value) {
        this.bRedCard = value;
    }

    /**
     * Obtient la valeur de la propriété sTeamName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamName() {
        return sTeamName;
    }

    /**
     * Définit la valeur de la propriété sTeamName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamName(String value) {
        this.sTeamName = value;
    }

    /**
     * Obtient la valeur de la propriété sTeamFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlag() {
        return sTeamFlag;
    }

    /**
     * Définit la valeur de la propriété sTeamFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlag(String value) {
        this.sTeamFlag = value;
    }

    /**
     * Obtient la valeur de la propriété sTeamFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlagLarge() {
        return sTeamFlagLarge;
    }

    /**
     * Définit la valeur de la propriété sTeamFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlagLarge(String value) {
        this.sTeamFlagLarge = value;
    }

}
