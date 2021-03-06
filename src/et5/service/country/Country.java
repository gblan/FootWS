//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 12:27:28 AM CET 
//


package et5.service.country;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="continentCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="administrativeCapital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currencyExchange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phoneCodePrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="languages">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="meteoLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Wind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="skyConditions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="RelativeHumidity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "countryName",
    "continent",
    "continentCode",
    "administrativeCapital",
    "currencyExchange",
    "phoneCodePrefix",
    "flagURL",
    "languages",
    "meteoLocation"
})
@XmlRootElement(name = "country")
public class Country {

    @XmlElement(required = true)
    protected String countryName;
    @XmlElement(required = true)
    protected String continent;
    @XmlElement(required = true)
    protected String continentCode;
    @XmlElement(required = true)
    protected String administrativeCapital;
    @XmlElement(required = true)
    protected String currencyExchange;
    @XmlElement(required = true)
    protected String phoneCodePrefix;
    @XmlElement(required = true)
    protected String flagURL;
    @XmlElement(required = true)
    protected Country.Languages languages;
    @XmlElement(required = true)
    protected Country.MeteoLocation meteoLocation;

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the continent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the value of the continent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContinent(String value) {
        this.continent = value;
    }

    /**
     * Gets the value of the continentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContinentCode() {
        return continentCode;
    }

    /**
     * Sets the value of the continentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContinentCode(String value) {
        this.continentCode = value;
    }

    /**
     * Gets the value of the administrativeCapital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrativeCapital() {
        return administrativeCapital;
    }

    /**
     * Sets the value of the administrativeCapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrativeCapital(String value) {
        this.administrativeCapital = value;
    }

    /**
     * Gets the value of the currencyExchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyExchange() {
        return currencyExchange;
    }

    /**
     * Sets the value of the currencyExchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyExchange(String value) {
        this.currencyExchange = value;
    }

    /**
     * Gets the value of the phoneCodePrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneCodePrefix() {
        return phoneCodePrefix;
    }

    /**
     * Sets the value of the phoneCodePrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneCodePrefix(String value) {
        this.phoneCodePrefix = value;
    }

    /**
     * Gets the value of the flagURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagURL() {
        return flagURL;
    }

    /**
     * Sets the value of the flagURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagURL(String value) {
        this.flagURL = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link Country.Languages }
     *     
     */
    public Country.Languages getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country.Languages }
     *     
     */
    public void setLanguages(Country.Languages value) {
        this.languages = value;
    }

    /**
     * Gets the value of the meteoLocation property.
     * 
     * @return
     *     possible object is
     *     {@link Country.MeteoLocation }
     *     
     */
    public Country.MeteoLocation getMeteoLocation() {
        return meteoLocation;
    }

    /**
     * Sets the value of the meteoLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country.MeteoLocation }
     *     
     */
    public void setMeteoLocation(Country.MeteoLocation value) {
        this.meteoLocation = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "language"
    })
    public static class Languages {

        @XmlElement(required = true)
        protected List<String> language;

        /**
         * Gets the value of the language property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the language property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLanguage() {
            if (language == null) {
                language = new ArrayList<String>();
            }
            return this.language;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Wind" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="skyConditions" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="RelativeHumidity" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "location",
        "time",
        "wind",
        "skyConditions",
        "temperature",
        "relativeHumidity"
    })
    public static class MeteoLocation {

        @XmlElement(name = "Location", required = true)
        protected String location;
        @XmlElement(name = "Time", required = true)
        protected String time;
        @XmlElement(name = "Wind", required = true)
        protected String wind;
        @XmlElement(required = true)
        protected String skyConditions;
        @XmlElement(name = "Temperature", required = true)
        protected String temperature;
        @XmlElement(name = "RelativeHumidity", required = true)
        protected String relativeHumidity;

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Gets the value of the time property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTime() {
            return time;
        }

        /**
         * Sets the value of the time property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTime(String value) {
            this.time = value;
        }

        /**
         * Gets the value of the wind property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWind() {
            return wind;
        }

        /**
         * Sets the value of the wind property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWind(String value) {
            this.wind = value;
        }

        /**
         * Gets the value of the skyConditions property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSkyConditions() {
            return skyConditions;
        }

        /**
         * Sets the value of the skyConditions property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSkyConditions(String value) {
            this.skyConditions = value;
        }

        /**
         * Gets the value of the temperature property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemperature() {
            return temperature;
        }

        /**
         * Sets the value of the temperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemperature(String value) {
            this.temperature = value;
        }

        /**
         * Gets the value of the relativeHumidity property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRelativeHumidity() {
            return relativeHumidity;
        }

        /**
         * Sets the value of the relativeHumidity property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRelativeHumidity(String value) {
            this.relativeHumidity = value;
        }

    }

}
