package pl.pozadr.aop.service.email;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Aspect
@Service
public class EmailService {
    @Value("${send-email.smtp_server}")
    private String SMTP_SERVER;
    @Value("${send-email.smtp_port}")
    private String SMTP_PORT;
    @Value("${send-email.username}")
    private String USERNAME;
    @Value("${send-email.password}")
    private String PASSWORD;

    @Value("${send-email.email_from}")
    private String EMAIL_FROM;
    @Value("${send-email.email_to}")
    private String EMAIL_TO;
    //@Value("${send-email.email_to_cc}")
    private String EMAIL_TO_CC = "";

    private String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private String EMAIL_TEXT = "Hello! \n SPAM SPAM SPAM";

    @After("@annotation(pl.pozadr.aop.service.email.SendEmail)")
    public void sendEmail() {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", SMTP_PORT); // default port 25

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

            // cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(EMAIL_TEXT);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();


        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
