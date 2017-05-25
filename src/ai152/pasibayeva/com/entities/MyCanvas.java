package ai152.pasibayeva.com.entities;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Created by antipavitaly on 5/25/17.
 */
public class MyCanvas {

    private Canvas canvas;
    private GraphicsContext gc;

    public MyCanvas(Canvas canvas, AnchorPane canvasAnchorPane) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        bindCanvas(canvasAnchorPane);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void bindCanvas(AnchorPane canvasAnchorPane){
        canvas.widthProperty().bind(canvasAnchorPane.widthProperty());
        canvas.heightProperty().bind(canvasAnchorPane.heightProperty());
    }

    public void addCanvasListeners( ) {

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
}
