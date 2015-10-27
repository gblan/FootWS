//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.27 at 12:48:17 PM CET 
//


package et5.service.route;

import java.math.BigInteger;
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
 *         &lt;element name="teamName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coachName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbParticipation" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="matches">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="match" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="idMatch" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="team1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="team2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="finalScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="stadiumMapsURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="goals">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="minutes" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                       &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="cards">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "teamName",
    "coachName",
    "flagURL",
    "nbParticipation",
    "matches"
})
@XmlRootElement(name = "route")
public class Route {

    @XmlElement(required = true)
    protected String teamName;
    @XmlElement(required = true)
    protected String coachName;
    @XmlElement(required = true)
    protected String flagURL;
    @XmlElement(required = true)
    protected BigInteger nbParticipation;
    @XmlElement(required = true)
    protected Route.Matches matches;

    /**
     * Gets the value of the teamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the value of the teamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamName(String value) {
        this.teamName = value;
    }

    /**
     * Gets the value of the coachName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * Sets the value of the coachName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoachName(String value) {
        this.coachName = value;
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
     * Gets the value of the nbParticipation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNbParticipation() {
        return nbParticipation;
    }

    /**
     * Sets the value of the nbParticipation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNbParticipation(BigInteger value) {
        this.nbParticipation = value;
    }

    /**
     * Gets the value of the matches property.
     * 
     * @return
     *     possible object is
     *     {@link Route.Matches }
     *     
     */
    public Route.Matches getMatches() {
        return matches;
    }

    /**
     * Sets the value of the matches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Route.Matches }
     *     
     */
    public void setMatches(Route.Matches value) {
        this.matches = value;
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
     *         &lt;element name="match" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="idMatch" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="team1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="team2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="finalScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="stadiumMapsURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="goals">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="minutes" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                             &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="cards">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
        "match"
    })
    public static class Matches {

        @XmlElement(required = true)
        protected List<Route.Matches.Match> match;

        /**
         * Gets the value of the match property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the match property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMatch().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Route.Matches.Match }
         * 
         * 
         */
        public List<Route.Matches.Match> getMatch() {
            if (match == null) {
                match = new ArrayList<Route.Matches.Match>();
            }
            return this.match;
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
         *         &lt;element name="idMatch" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="team1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="team2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="finalScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="stadiumMapsURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="goals">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="minutes" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *                   &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="cards">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "idMatch",
            "team1",
            "team2",
            "finalScore",
            "stadiumMapsURL",
            "goals",
            "cards"
        })
        public static class Match {

            @XmlElement(required = true)
            protected BigInteger idMatch;
            @XmlElement(required = true)
            protected String team1;
            @XmlElement(required = true)
            protected String team2;
            @XmlElement(required = true)
            protected String finalScore;
            @XmlElement(required = true)
            protected String stadiumMapsURL;
            @XmlElement(required = true)
            protected Route.Matches.Match.Goals goals;
            @XmlElement(required = true)
            protected Route.Matches.Match.Cards cards;

            /**
             * Gets the value of the idMatch property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getIdMatch() {
                return idMatch;
            }

            /**
             * Sets the value of the idMatch property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setIdMatch(BigInteger value) {
                this.idMatch = value;
            }

            /**
             * Gets the value of the team1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTeam1() {
                return team1;
            }

            /**
             * Sets the value of the team1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTeam1(String value) {
                this.team1 = value;
            }

            /**
             * Gets the value of the team2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTeam2() {
                return team2;
            }

            /**
             * Sets the value of the team2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTeam2(String value) {
                this.team2 = value;
            }

            /**
             * Gets the value of the finalScore property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFinalScore() {
                return finalScore;
            }

            /**
             * Sets the value of the finalScore property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFinalScore(String value) {
                this.finalScore = value;
            }

            /**
             * Gets the value of the stadiumMapsURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStadiumMapsURL() {
                return stadiumMapsURL;
            }

            /**
             * Sets the value of the stadiumMapsURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStadiumMapsURL(String value) {
                this.stadiumMapsURL = value;
            }

            /**
             * Gets the value of the goals property.
             * 
             * @return
             *     possible object is
             *     {@link Route.Matches.Match.Goals }
             *     
             */
            public Route.Matches.Match.Goals getGoals() {
                return goals;
            }

            /**
             * Sets the value of the goals property.
             * 
             * @param value
             *     allowed object is
             *     {@link Route.Matches.Match.Goals }
             *     
             */
            public void setGoals(Route.Matches.Match.Goals value) {
                this.goals = value;
            }

            /**
             * Gets the value of the cards property.
             * 
             * @return
             *     possible object is
             *     {@link Route.Matches.Match.Cards }
             *     
             */
            public Route.Matches.Match.Cards getCards() {
                return cards;
            }

            /**
             * Sets the value of the cards property.
             * 
             * @param value
             *     allowed object is
             *     {@link Route.Matches.Match.Cards }
             *     
             */
            public void setCards(Route.Matches.Match.Cards value) {
                this.cards = value;
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
             *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "color",
                "goalTeam",
                "striker"
            })
            public static class Cards {

                @XmlElement(required = true)
                protected String color;
                @XmlElement(required = true)
                protected String goalTeam;
                @XmlElement(required = true)
                protected String striker;

                /**
                 * Gets the value of the color property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getColor() {
                    return color;
                }

                /**
                 * Sets the value of the color property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setColor(String value) {
                    this.color = value;
                }

                /**
                 * Gets the value of the goalTeam property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGoalTeam() {
                    return goalTeam;
                }

                /**
                 * Sets the value of the goalTeam property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGoalTeam(String value) {
                    this.goalTeam = value;
                }

                /**
                 * Gets the value of the striker property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStriker() {
                    return striker;
                }

                /**
                 * Sets the value of the striker property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStriker(String value) {
                    this.striker = value;
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
             *         &lt;element name="minutes" type="{http://www.w3.org/2001/XMLSchema}integer"/>
             *         &lt;element name="goalTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="striker" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "minutes",
                "goalTeam",
                "striker"
            })
            public static class Goals {

                @XmlElement(required = true)
                protected BigInteger minutes;
                @XmlElement(required = true)
                protected String goalTeam;
                @XmlElement(required = true)
                protected String striker;

                /**
                 * Gets the value of the minutes property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMinutes() {
                    return minutes;
                }

                /**
                 * Sets the value of the minutes property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMinutes(BigInteger value) {
                    this.minutes = value;
                }

                /**
                 * Gets the value of the goalTeam property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGoalTeam() {
                    return goalTeam;
                }

                /**
                 * Sets the value of the goalTeam property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGoalTeam(String value) {
                    this.goalTeam = value;
                }

                /**
                 * Gets the value of the striker property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStriker() {
                    return striker;
                }

                /**
                 * Sets the value of the striker property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStriker(String value) {
                    this.striker = value;
                }

            }

        }

    }

}
