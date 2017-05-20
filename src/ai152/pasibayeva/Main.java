package ai152.pasibayeva;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        File file = new File("C:\\Users\\Ольга\\Desktop\\logo2.png");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);



        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("MyPaintStudio");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("button.css");
        primaryStage.show();
    }
}
