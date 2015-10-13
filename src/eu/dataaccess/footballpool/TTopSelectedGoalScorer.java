
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tTopSelectedGoalScorer complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tTopSelectedGoalScorer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iSelected" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Countries" type="{http://footballpool.dataaccess.eu}ArrayOftCountrySelectedTopScorer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopSelectedGoalScorer", propOrder = {
    "sName",
    "iSelected",
    "countries"
})
public class TTopSelectedGoalScorer {

    @XmlElement(required = true)
    protected String sName;
    protected int iSelected;
    @XmlElement(name = "Countries", required = true)
    protected ArrayOftCountrySelectedTopScorer countries;

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
     * Obtient la valeur de la propriété iSelected.
     * 
     */
    public int getISelected() {
        return iSelected;
    }

    /**
     * Définit la valeur de la propriété iSelected.
     * 
     */
    public void setISelected(int value) {
        this.iSelected = value;
    }

    /**
     * Obtient la valeur de la propriété countries.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCountrySelectedTopScorer }
     *     
     */
    public ArrayOftCountrySelectedTopScorer getCountries() {
        return countries;
    }

    /**
     * Définit la valeur de la propriété countries.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCountrySelectedTopScorer }
     *     
     */
    public void setCountries(ArrayOftCountrySelectedTopScorer value) {
        this.countries = value;
    }

}
