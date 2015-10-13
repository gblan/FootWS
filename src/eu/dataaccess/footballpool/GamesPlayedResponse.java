
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
 *         &lt;element name="GamesPlayedResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "gamesPlayedResult"
})
@XmlRootElement(name = "GamesPlayedResponse")
public class GamesPlayedResponse {

    @XmlElement(name = "GamesPlayedResult")
    protected int gamesPlayedResult;

    /**
     * Obtient la valeur de la propriété gamesPlayedResult.
     * 
     */
    public int getGamesPlayedResult() {
        return gamesPlayedResult;
    }

    /**
     * Définit la valeur de la propriété gamesPlayedResult.
     * 
     */
    public void setGamesPlayedResult(int value) {
        this.gamesPlayedResult = value;
    }

}
