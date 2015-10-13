
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
 *         &lt;element name="AllGamesResult" type="{http://footballpool.dataaccess.eu}ArrayOftGameInfo"/>
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
    "allGamesResult"
})
@XmlRootElement(name = "AllGamesResponse")
public class AllGamesResponse {

    @XmlElement(name = "AllGamesResult", required = true)
    protected ArrayOftGameInfo allGamesResult;

    /**
     * Obtient la valeur de la propriété allGamesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGameInfo }
     *     
     */
    public ArrayOftGameInfo getAllGamesResult() {
        return allGamesResult;
    }

    /**
     * Définit la valeur de la propriété allGamesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGameInfo }
     *     
     */
    public void setAllGamesResult(ArrayOftGameInfo value) {
        this.allGamesResult = value;
    }

}
