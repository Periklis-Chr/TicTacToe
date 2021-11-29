/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package login_fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    
    BoxQ boxes[][] = new BoxQ[3][3];
    
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
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        int gap = 30;
        int startx = 0;
        int starty = 0;
        float x = 100f;
        
       
        //create 
        MatrixBoxes matrix = new MatrixBoxes(gap,startx,starty,x);
        Group group = matrix.getGroup();
        anchorPane2.getChildren().add(group);
        
        boxes =  matrix.getBoxes();
        
        
        Button button = new Button();
        button.setOnMouseClicked((new EventHandler<MouseEvent>() { 
                    public void handle(MouseEvent event) { 
                        for (int i = 0; i<3; i++){
                            for (int j = 0; j<3; j++){
                                System.out.print(boxes[i][j].getState());
                            }
                            System.out.println();
                        }
                        System.out.println();
                    } 
        }));
        anchorPane.getChildren().add(button);
        

    
    }
        
    
}
