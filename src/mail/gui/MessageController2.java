package mail.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class MessageController2{

    @FXML private Label lblalert;

    @FXML private void sender(ActionEvent event) {
        sendermessage();
    }

    private void sendermessage() {
        try {
            Properties myProp = new Properties();
            myProp.put("mail.smtp.host", "smtp.gmail.com");
            myProp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            myProp.put("mail.smtp.auth", "true");
            myProp.put("mail.smtp.port", "465");
            Session session = Session.getInstance(myProp,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("testmailjavaapache@gmail.com", "Apachemail1234");
                        }
                    });

            String filename = "src/mail/file/sensor.txt";
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File Not Founded");
            }

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String message = br.readLine();
            String icerik = new String(message);
            Address myFrom = new InternetAddress("testmailjavaapache@gmail.com", "Tester");

            ArrayList<Address> mailaddress = new ArrayList<Address>();
            mailaddress.add(new InternetAddress("azatates4977@gmail.com", "Azat Ateş"));
            mailaddress.add(new InternetAddress("1160606001@nku.edu.tr", "Azat Ateş"));

            for (Address mail : mailaddress) {
                Message myMessage = new MimeMessage(session);
                myMessage.setFrom(myFrom);
                myMessage.setRecipient(Message.RecipientType.TO, mail);
                myMessage.setSubject("Deneme Maili");
                myMessage.setContent(icerik, "text/html;charset=UTF-8");
                Transport.send(myMessage);
                Date dt = new Date();
                System.out.println("Mesajınız başarılı bir şekilde gönderildi..." + dt);
                lblalert.setText("File Sended Succesfully");
            }
            // Thread.sleep(1000*60*60); // Wait 1 hour
            // sendermessage();
        } catch (Exception ex) {
            lblalert.setText("Send Error : " + ex.getMessage());
        }
    }

}