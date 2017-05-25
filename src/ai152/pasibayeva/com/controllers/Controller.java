package ai152.pasibayeva.com.controllers;

import ai152.pasibayeva.com.entities.Buttons;
import ai152.pasibayeva.com.entities.MyCanvas;
import ai152.pasibayeva.com.entities.MyMenuBar;
import ai152.pasibayeva.com.entities.Sliders;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


/**
 * Created by Ольга on 07.04.2017.
 */
public class Controller  {

    @FXML
    Canvas canvas;

    @FXML
    AnchorPane canvasAnchorPane;

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

    @FXML
    public void initialize(){

        MyCanvas myCanvas = new MyCanvas(canvas, canvasAnchorPane);
        GraphicsContext gc = myCanvas.getGc();
        Sliders sliders = new Sliders(sliderR, sliderG, sliderB,sliderOpacity ,colorLabel, gc );
        Buttons btns = new Buttons(brushButton, eraserButton, thicknessButton,gc );
        MyMenuBar menuBar = new MyMenuBar(clearCase,loadCase,saveCase,myCanvas.getCanvas());




        myCanvas.addCanvasListeners();
        sliders.addSliderListeners(gc);
        btns.addButtonsListeners(gc,sliders.getrSlider(), sliders.getgSlider(),sliders.getbSlider(),sliders.getOpacitySlider(),sliders.getRed(), sliders.getGreen(), sliders.getBlue());
        menuBar.addMenuBarListeners();

    }








}

