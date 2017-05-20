package ai152.pasibayeva;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Ольга on 25.04.2017.
 */
public class BrushButton {
    public BrushButton(Object o, ImageView imageView) {
        Image BrushButtonImage = new Image(getClass().getResourceAsStream("brush1.png"));
        BrushButton BrushButton = new BrushButton("", new ImageView(BrushButtonImage));
    }
}
