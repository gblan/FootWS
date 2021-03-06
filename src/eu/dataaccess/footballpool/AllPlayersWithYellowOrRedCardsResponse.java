
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
 *         &lt;element name="AllPlayersWithYellowOrRedCardsResult" type="{http://footballpool.dataaccess.eu}ArrayOftPlayersWithCards"/>
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
    "allPlayersWithYellowOrRedCardsResult"
})
@XmlRootElement(name = "AllPlayersWithYellowOrRedCardsResponse")
public class AllPlayersWithYellowOrRedCardsResponse {

    @XmlElement(name = "AllPlayersWithYellowOrRedCardsResult", required = true)
    protected ArrayOftPlayersWithCards allPlayersWithYellowOrRedCardsResult;

    /**
     * Obtient la valeur de la propriété allPlayersWithYellowOrRedCardsResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftPlayersWithCards }
     *     
     */
    public ArrayOftPlayersWithCards getAllPlayersWithYellowOrRedCardsResult() {
        return allPlayersWithYellowOrRedCardsResult;
    }

    /**
     * Définit la valeur de la propriété allPlayersWithYellowOrRedCardsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftPlayersWithCards }
     *     
     */
    public void setAllPlayersWithYellowOrRedCardsResult(ArrayOftPlayersWithCards value) {
        this.allPlayersWithYellowOrRedCardsResult = value;
    }

}
