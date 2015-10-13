
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="bSortedByName" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bSortedByYellowCards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bSortedByRedCards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "bSortedByName",
    "bSortedByYellowCards",
    "bSortedByRedCards"
})
@XmlRootElement(name = "AllPlayersWithYellowOrRedCards")
public class AllPlayersWithYellowOrRedCards {

    protected boolean bSortedByName;
    protected boolean bSortedByYellowCards;
    protected boolean bSortedByRedCards;

    /**
     * Obtient la valeur de la propriété bSortedByName.
     * 
     */
    public boolean isBSortedByName() {
        return bSortedByName;
    }

    /**
     * Définit la valeur de la propriété bSortedByName.
     * 
     */
    public void setBSortedByName(boolean value) {
        this.bSortedByName = value;
    }

    /**
     * Obtient la valeur de la propriété bSortedByYellowCards.
     * 
     */
    public boolean isBSortedByYellowCards() {
        return bSortedByYellowCards;
    }

    /**
     * Définit la valeur de la propriété bSortedByYellowCards.
     * 
     */
    public void setBSortedByYellowCards(boolean value) {
        this.bSortedByYellowCards = value;
    }

    /**
     * Obtient la valeur de la propriété bSortedByRedCards.
     * 
     */
    public boolean isBSortedByRedCards() {
        return bSortedByRedCards;
    }

    /**
     * Définit la valeur de la propriété bSortedByRedCards.
     * 
     */
    public void setBSortedByRedCards(boolean value) {
        this.bSortedByRedCards = value;
    }

}
