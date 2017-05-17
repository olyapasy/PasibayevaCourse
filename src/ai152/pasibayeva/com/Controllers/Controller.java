package ai152.pasibayeva.com.Controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
    Button brushButton;

    @FXML
    Button eraserButton;

    @FXML
    Button thicknessButton;

    @FXML
    public void initialize(){

//        canvas.widthProperty().bind(pane.widthProperty());
//        canvas.heightProperty().bind(pane.heightProperty());

//        Image imageDecline = new Image(getClass().getResourceAsStream("/ai152/pasibayeva/res/imgs/image.png"));
//        brushButton = new Button();

//        brushButton.setGraphic(new ImageView(imageDecline));

        GraphicsContext gc = canvas.getGraphicsContext2D();
        initDraw(gc);

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




    private void initDraw(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);

        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle



    }



}

