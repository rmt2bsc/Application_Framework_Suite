//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.11 at 04:31:30 PM CST 
//

 
package org.rmt2.jaxbtest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.RMT2Base;


/**
 * <p>Java class for contact_criteria_group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contact_criteria_group">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="business_criteria" type="{}business_contact_criteria" minOccurs="0"/>
 *         &lt;element name="person_criteria" type="{}person_contact_criteria"/>
 *         &lt;element name="common_criteria" type="{}common_contact_criteria"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact_criteria_group", propOrder = {
    "businessCriteria",
    "personCriteria",
    "commonCriteria"
})
public class TestContactCriteriaGroup
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "business_criteria")
    protected TestBusinessContactCriteria businessCriteria;
    @XmlElement(name = "person_criteria", required = true)
    protected TestPersonContactCriteria personCriteria;
    @XmlElement(name = "common_criteria", required = true)
    protected TestCommonContactCriteria commonCriteria;

    /**
     * Gets the value of the businessCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessContactCriteria }
     *     
     */
    public TestBusinessContactCriteria getBusinessCriteria() {
        return businessCriteria;
    }

    /**
     * Sets the value of the businessCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessContactCriteria }
     *     
     */
    public void setBusinessCriteria(TestBusinessContactCriteria value) {
        this.businessCriteria = value;
    }

    /**
     * Gets the value of the personCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link PersonContactCriteria }
     *     
     */
    public TestPersonContactCriteria getPersonCriteria() {
        return personCriteria;
    }

    /**
     * Sets the value of the personCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonContactCriteria }
     *     
     */
    public void setPersonCriteria(TestPersonContactCriteria value) {
        this.personCriteria = value;
    }

    /**
     * Gets the value of the commonCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link CommonContactCriteria }
     *     
     */
    public TestCommonContactCriteria getCommonCriteria() {
        return commonCriteria;
    }

    /**
     * Sets the value of the commonCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonContactCriteria }
     *     
     */
    public void setCommonCriteria(TestCommonContactCriteria value) {
        this.commonCriteria = value;
    }

}
