
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour tTournamentInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tTournamentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dFirstGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGroupDateGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iGames" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTournamentInfo", propOrder = {
    "dFirstGame",
    "dLastGame",
    "dLastGroupDateGame",
    "iGames"
})
public class TTournamentInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dFirstGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGroupDateGame;
    protected int iGames;

    /**
     * Obtient la valeur de la propriété dFirstGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFirstGame() {
        return dFirstGame;
    }

    /**
     * Définit la valeur de la propriété dFirstGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFirstGame(XMLGregorianCalendar value) {
        this.dFirstGame = value;
    }

    /**
     * Obtient la valeur de la propriété dLastGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGame() {
        return dLastGame;
    }

    /**
     * Définit la valeur de la propriété dLastGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGame(XMLGregorianCalendar value) {
        this.dLastGame = value;
    }

    /**
     * Obtient la valeur de la propriété dLastGroupDateGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGroupDateGame() {
        return dLastGroupDateGame;
    }

    /**
     * Définit la valeur de la propriété dLastGroupDateGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGroupDateGame(XMLGregorianCalendar value) {
        this.dLastGroupDateGame = value;
    }

    /**
     * Obtient la valeur de la propriété iGames.
     * 
     */
    public int getIGames() {
        return iGames;
    }

    /**
     * Définit la valeur de la propriété iGames.
     * 
     */
    public void setIGames(int value) {
        this.iGames = value;
    }

}
