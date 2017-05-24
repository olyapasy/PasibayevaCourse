package ai152.pasibayeva.com.Controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.io.File;


/**
 * Created by Ольга on 07.04.2017.
 */
public class Controller  {

    @FXML
    Canvas canvas;

    @FXML
    BorderPane pane;

    @FXML
    Slider sliderR;

    @FXML
    Slider sliderG;

    @FXML
    Slider sliderB;

    @FXML
    Slider sliderOpacity;

    @FXML
    Button brushButton;

    @FXML
    Button eraserButton;

    @FXML
    Button thicknessButton;

    @FXML
    Label colorLabel;

    @FXML
    MenuItem saveCase;

    @FXML
    MenuItem loadCase;

    @FXML
    MenuItem clearCase;

   private int red = 0;
   private int green = 0;
   private int blue = 0;
   private double opacity = 1.0;

   private int i = 1;







    @FXML
    public void initialize(){


//        canvas.widthProperty().bind(pane.widthProperty());
//        canvas.heightProperty().bind(pane.heightProperty());
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

        initSlider(red, green, blue);

        addSliderListeners(gc);
        addCanvasListeners(gc);
        addButtonsListeners(gc);
        addMenuBarListeners(gc);

    }



    private void initDrawImage(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();



        Image bgImage;
        double bgX, bgY, bgW = 100.0, bgH = 100.0;

        bgImage = new Image(getClass().getResourceAsStream("/ai152/pasibayeva/res/imgs/BLUE.png"));
        bgX = canvasWidth/2 - bgW/2;
        bgY = canvasHeight/2 - bgH/2;


        gc.drawImage(bgImage, bgX, bgY, bgW, bgH);



    }

    private void clearCanvas(GraphicsContext gc){

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

    private void addSliderListeners(GraphicsContext gc){

          sliderR.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        red = newValue.intValue();
        gc.setStroke(Color.rgb(red,green,blue,opacity));
        colorLabel.setBackground(new Background(new BackgroundFill(Color.rgb(red,green,blue), CornerRadii.EMPTY, Insets.EMPTY)));
    });

    sliderG.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        green = newValue.intValue();
        gc.setStroke(Color.rgb(red,green,blue,opacity));
        colorLabel.setBackground(new Background(new BackgroundFill(Color.rgb(red,green,blue), CornerRadii.EMPTY, Insets.EMPTY)));
    });

    sliderB.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        blue = newValue.intValue();
        gc.setStroke(Color.rgb(red,green,blue,opacity));
        colorLabel.setBackground(new Background(new BackgroundFill(Color.rgb(red,green,blue), CornerRadii.EMPTY, Insets.EMPTY)));
    });

    sliderOpacity.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        opacity = newValue.doubleValue();
        gc.setStroke(Color.rgb(red,green,blue,opacity));
    });

    }

    private void addCanvasListeners( GraphicsContext gc) {

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                event -> {
                    gc.beginPath();
                    gc.moveTo(event.getX(), event.getY());
                    gc.stroke();
                });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                event -> {
                    gc.lineTo(event.getX(), event.getY());
                    gc.stroke();
                });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                event -> {

                });
    }

    private  void initSlider(int red, int green, int blue){

        sliderR.setMin(0);
        sliderR.setMax(255);
        sliderR.setValue(red);


        sliderG.setMin(0);
        sliderG.setMax(255);
        sliderG.setValue(green);


        sliderB.setMin(0);
        sliderB.setMax(255);
        sliderB.setValue(blue);

        sliderOpacity.setMin(0.0);
        sliderOpacity.setMax(1.0);
        sliderOpacity.setValue(opacity);

        colorLabel.setBackground(new Background(new BackgroundFill(Color.rgb(red,green,blue), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void addButtonsListeners(GraphicsContext gc){
        eraserButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            sliderR.setDisable(true);
            sliderG.setDisable(true);
            sliderB.setDisable(true);
            sliderOpacity.setDisable(true);

            gc.setStroke(Color.rgb(255, 244, 244));
        });


        brushButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            sliderR.setDisable(false);
            sliderG.setDisable(false);
            sliderB.setDisable(false);
            sliderOpacity.setDisable(false);

            gc.setStroke(Color.rgb(red, green, blue));
        });



        thicknessButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {

            i+=2;

            if(i>=10){
                i=1;
            }

            gc.setLineWidth(i);
        });



    }

    private void addMenuBarListeners(GraphicsContext gc){

        loadCase.setOnAction(event -> {

            initDrawImage(gc);

        });

        saveCase.setOnAction(event -> {

            saveImg();

        });

        clearCase.setOnAction(e->{

            clearCanvas(gc);

        });



    }



}

