package ai152.pasibayeva.com.entities;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by antipavitaly on 5/25/17.
 */
public class MyMenuBar {

    private MenuItem clearCase;
    private MenuItem loadCase;
    private MenuItem saveCase;

    private Canvas canvas;

    private GraphicsContext gc;

    public MyMenuBar(MenuItem clearCase, MenuItem loadCase, MenuItem saveCase, Canvas canvas) {
        this.clearCase = clearCase;
        this.loadCase = loadCase;
        this.saveCase = saveCase;

        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

    }

    private void initDrawImage(){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        Image img =  initFileChooser();

        if (img.equals(null)){
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setHeaderText("Error");
            dialog.setContentText("Cannot resolve the file");
            dialog.showAndWait();
        } else {

//            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
//            dialog.setHeaderText("Error");
//            dialog.setContentText(path);
//            dialog.showAndWait();
//




            gc.drawImage(img, 0, 0, canvasWidth, canvasHeight);
        }
    }

    private void clearCanvas(){

        gc.clearRect(0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvas.getWidth(),    //width of the rectangle
                canvas.getHeight());
    }

    private void saveImg() {
        WritableImage wim = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.snapshot(null, wim);

        File file = new File("CanvasImage.png");


        try {
            ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", file);
        } catch (Exception s) {
        }
    }

    public void addMenuBarListeners(){

        loadCase.setOnAction(event -> {

            initDrawImage();

        });

        saveCase.setOnAction(event -> {

            saveImg();

        });

        clearCase.setOnAction(e->{

            clearCanvas();

        });



    }

    private Image initFileChooser(){

        FileChooser fChooser = new FileChooser();

        fChooser.setTitle("Choose a picture!");

        fChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"), new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"));

        File selectedFile = fChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                return image;
            } catch (IOException ex) {

            }


        }

        return null;

    }

}
