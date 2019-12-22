package mail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author azatates7
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            URL url = null;
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose Your Send Method : ");
            System.out.println("1-Message Sender for Single User with Apache Mail Api");
            System.out.println("2-Message Sender for Multiple User With Apache Mail Api");
            System.out.println("3-Message Sender for Multiple User With Javax Mail Api");
            System.out.print("input : ");
            int option = scan.nextInt();
            if(option == 1) {
                url = new File("src/mail/gui/message.fxml").toURI().toURL();
                stage.setTitle("Message Sender for Single User with Apache Mail Api");
            }
            else if(option == 2) {
                url = new File("src/mail/gui/message1.fxml").toURI().toURL();
                stage.setTitle("Message Sender for Multiple User With Apache Mail Api");
            }
            else if(option == 3) {
                url = new File("src/mail/gui/message2.fxml").toURI().toURL();
                stage.setTitle("Message Sender for Multiple User With Javax Mail Api");
            }
            else{
                System.exit(0);
            }

                Parent root = FXMLLoader.load(url);
                stage.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        }
        catch(Exception ex){
            System.out.println("err : "+ex.getMessage()) ;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}