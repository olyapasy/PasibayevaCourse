package ai152.pasibayeva.com.entities;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Created by Ольга on 25.04.2017.
 */
public class Buttons{

    private Button brushButton;
    private Button eraserButton;
    private Button thicknessButton;

    private int i = 1;



    public Buttons(Button brushButton, Button eraserButton, Button thicknessButton, GraphicsContext gc) {
        this.brushButton = brushButton;
        this.eraserButton = eraserButton;
        this.thicknessButton = thicknessButton;

    }

    public void addButtonsListeners(GraphicsContext gc, Slider rSlider, Slider gSlider, Slider bSlider,Slider opacitySlider, int red, int green, int blue){
        eraserButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            rSlider.setDisable(true);
            gSlider.setDisable(true);
            bSlider.setDisable(true);
            opacitySlider.setDisable(true);

            gc.setStroke(Color.rgb(255, 244, 244));
        });


        brushButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            rSlider.setDisable(false);
            gSlider.setDisable(false);
            bSlider.setDisable(false);
            opacitySlider.setDisable(false);

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
