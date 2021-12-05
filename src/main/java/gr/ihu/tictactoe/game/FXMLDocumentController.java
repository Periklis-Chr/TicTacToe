/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package gr.ihu.tictactoe.game;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    
    BoxQ boxes[][] = new BoxQ[3][3];
    
    private Label label;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private HBox Hbox2;
    @FXML
    private Text XScore;
    @FXML
    private Text OScore;
    
    private void boxonclick(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    private void boxAction(){
        
    }
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        int gap = 60;
        int startx = 0;
        int starty = 0;
        float x = 200f;
        //create
        MatrixBoxes matrix;
        try {
            matrix = new MatrixBoxes(gap,startx,starty,x);
            Group group = matrix.getGroup();
            anchorPane2.getChildren().add(group);
            boxes =  matrix.getBoxes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
        
    
}
