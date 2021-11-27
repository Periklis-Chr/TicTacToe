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
        netMethod netMeth = new netMethod();
        Image net = netMeth.generateNet("1", "2", "3", "4", "5", "6");
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(net);
        
        
        int x = 0;
        int y = 0;
        Group group = new Group();
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                box[i][j]= new box(100f, 100f, 100f);
                box[i][j].setLayoutX(x);
                box[i][j].setLayoutY(y);
                x = x + 150;
                
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
            x = 0;
            y = y + 150;
        }
        Button button = new Button();
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
        anchorPane2.getChildren().add(group);
        group.setRotationAxis(Rotate.Y_AXIS);
        //group.setRotate(20.0);
        
        
        /*RotateTransition rt = new RotateTransition(Duration.millis(3000), group);
                rt.setAxis(Rotate.Y_AXIS);
                rt.setByAngle(360);
                rt.setCycleCount(200);
                rt.setAutoReverse(true);

                rt.play();*/
        //r = new Rotate(50,50,50,50,Rotate.Z_AXIS);
        //anchorPane2.getTransforms().add(r);
        
    
    }
        
    
}
