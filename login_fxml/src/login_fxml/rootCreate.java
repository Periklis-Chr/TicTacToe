/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static login_fxml.Login_fxml.stageS;

/**
 *
 * @author User
 */
public class rootCreate{
    
    private double xOffset = 0;
    private double yOffset = 0;
    Parent root;
    rootCreate(String res) throws IOException{
        root = FXMLLoader.load(getClass().getResource(res));  
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageS.setX(event.getScreenX() - xOffset);
                stageS.setY(event.getScreenY() - yOffset);
            }
        });
    }
    public Parent getRoot(){
        return root;
    }
    
        
        
    
}
