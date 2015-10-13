
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
 *         &lt;element name="GamesPerCityResult" type="{http://footballpool.dataaccess.eu}ArrayOftGameInfo"/>
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
    "gamesPerCityResult"
})
@XmlRootElement(name = "GamesPerCityResponse")
public class GamesPerCityResponse {

    @XmlElement(name = "GamesPerCityResult", required = true)
    protected ArrayOftGameInfo gamesPerCityResult;

    /**
     * Obtient la valeur de la propriété gamesPerCityResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGameInfo }
     *     
     */
    public ArrayOftGameInfo getGamesPerCityResult() {
        return gamesPerCityResult;
    }

    /**
     * Définit la valeur de la propriété gamesPerCityResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGameInfo }
     *     
     */
    public void setGamesPerCityResult(ArrayOftGameInfo value) {
        this.gamesPerCityResult = value;
    }

}
