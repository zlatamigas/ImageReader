package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.controller.ImageInfoController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ImageInfo.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        ImageInfoController controller = (ImageInfoController) loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("Image info");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
