
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
 *         &lt;element name="TournamentInfoResult" type="{http://footballpool.dataaccess.eu}tTournamentInfo"/>
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
    "tournamentInfoResult"
})
@XmlRootElement(name = "TournamentInfoResponse")
public class TournamentInfoResponse {

    @XmlElement(name = "TournamentInfoResult", required = true)
    protected TTournamentInfo tournamentInfoResult;

    /**
     * Obtient la valeur de la propriété tournamentInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link TTournamentInfo }
     *     
     */
    public TTournamentInfo getTournamentInfoResult() {
        return tournamentInfoResult;
    }

    /**
     * Définit la valeur de la propriété tournamentInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TTournamentInfo }
     *     
     */
    public void setTournamentInfoResult(TTournamentInfo value) {
        this.tournamentInfoResult = value;
    }

}
