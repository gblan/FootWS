
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tTeamCompete complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tTeamCompete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iWon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CoachInfo" type="{http://footballpool.dataaccess.eu}tCoaches"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTeamCompete", propOrder = {
    "iCompeted",
    "iWon",
    "coachInfo"
})
public class TTeamCompete {

    protected int iCompeted;
    protected int iWon;
    @XmlElement(name = "CoachInfo", required = true)
    protected TCoaches coachInfo;

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
     * Obtient la valeur de la propriété iWon.
     * 
     */
    public int getIWon() {
        return iWon;
    }

    /**
     * Définit la valeur de la propriété iWon.
     * 
     */
    public void setIWon(int value) {
        this.iWon = value;
    }

    /**
     * Obtient la valeur de la propriété coachInfo.
     * 
     * @return
     *     possible object is
     *     {@link TCoaches }
     *     
     */
    public TCoaches getCoachInfo() {
        return coachInfo;
    }

    /**
     * Définit la valeur de la propriété coachInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link TCoaches }
     *     
     */
    public void setCoachInfo(TCoaches value) {
        this.coachInfo = value;
    }

}
