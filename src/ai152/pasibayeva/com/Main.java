package ai152.pasibayeva.com;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
//    BrushButton brushButton = new BrushButton();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../res/xml/interface.fxml"));
//        File file = new File("C:\\Users\\Ольга\\Desktop\\logo2.png");
//        Image image = new Image(file.toURI().toString());
//        ImageView iv = new ImageView(image);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setTitle("MyPaintStudio");
//        scene.getStylesheets().add("button.css");
        primaryStage.show();
    }
}
