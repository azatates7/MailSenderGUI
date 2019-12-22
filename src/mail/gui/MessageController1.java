package mail.gui;


//For Multiple Mail open delete // symbols and email.addTo(address); to email.addTo(mail);

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MessageController1 implements Initializable {

    @FXML private JFXTextField txtaddress;
    @FXML private JFXTextField txtsubject;
    @FXML private JFXTextField txtmessage;
    @FXML private Label lblalert;
    @FXML private JFXRadioButton rmail, rfile;

    @FXML private void selmail(ActionEvent event){
        if(rmail.isSelected()){
            rmail.setSelected(true);
            rfile.setSelected(false);
        }
        else{
            rmail.setSelected(true);
            rfile.setSelected(false);
        }
    }

    @FXML private void selfile(ActionEvent event){
        if(rfile.isSelected()){
            rmail.setSelected(false);
            rfile.setSelected(true);
        }
        else{
            rmail.setSelected(false);
            rfile.setSelected(true);
        }
    }

    @FXML private void sender(ActionEvent event) {
        sendermessage();
    }

    @FXML private void clearmessage(ActionEvent event){
        txtmessage.setText("");
    }

    private void sendSimpleEmail(String subject, String message){

        try {
            String filename = "src/mail/file/sensor.txt";
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File Not Founded");
            }

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String firstline = br.readLine();

            if(rfile.isSelected()){
                message = firstline;
            }
            else{
                message = message;
            }

            ArrayList<String> mailaddress = new ArrayList<String>();
            mailaddress.add("azatates4977@gmail.com");
            mailaddress.add("1160606001@nku.edu.tr");
            for (String mail : mailaddress) {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("testmailjavaapache@gmail.com", "Apachemail1234"));
            email.setSSLOnConnect(true);
            email.setFrom("testmailjavaapache@gmail.com");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(mail);
            email.send();
            Date dt = new Date();
            System.out.println("File Sended Succesfully "+dt);
            }

        }
        catch(Exception ex){
            System.out.println("An Error Detected : "+ex.getMessage());
            System.exit(0);
        }
    }

    private void sendermessage(){
        try{
            String subject = txtsubject.getText();
            String message = txtmessage.getText();

            if(txtaddress.getText().equals("") || txtsubject.getText().equals("") || txtmessage.getText().equals("")){
                throw new Exception();
            }

            sendSimpleEmail(subject, message);
            lblalert.setText("File Sended Succesfully");
        }
        catch(Exception ex){
            lblalert.setText("Send Error : "+ex.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}