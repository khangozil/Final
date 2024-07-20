/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class EmailUtils {

    private static final String GMAIL_SENT = "khangldce171844@fpt.edu.vn";
    private static final String GMAIL_PASSWORD = "iasv rouf cuwa yfdl";

    public static boolean sendMail(String to, String subject, String content) {
        Properties properies = new Properties();

        properies.put(
                "mail.smtp.host", "smtp.gmail.com");
        properies.put(
                "mail.smtp.port", "465");
        properies.put(
                "mail.smtp.auth", "true");
        properies.put(
                "mail.smtp.starttls.enable", "true");
        properies.put(
                "mail.smtp.starttls.required", "true");
        properies.put(
                "mail.smtp.ssl.protocols", "TLSv1.2");
        properies.put(
                "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properies, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(GMAIL_SENT, GMAIL_PASSWORD);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(GMAIL_SENT));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(content, "text/html");

            Transport.send(message);
        } catch (AddressException ex) {
            Logger.getLogger(EmailUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

}
