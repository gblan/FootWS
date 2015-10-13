
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
 *         &lt;element name="GoalsScoredResult" type="{http://footballpool.dataaccess.eu}ArrayOftGoal"/>
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
    "goalsScoredResult"
})
@XmlRootElement(name = "GoalsScoredResponse")
public class GoalsScoredResponse {

    @XmlElement(name = "GoalsScoredResult", required = true)
    protected ArrayOftGoal goalsScoredResult;

    /**
     * Obtient la valeur de la propriété goalsScoredResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftGoal }
     *     
     */
    public ArrayOftGoal getGoalsScoredResult() {
        return goalsScoredResult;
    }

    /**
     * Définit la valeur de la propriété goalsScoredResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftGoal }
     *     
     */
    public void setGoalsScoredResult(ArrayOftGoal value) {
        this.goalsScoredResult = value;
    }

}
