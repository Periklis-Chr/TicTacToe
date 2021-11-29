/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package login_fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author asus
 */
public class Login_fxml extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        stage(stage);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        
    }
    
    public void stage(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.setFill(Color.web("#324ea8"));
        stage.setWidth(1500);
        stage.setHeight(900);
        stage.show();
    }
    
}
