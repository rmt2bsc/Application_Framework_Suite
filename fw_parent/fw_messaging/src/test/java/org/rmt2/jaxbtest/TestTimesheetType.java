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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.RMT2Base;


/**
 * <p>Java class for timesheet_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timesheet_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timesheet_id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="project" type="{}project_type"/>
 *         &lt;element name="employee" type="{}employee_type"/>
 *         &lt;element name="display_value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="period_begin" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="period_end" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="invoice_ref_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="external_ref_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time_log" type="{}event_type" maxOccurs="unbounded"/>
 *         &lt;element name="status_history" type="{}timesheet_status_history_type" maxOccurs="unbounded"/>
 *         &lt;element name="document_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tracking" type="{}record_tracking_type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timesheet_type", propOrder = {
    "timesheetId",
    "project",
    "employee",
    "displayValue",
    "periodBegin",
    "periodEnd",
    "invoiceRefNo",
    "externalRefNo",
    "timeLog",
    "statusHistory",
    "documentId",
    "comments",
    "tracking"
})
public class TestTimesheetType
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "timesheet_id", required = true)
    protected BigInteger timesheetId;
    @XmlElement(required = true)
    protected TestProjectType project;
    @XmlElement(required = true)
    protected TestEmployeeType employee;
    @XmlElement(name = "display_value")
    protected String displayValue;
    @XmlElement(name = "period_begin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodBegin;
    @XmlElement(name = "period_end", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodEnd;
    @XmlElement(name = "invoice_ref_no")
    protected String invoiceRefNo;
    @XmlElement(name = "external_ref_no")
    protected String externalRefNo;
    @XmlElement(name = "time_log", required = true)
    protected List<TestEventType> timeLog;
    @XmlElement(name = "status_history", required = true)
    protected List<TestTimesheetStatusHistoryType> statusHistory;
    @XmlElement(name = "document_id")
    protected BigInteger documentId;
    protected String comments;
    protected TestRecordTrackingType tracking;

    /**
     * Gets the value of the timesheetId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimesheetId() {
        return timesheetId;
    }

    /**
     * Sets the value of the timesheetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimesheetId(BigInteger value) {
        this.timesheetId = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectType }
     *     
     */
    public TestProjectType getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectType }
     *     
     */
    public void setProject(TestProjectType value) {
        this.project = value;
    }

    /**
     * Gets the value of the employee property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeType }
     *     
     */
    public TestEmployeeType getEmployee() {
        return employee;
    }

    /**
     * Sets the value of the employee property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeType }
     *     
     */
    public void setEmployee(TestEmployeeType value) {
        this.employee = value;
    }

    /**
     * Gets the value of the displayValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * Sets the value of the displayValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayValue(String value) {
        this.displayValue = value;
    }

    /**
     * Gets the value of the periodBegin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodBegin() {
        return periodBegin;
    }

    /**
     * Sets the value of the periodBegin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodBegin(XMLGregorianCalendar value) {
        this.periodBegin = value;
    }

    /**
     * Gets the value of the periodEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodEnd() {
        return periodEnd;
    }

    /**
     * Sets the value of the periodEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodEnd(XMLGregorianCalendar value) {
        this.periodEnd = value;
    }

    /**
     * Gets the value of the invoiceRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRefNo() {
        return invoiceRefNo;
    }

    /**
     * Sets the value of the invoiceRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRefNo(String value) {
        this.invoiceRefNo = value;
    }

    /**
     * Gets the value of the externalRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRefNo() {
        return externalRefNo;
    }

    /**
     * Sets the value of the externalRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRefNo(String value) {
        this.externalRefNo = value;
    }

    /**
     * Gets the value of the timeLog property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeLog property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeLog().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventType }
     * 
     * 
     */
    public List<TestEventType> getTimeLog() {
        if (timeLog == null) {
            timeLog = new ArrayList<TestEventType>();
        }
        return this.timeLog;
    }

    /**
     * Gets the value of the statusHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimesheetStatusHistoryType }
     * 
     * 
     */
    public List<TestTimesheetStatusHistoryType> getStatusHistory() {
        if (statusHistory == null) {
            statusHistory = new ArrayList<TestTimesheetStatusHistoryType>();
        }
        return this.statusHistory;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDocumentId(BigInteger value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the tracking property.
     * 
     * @return
     *     possible object is
     *     {@link RecordTrackingType }
     *     
     */
    public TestRecordTrackingType getTracking() {
        return tracking;
    }

    /**
     * Sets the value of the tracking property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordTrackingType }
     *     
     */
    public void setTracking(TestRecordTrackingType value) {
        this.tracking = value;
    }

}
