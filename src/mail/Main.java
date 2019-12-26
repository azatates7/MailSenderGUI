package mail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;

/**
 *
 * @author azatates7
 */
public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        try {
            URL url = new File("src/mail/gui/main.fxml").toURI().toURL();
            stage.setTitle("Main App");
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