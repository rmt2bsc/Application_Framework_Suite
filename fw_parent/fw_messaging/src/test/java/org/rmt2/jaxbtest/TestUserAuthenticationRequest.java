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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.RMT2Base;


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
 *         &lt;element name="header" type="{}header_type"/>
 *         &lt;element name="login_credentials" type="{}user_login_type"/>
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
    "header",
    "loginCredentials"
})
@XmlRootElement(name = "UserAuthenticationRequest")
public class TestUserAuthenticationRequest
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected TestHeaderType header;
    @XmlElement(name = "login_credentials", required = true)
    protected TestUserLoginType loginCredentials;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public TestHeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setHeader(TestHeaderType value) {
        this.header = value;
    }

    /**
     * Gets the value of the loginCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link UserLoginType }
     *     
     */
    public TestUserLoginType getLoginCredentials() {
        return loginCredentials;
    }

    /**
     * Sets the value of the loginCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserLoginType }
     *     
     */
    public void setLoginCredentials(TestUserLoginType value) {
        this.loginCredentials = value;
    }

}
