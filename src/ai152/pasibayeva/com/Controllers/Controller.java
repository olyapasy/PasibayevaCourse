package ai152.pasibayeva.com.Controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 * Created by Ольга on 07.04.2017.
 */
public class Controller {

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
    Button brushButton;

    @FXML
    Button eraserButton;

    @FXML
    Button thicknessButton;

   private int red = 0;
   private int green = 0;
   private int blue = 0;

   private int i = 1;



    @FXML
    public void initialize(){

//        canvas.widthProperty().bind(pane.widthProperty());
//        canvas.heightProperty().bind(pane.heightProperty());


        GraphicsContext gc = canvas.getGraphicsContext2D();

        initDraw(gc);
        initSlider(red, green, blue);

        addSliderListeners(gc);
        addCanvasListeners(gc);
        addButtonsListeners(gc);

    }




    private void initDraw(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.WHITE);

        gc.fill();

        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle

        


    }

    private void addSliderListeners(GraphicsContext gc){

          sliderR.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        red = newValue.intValue();
        gc.setStroke(Color.rgb(red, green, blue));
    });

    sliderG.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        green = newValue.intValue();
        gc.setStroke(Color.rgb(red, green, blue));
    });

    sliderB.valueProperty().addListener((observable, oldValue, newValue) ->
    {
        blue = newValue.intValue();
        gc.setStroke(Color.rgb(red, green, blue));
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
        sliderR.setShowTickLabels(true);
        sliderR.setShowTickMarks(true);

        sliderG.setMin(0);
        sliderG.setMax(255);
        sliderG.setValue(green);
        sliderG.setShowTickLabels(true);
        sliderG.setShowTickMarks(true);

        sliderB.setMin(0);
        sliderB.setMax(255);
        sliderB.setValue(blue);
        sliderB.setShowTickLabels(true);
        sliderB.setShowTickMarks(true);
    }

    private void addButtonsListeners(GraphicsContext gc){
        eraserButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            sliderR.setDisable(true);
            sliderG.setDisable(true);
            sliderB.setDisable(true);

            gc.setStroke(Color.rgb(244, 244, 244));
        });


        brushButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            sliderR.setDisable(false);
            sliderG.setDisable(false);
            sliderB.setDisable(false);

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
}

