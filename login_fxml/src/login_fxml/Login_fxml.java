/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package login_fxml;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author asus
 */
public class Login_fxml extends Application {
    public static Stage stageS;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage(stage);
        stageS = stage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        
    }
    
    public void stage(Stage stage) throws Exception{
        
        rootCreate root = new rootCreate("FXMLDocument.fxml");
        ScenesSet scene = new ScenesSet(root.getRoot(),"#hbox2");
        
        stage.setScene(scene);
        scene.setFill(Color.web("#324ea8"));
        stage.setWidth(1500);
        
        stage.setHeight(900);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        
        
        
        
        
    }
    
}
