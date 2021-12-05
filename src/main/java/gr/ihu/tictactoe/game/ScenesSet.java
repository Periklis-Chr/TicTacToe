/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.ihu.tictactoe.game;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import gr.ihu.tictactoe.*;
/**
 *
 * @author User
 */
public class ScenesSet extends Scene{
    private double xOffset = 0;
    private double yOffset = 0;
    ScenesSet(Parent root){
        super(root, 600 + 50*2, 450 + 50*2, false, SceneAntialiasing.BALANCED);
    }
    ScenesSet(Parent root,String top){
        super(root, 600 + 50*2, 450 + 50*2, false, SceneAntialiasing.BALANCED);
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
            }
        }));
    }
    
    
}
