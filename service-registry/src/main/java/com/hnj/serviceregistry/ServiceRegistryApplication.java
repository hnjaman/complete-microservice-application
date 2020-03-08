package com.hnj.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class ServiceRegistryApplication {

    public static void sendMail(String fromEmailId, String fromName, List<String> toRecipients,
                                List<String> ccRecipients, List<String> bccRecipients, String subject, String msg) {
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);
            properties.put("userName", fromEmailId);
            properties.put("password", "lrglobalbd@123");
            final String username = fromEmailId;
            final String password = "lrglobalbd@12";
            System.out.println("creating session and authenticate");
            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            System.out.println("session and authenticatation step passed");

            MimeMessage message = new MimeMessage(session);
            message.addHeader("Content-type", "text/html");
            message.setFrom(new InternetAddress(fromEmailId, fromName));
            message.setReplyTo(new Address[] { new InternetAddress(fromEmailId, fromName) });
            StringBuilder mailTo = new StringBuilder();
            StringBuilder mailcc = new StringBuilder();
            if (toRecipients != null) {
                for (String email : toRecipients) {
                    message.addRecipients(Message.RecipientType.TO, email);
                    mailTo.append(email).append(" ");
                }
            }
            if (ccRecipients != null) {
                for (String email : ccRecipients) {
                    message.addRecipients(Message.RecipientType.CC, email);
                    mailcc.append(email).append(" ");
                }
            }
            if (bccRecipients != null) {
                for (String email : bccRecipients) {
                    message.addRecipients(Message.RecipientType.BCC, email);
                    mailTo.append(email).append(" ");
                }
            }
            message.setSubject(subject);
            message.setContent(msg, "text/html");
            message.setSentDate(new Date());
            System.out.println("going to transport email");
            Transport.send(message);
            System.out.println("mail \"" + subject + "\" successfully sent to: " + mailTo + "mailcc" + mailcc);
        } catch (Exception ex) {
            System.out.println("Error while sending mails to" + toRecipients);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);

        List<String> toRecipients = new ArrayList<String>();
        toRecipients.add("ahossain@lrglobalbd.com");

        try {
            System.out.println("starting to send email");
            sendMail("zseniaapploader@gmail.com", "ZSENIA LOADER email test", toRecipients, null, null,
                    InetAddress.getLocalHost().getHostAddress() + "Test email from prod loader", "everything is working fine");
            System.out.println("email sent successfully");
        } catch (UnknownHostException e) {
            System.out.println("Error while sending email: Not able to get IP Address: " + e);
        }
    }
}
