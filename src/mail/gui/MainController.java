package mail.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {

        @FXML void selected1 (ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        Parent child = FXMLLoader.load(getClass().getResource("message.fxml"));
        Stage x = new Stage();
        Scene scene = new Scene(child);
        x.initStyle(StageStyle.UTILITY);
        x.setTitle("Message Sender for Single User with Apache Mail Api");
        x.setScene(scene);
        x.show();
    }

        @FXML void selected2 (ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        Parent child = FXMLLoader.load(getClass().getResource("message1.fxml"));
        Stage x = new Stage();
        Scene scene = new Scene(child);
        x.initStyle(StageStyle.UTILITY);
        x.setTitle("Message Sender for Multiple User With Apache Mail Api");
        x.setScene(scene);
        x.show();
    }

        @FXML void selected3 (ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        Parent child = FXMLLoader.load(getClass().getResource("message2.fxml"));
        Stage x = new Stage();
        Scene scene = new Scene(child);
        x.initStyle(StageStyle.UTILITY);
        x.setTitle("Message Sender for Multiple User With Javax Mail Api");
        x.setScene(scene);
        x.show();
    }
}