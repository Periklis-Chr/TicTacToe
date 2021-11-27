/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package login_fxml;

import java.util.concurrent.TimeUnit;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.fxyz3d.shapes.primitives.CuboidMesh;
/**
 *
 * @author asus
 */
public class Login_fxml extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
       PerspectiveCamera camera = new PerspectiveCamera(true);
        
        //scene.setCamera(camera);
        stage.setScene(scene);
        scene.setFill(Color.web("#324ea8"));
        stage.setWidth(1000);
        stage.setHeight(500);
        stage.show();
        /**camera.translateZProperty().set(-900);
        camera.setNearClip(0.1);
        camera.setFarClip(2000);
        camera.setLayoutX(250);
        camera.setLayoutY(-100);
        camera.setFieldOfView(40);
        camera.setRotationAxis(Rotate.Y_AXIS);
        camera.setRotate(10.0);
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-25.0);**/
        //Rotate r = new Rotate(10,Rotate.Y_AXIS); 
        //camera.getTransforms().add(r);
        //r = new Rotate(-25,Rotate.X_AXIS);
        //camera.getTransforms().add(r);
     /**   PointLight light = (PointLight) scene.lookup("#light");
        light.setColor(Color.AQUA);
        PerspectiveCamera camera = (PerspectiveCamera) scene.lookup("#camera");;
        scene.setCamera(camera);*/
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        
    }
    
}
