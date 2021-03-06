//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.11 at 04:31:30 PM CST 
//


package org.rmt2.jaxbtest;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.RMT2Base;


/**
 * This is the document tracks the resources that have be granted and revoked for a given user.
 * 
 * <p>Java class for resource_access_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resource_access_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_uid" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="login_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="granted_resources" type="{}resource_type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="revoked_resources" type="{}resource_type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resource_access_type", propOrder = {
    "userUid",
    "loginId",
    "userFirstname",
    "userLastname",
    "grantedResources",
    "revokedResources"
})
public class TestResourceAccessType
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "user_uid", required = true, nillable = true)
    protected BigInteger userUid;
    @XmlElement(name = "login_id", required = true, nillable = true)
    protected String loginId;
    @XmlElement(name = "user_firstname", required = true, nillable = true)
    protected String userFirstname;
    @XmlElement(name = "user_lastname", required = true, nillable = true)
    protected String userLastname;
    @XmlElement(name = "granted_resources", nillable = true)
    protected List<TestResourceType> grantedResources;
    @XmlElement(name = "revoked_resources", nillable = true)
    protected List<TestResourceType> revokedResources;

    /**
     * Gets the value of the userUid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUserUid() {
        return userUid;
    }

    /**
     * Sets the value of the userUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUserUid(BigInteger value) {
        this.userUid = value;
    }

    /**
     * Gets the value of the loginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the value of the loginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginId(String value) {
        this.loginId = value;
    }

    /**
     * Gets the value of the userFirstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserFirstname() {
        return userFirstname;
    }

    /**
     * Sets the value of the userFirstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserFirstname(String value) {
        this.userFirstname = value;
    }

    /**
     * Gets the value of the userLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLastname() {
        return userLastname;
    }

    /**
     * Sets the value of the userLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLastname(String value) {
        this.userLastname = value;
    }

    /**
     * Gets the value of the grantedResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grantedResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrantedResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceType }
     * 
     * 
     */
    public List<TestResourceType> getGrantedResources() {
        if (grantedResources == null) {
            grantedResources = new ArrayList<TestResourceType>();
        }
        return this.grantedResources;
    }

    /**
     * Gets the value of the revokedResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the revokedResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRevokedResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceType }
     * 
     * 
     */
    public List<TestResourceType> getRevokedResources() {
        if (revokedResources == null) {
            revokedResources = new ArrayList<TestResourceType>();
        }
        return this.revokedResources;
    }

}
