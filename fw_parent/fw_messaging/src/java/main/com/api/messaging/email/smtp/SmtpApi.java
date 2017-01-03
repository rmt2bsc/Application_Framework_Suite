package com.api.messaging.email.smtp;

import java.util.Map;

import com.api.messaging.MessageManager;
import com.api.messaging.email.EmailException;
import com.api.messaging.email.EmailMessageBean;

/**
 * Interface that provides methods for setting up and sending messages via the
 * SMTP protocol. There are two ways to use this api which centers around how
 * the email content is assembled prior to transmission: <i>simple</i> and
 * <i>template</i>.
 * <p>
 * The sipmle approach basically assembles the <i>From</i>, <i>To</i>,
 * <i>Subject</i>, <i>Body</i>, and <i>Attachments</i> comonents to a
 * MimeMessage and then proceeds to send the email to its intended recipients.
 * Conversly, the template approach requires or uses a tempalting engine to
 * generate dynamic content which closely resembles the concepts of Mail Merge.
 * <p>
 * <b>USAGE</b>
 * 
 * <pre>
 * <b><u>Simple Example:</u></b>
 *    // Setup bean that represents the email message.
 *    EmailMessageBean bean = new EmailMessageBean();
 *    bean.setFromAddress("roy.terrell@aviall.com");
 *    
 *    // You can optionally enter multiple email addresses separated by commas
 *    bean.setToAddress("someother.address@aviall.com");  <br>
 *    bean.setSubject("SMTP Email Test");  
 *    bean.setBody("Test", EmailBean.HTML_CONTENT);
 *    
 *    // Declare and initialize SMTP api and allow the system to discover SMTP host 
 *    SmtpApi api = SmtpFactory.getSmtpIntance();
 *    // Send simple email to its intended destination
 *    try {
 *       api.sendMessage(bean); 
 *       // Close the service.
 *       api.close();
 *    }
 *    catch (Exception e) {
 *       // handle error
 *    }
 *    
 * <b><u>Template Example:</u></b>
 *    // Setup bean that represents the email message.
 *    EmailBean bean = new EmailBean();
 *    bean.setFromAddress("roy.terrell@aviall.com");
 *    
 *    // You can optionally enter multiple email addresses separated by commas
 *    bean.setToAddress("someother.address@aviall.com");  <br>
 *    bean.setSubject("SMTP Email Test");  
 *    
 *    // Declare and initialize SMTP api and allow the system to discover SMTP host 
 *    SmtpApi api = AviallEmailFactory.getSmtpIntance();
 *    
 *    // Create a Hashtable containg the data that will dynamically substitute 
 *    // the place holders in the Velocity document.
 *    // For all intents and purposes, we will be processing a Velocity docuemnt 
 *    // named, <i>contact.vm</i>, which contains the following variable place 
 *    // holders, firstname and lastname.
 *    Map tempData = new Hashtable();
 *    tempData.put("firstname", "Bill");
 *    tempData.put("lastname", "Clinton");
 *    
 *    // Process template email and send the results to its intended recipients
 *    try {
 *       api.sendMessage(bean, tempData, "contact"); 
 *       // Close the service.
 *       api.close();
 *    }
 *    catch (Exception e) {
 *       // handle error
 *    }
 * </pre>
 * 
 * @author RTerrell
 * 
 */
public interface SmtpApi extends MessageManager {

    /**
     * Using the concepts of "Mail Merge", this method creates and transmits an
     * email message to its destination. Uses a template document to dynamically
     * bind data values to one or more place holders contained in the template.
     * 
     * @param emailData
     *            {@link com.aviall.apps.dotcom.util.email.EmailMessageBean
     *            EmailMessageBean} containing data values for <i>From</i>,
     *            <i>To</i>, <i>Subject</i>, and <i>Attachments</i> email
     *            components. The Body component is not requrired since the
     *            content of the template will be processed as the email body.
     * @param tempData
     *            A Map containing the data that will be used to substitute
     *            values for any place holders existing in the template
     *            document. A Map should be created containg the data that will
     *            dynamically substitute the place holders in the Velocity
     *            document. The hash key names represent the place holder
     *            variables in the document and should be spelled exactly the
     *            same. The hash values represent the data value that will
     *            substitute the mapped place holder in the Velocity document.
     * @param tempName
     *            The name of the template document to process. Do not include
     *            any path information as well as the file extension since this
     *            process requires the template extension to exist as ".vm".
     * @return int
     * @throws AviallEmailException
     */
    int sendMessage(EmailMessageBean emailData, Map<Object, Object> tempData,
            String tempName) throws EmailException;

}
