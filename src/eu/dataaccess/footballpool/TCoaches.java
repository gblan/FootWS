
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tCoaches complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tCoaches">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeamInfo" type="{http://footballpool.dataaccess.eu}tTeamInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCoaches", propOrder = {
    "sName",
    "teamInfo"
})
public class TCoaches {

    @XmlElement(required = true)
    protected String sName;
    @XmlElement(name = "TeamInfo", required = true)
    protected TTeamInfo teamInfo;

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
     * Obtient la valeur de la propriété teamInfo.
     * 
     * @return
     *     possible object is
     *     {@link TTeamInfo }
     *     
     */
    public TTeamInfo getTeamInfo() {
        return teamInfo;
    }

    /**
     * Définit la valeur de la propriété teamInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link TTeamInfo }
     *     
     */
    public void setTeamInfo(TTeamInfo value) {
        this.teamInfo = value;
    }

}
