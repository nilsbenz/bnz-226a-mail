package mail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class Service {

    void sendMail(User user, String recipient, String subject, String content) {

        String mail = "";
        try {
            mail = getMailFromContent(content);
        } catch(IOException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user.getUsername(), user.getPassword());
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user.getUsername()));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject(subject);

            message.setContent(mail, "text/html; charset=UTF-8");

            Transport.send(message);
            System.out.println("\nDeine Nachricht wurde erfolgreich versendet.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    String getMailFromContent(String content) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("html.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything.replace("$$$", content);
        } finally {
            br.close();
        }
    }
}
