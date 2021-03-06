package com.api.messaging.email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * This class represents an eMail envelope. This bean contains the data
 * components that are essential for setting up and sending/receiving electronic
 * mail.
 * 
 * @author RTerrell
 * 
 */
public class EmailMessageBean implements Serializable {
    private static final long serialVersionUID = 4343627609079776162L;

    private static final Logger logger = Logger.getLogger(EmailMessageBean.class);

    private InternetAddress fromAddress;

    private InternetAddress toAddress[];

    private InternetAddress ccAddress[];

    private InternetAddress bccAddress[];

    private String recipients;

    private String body;

    private String bodyMimeType;

    private MimeMultipart mainBody;

    private List<MimeBodyPart> attachments;

    private String subject;

    private int contentType;

    /** Value that describes the text email content type. */
    public static final String TEXT_CONTENT = "text/plain";

    /** Value that describes the HTML email content type. */
    public static final String HTML_CONTENT = "text/html";

    /** Value that describes the ascii email content type. */
    public static final String ASCII_CONTENT = "US-ASCII";

    /** Semi colon as a Mulitiple internet address String delimiter */
    public static final int ADDR_DELIM_SEMICOLON = 0;

    /** Comma as a Mulitiple internet address String delimiter */
    public static final int ADDR_DELIM_COMMA = 1;

    /** Space as a Mulitiple internet address String delimiter */
    public static final int ADDR_DELIM_SPACE = 2;

    /** One character space constant */
    public static final String SPACE = " ";

    /**
     * Constructs an EmailBean object and initializes its member variables.
     * 
     * @throws SystemException
     */
    public EmailMessageBean() {
        init();
    }

    /**
     * Initializes the member variables of this class.
     */
    public void init() {
        this.fromAddress = new InternetAddress();
        this.toAddress = null;
        this.ccAddress = null;
        this.bccAddress = null;
        this.body = null;
        this.mainBody = new MimeMultipart();
        this.attachments = new ArrayList<MimeBodyPart>();
        this.subject = null;
        this.contentType = 0;
        this.recipients = "";
    }

    /**
     * Get the From address.
     * 
     * @return InternetAddress
     */
    public InternetAddress getFromAddress() {
        return this.fromAddress;
    }

    /**
     * Set the From Address using an String email address.
     * 
     * @param value
     *            String
     */
    public void setFromAddress(String value) {
        this.fromAddress.setAddress(value);
    }

    /**
     * Get the To Address.
     * 
     * @return InternetAddress[]
     */
    public InternetAddress[] getToAddress() {
        return this.toAddress;
    }

    /**
     * Set the To Address using a String of one or more email internet addresses
     * separated by commas.
     * 
     * @param value
     *            A list of addresses separated by commas.
     */
    public void setToAddress(String value) {
        this.toAddress = this.initAddress(value);
        if (this.recipients.length() > 0) {
            this.recipients += ", " + value;
        }
        else {
            this.recipients = value;
        }
    }

    /**
     * Set the To Address using a collection of email internet address values.
     * 
     * @param emailCollection
     *            a Collection of email addersses
     */
    public void setToAddress(Collection<String> emailCollection) {
        StringBuffer emails = new StringBuffer();
        Iterator<String> iter = emailCollection.iterator();
        while (iter.hasNext()) {
            if (emails.length() > 0) {
                emails.append(", ");
            }
            String email = iter.next();
            emails.append(email);
        }
        this.setToAddress(emails.toString());
    }

    /**
     * Get CC Address.
     * 
     * @return InternetAddress[]
     */
    public InternetAddress[] getCCAddress() {
        return this.ccAddress;
    }

    /**
     * Set the CC Address using a String of one or more email internet addresses
     * separated by commas.
     * 
     * @param value
     *            A list of addresses separated by commas.
     */
    public void setCCAddress(String value) {
        this.ccAddress = this.initAddress(value);
        this.recipients += value;
    }

    /**
     * Get Blind CC Address.
     * 
     * @return InternetAddress[]
     */
    public InternetAddress[] getBCCAddress() {
        return this.bccAddress;
    }

    /**
     * Set the Blind CC Address using a String of one or more email internet
     * addresses separated by commas.
     * 
     * @param value
     *            A list of addresses separated by commas.
     */
    public void setBCCAddress(String value) {
        this.bccAddress = this.initAddress(value);
        this.recipients += value;
    }

    /**
     * Get body part of email.
     * 
     * @return MimeBodyPart
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Set the body part of the email. In the event thee body cannot be
     * initialized, then it is set to null.
     * 
     * @param content
     *            The content of the body.
     * @param mimeType
     *            The MIME type. Defaults to HTML content when passed as null.
     */
    public void setBody(String content, String mimeType) {
        this.body = content;
        this.bodyMimeType = mimeType;
    }

    /**
     * Get the email attachments.
     * 
     * @return ArrayList
     */
    public List<MimeBodyPart> getAttachments() {
        return this.attachments;
    }

    /**
     * Addes a file to the list of MimeBodyPart attachments.
     * 
     * @param fileName
     *            The complete path and file name of the fiel system resource to
     *            attach to the email.
     */
    public void addAttachment(String fileName) {
        MimeBodyPart obj = new MimeBodyPart();
        try {
            // Put a file in the second part
            FileDataSource fds = new FileDataSource(fileName);
            obj.setDataHandler(new DataHandler(fds));
            obj.setFileName(fds.getName());
            this.attachments.add(obj);
            return;
        } catch (MessagingException e) {
            // Do nothing
        }
    }

    /**
     * Creates an email attachment from streamable content that resides in
     * memory. In the event that <i>content</i> is not provided, the attachment
     * will be created using the full path and file name passed as
     * <i>fileName</i>, which should point to a valid file system resource.
     * 
     * @param content
     *            The actual data of the artifact that will be attached to the
     *            email.
     * @param contentType
     *            The MIME type of the content
     * @param fileName
     *            This is the file name, including full path, of the attachement
     *            when <i>content is null</i>. If the content of the attachment
     *            is provided, only the file name without the full path is
     *            needed since <i>fileName</i> will serve to simply name the
     *            attachment.
     */
    public void setAttachments(Object content, String contentType, String fileName) {
        MimeBodyPart obj = new MimeBodyPart();
        try {
            // Put a file in the second part
            FileDataSource fds = null;
            if (content == null) {
                fds = new FileDataSource(fileName);
                obj.setFileName(fds.getName());
                obj.setDataHandler(new DataHandler(fds));
            }
            else {
                obj.setDataHandler(new DataHandler(content, contentType));
                obj.setFileName(fileName);
            }

            // Add attachment to list of attachments for this EMail
            this.attachments.add(obj);
            return;
        } catch (MessagingException e) {
            // Do nothing
        }
    }

    /**
     * Creates an array of InternetAddress objects using a String list of emails
     * separated by commas.
     * 
     * @param emailAddresses
     *            A list of one or more emails separateda by commas.
     * @return An array of InternetAddress objects. Returns null if
     *         emailAddresses cannot be parsed.
     */
    protected InternetAddress[] initAddress(String emailAddresses) {
        try {
            return InternetAddress.parse(emailAddresses);
        } catch (AddressException e) {
            return null;
        }
    }

    /**
     * Gets the email address as a String.
     * 
     * @param address
     *            InternetAddress
     * @return email address or null if address is invalid.
     */
    public static String addressToString(InternetAddress address) {
        // Address must be valid
        if (address == null) {
            return null;
        }
        return address.getAddress();
    }

    /**
     * Gets the email address of each element in the InternetAddress array and
     * concatenates each email address into a String list. By default, each
     * address is separted by a semi-colon.
     * 
     * @param addresses
     *            An array of InternetAddress objects.
     * @return String list of emails separated by semi-colons.
     */
    public static String addressToString(InternetAddress addresses[]) {
        return EmailMessageBean.addressToString(addresses, EmailMessageBean.ADDR_DELIM_SEMICOLON);
    }

    /**
     * Gets the email address of each element in the InternetAddress array and
     * concatenates each email address into a String list separted by delimiter.
     * 
     * @param addresses
     *            An array of InternetAddress objects.
     * @param delimiter
     *            An integer value representing semi-colon=0, comma=1, or
     *            space=3.
     * @return String list of emails separated by the specified delimiter.
     *         Returns null if addresses does not contain at least one email, if
     *         delimiter is invalid, or if emails could not be parsed.
     */
    public static String addressToString(InternetAddress addresses[],
            int delimiter) {
        String strDelim = null;

        // Must have at least one address to process.
        if (addresses.length <= 0) {
            return null;
        }
        // Determine the delimiter that will separate emails
        switch (delimiter) {
            case EmailMessageBean.ADDR_DELIM_COMMA:
                strDelim = ",";
                break;
            case EmailMessageBean.ADDR_DELIM_SEMICOLON:
                strDelim = ";";
                break;
            case EmailMessageBean.ADDR_DELIM_SPACE:
                strDelim = EmailMessageBean.SPACE;
                break;
            default:
                return null;
        }
        return EmailMessageBean.addressToString(addresses, strDelim);
    }

    /**
     * Gets the email address of each element in the InternetAddress array and
     * concatenates each email address into a String list separted by the String
     * delimiter.
     * 
     * @param addresses
     *            An array of InternetAddress objects.
     * @param delimiter
     *            The delimiter (semi-colon, comma, or space) that separates the
     *            emails.
     * @return String list of emails separated by the specified delimiter.
     */
    private static String addressToString(InternetAddress addresses[], String delimiter) {
        String results = "";
        for (int ndx = 0; ndx < addresses.length; ndx++) {
            if (results.length() > 0) {
                results += ";" + EmailMessageBean.addressToString(addresses[ndx]);
            }
            else {
                results += EmailMessageBean.addressToString(addresses[ndx]);
            }
        }
        return results;
    }

    /**
     * Get the Email subject.
     * 
     * @return String.
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * Set the email subject
     * 
     * @param value
     *            String
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Set the email content type.
     * 
     * @param value
     *            int.
     */
    public void setContentType(int value) {
        this.contentType = value;
    }

    /**
     * Get the content type of the email.
     * 
     * @return int
     */
    public int getContentType() {
        return this.contentType;
    }

    public String getRecipients() {
        return recipients;
    }

}