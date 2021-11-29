/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package login_fxml;

import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import org.fxyz3d.shapes.primitives.CuboidMesh;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    private box box[][] = new box[3][3];
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private AnchorPane anchorPane2;
    
    @FXML
    private VBox vbox;
    @FXML
    private Pane pane;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    private void boxonclick(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    private void boxAction(){
        
    }
    public box[][] getBox(){
            return box;
    }
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        int gap = 60;
        int startx = 0;
        int starty = 0;
        float x = 100f;
        
        qubes(gap,startx,starty,x);
        
        Button button = new Button();
        //button.setLayoutX(-200);
        button.setOnMouseClicked((new EventHandler<MouseEvent>() { 
                    public void handle(MouseEvent event) { 
                        for (int i = 0; i<3; i++){
                            for (int j = 0; j<3; j++){
                                System.out.print(box[i][j].getState());
                            }
                            System.out.println();
                        }
                        System.out.println();
                    } 
        }));
        anchorPane.getChildren().add(button);
        

    
    }
    private void qubes(int gap,int startx,int starty, float size){
        boxes(gap,startx,starty,size,size,size);
    }
    private void boxes(int gap,int startx,int starty, float x,float y, float z){
        netMaterial material = new netMaterial();
        
        
        Group group = new Group();
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                box[i][j]= new box(x, y, z);
                box[i][j].setLayoutX(startx);
                box[i][j].setLayoutY(starty);
                
                startx = startx + (int)x + gap;
                
                box[i][j].setMaterial(material);
                group.getChildren().add(box[i][j]);
                RotateTransition rt = new RotateTransition(Duration.millis(1000), box[i][j]);
                box boxS = box[i][j];
                box[i][j].setOnMouseClicked((new EventHandler<MouseEvent>() { 
                    public void handle(MouseEvent event) { 
                    rt.setAxis(Rotate.Y_AXIS);
                    rt.setByAngle(180);
                    rt.setAutoReverse(true);
                    rt.play();
                    if(boxS.getState() == 5){
                        boxS.setState(3);
                    }
                    else{
                        boxS.setState(5);
                    }
                    System.out.println(boxS.getState());
                    System.out.println();
                    } 
                }));
            }
            startx = 0;
            starty = starty + (int)y + gap;
        }
        for (int i = 2; i>=0; i--){
            for (int j = 2; j>=0; j--){
                box[i][j].toFront();
            }
        }
        anchorPane2.getChildren().add(group);
        group.setRotationAxis(Rotate.X_AXIS);
        //group.setRotate(20.0);
        group.setRotationAxis(Rotate.Y_AXIS);
       // group.setRotate(50.0);
        Rotate r = new Rotate(-10,150,150,150,Rotate.Y_AXIS);
        group.getTransforms().add(r);
        r = new Rotate(25,150,150,150,Rotate.X_AXIS);
        group.getTransforms().add(r);
        
    }
    
        
    
}
