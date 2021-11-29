/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class MatrixBoxes {
    private BoxQ boxes[][] = new BoxQ[3][3];
    private Group group = new Group();
    private int gap;
    private int startx;
    private int starty;
    private float x;
    private float y;
    private float z;
    MatrixBoxes(int g,int sx,int sy,float x){
        gap = g;
        startx = sx;
        starty = sy;
        this.x = x;
        this.y = x;
        this.z = x;
        Boxes();
        
    }
    
    MatrixBoxes(int g,int sx,int sy,float x,float y,float z){
        gap = g;
        startx = sx;
        starty = sy;
        this.x = x;
        this.y = y;
        this.z = z;
        Boxes();
    }
    
    public Group getGroup(){
        return group;
    }
    
    public BoxQ[][] getBoxes(){
        return boxes;
    }
    
    public void Boxes(){
        netMaterial material = new netMaterial();
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                boxes[i][j]= new BoxQ(x, y, z);
                boxes[i][j].setLayoutX(startx);
                boxes[i][j].setLayoutY(starty);
                
                startx = startx + (int)x + gap;
                
                boxes[i][j].setMaterial(material);
                group.getChildren().add(boxes[i][j]);
                RotateTransition rt = new RotateTransition(Duration.millis(1000), boxes[i][j]);
                BoxQ boxS = boxes[i][j];
                boxes[i][j].setOnMouseClicked((new EventHandler<MouseEvent>() { 
                    public void handle(MouseEvent event) { 
                    
                    if(boxS.getState().equals(" ") && turn.turn.equals("X")){
                        boxS.setState("X");
                        rt.setAxis(Rotate.X_AXIS);
                        rt.setByAngle(90);
                        rt.play();
                        turn.turn = "O";
                    }
                    else if(boxS.getState().equals(" ") && turn.turn.equals("O")){
                        boxS.setState("O");
                        rt.setAxis(Rotate.X_AXIS);
                        rt.setByAngle(90);
                        rt.setByAngle(-90);
                        rt.play();
                        turn.turn = "X";
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
                boxes[i][j].toFront();
            }
        }
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
