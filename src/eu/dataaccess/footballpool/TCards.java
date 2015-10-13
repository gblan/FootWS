
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tCards complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iYellow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iRed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCards", propOrder = {
    "iYellow",
    "iRed"
})
public class TCards {

    protected int iYellow;
    protected int iRed;

    /**
     * Obtient la valeur de la propriété iYellow.
     * 
     */
    public int getIYellow() {
        return iYellow;
    }

    /**
     * Définit la valeur de la propriété iYellow.
     * 
     */
    public void setIYellow(int value) {
        this.iYellow = value;
    }

    /**
     * Obtient la valeur de la propriété iRed.
     * 
     */
    public int getIRed() {
        return iRed;
    }

    /**
     * Définit la valeur de la propriété iRed.
     * 
     */
    public void setIRed(int value) {
        this.iRed = value;
    }

}
