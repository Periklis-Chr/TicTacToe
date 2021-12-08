package gr.ihu.tictactoe;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.MouseEvent;

public class ScenesSet extends Scene{
    private double xOffset = 0;
    private double yOffset = 0;
    public ScenesSet(Parent root,float x, float y){
        super(root, x, y, false, SceneAntialiasing.BALANCED);
    }
    public ScenesSet(Parent root,float x, float y,String top){
        super(root, x, y, false, SceneAntialiasing.BALANCED);
        HBox Hbox = (HBox)super.lookup(top);
        Hbox.setOnMousePressed((new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
        }));

        Hbox.setOnMouseDragged((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                MainApplication.StageS.setX(event.getScreenX() - xOffset);
                MainApplication.StageS.setY(event.getScreenY() - yOffset);
                MainApplication.StageS.setOpacity(0.8f);
            }
        }));
        Hbox.setOnMouseReleased((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                MainApplication.StageS.setX(event.getScreenX() - xOffset);
                MainApplication.StageS.setY(event.getScreenY() - yOffset);
                MainApplication.StageS.setOpacity(1.0f);
            }
        }));
    }
    
    
}
