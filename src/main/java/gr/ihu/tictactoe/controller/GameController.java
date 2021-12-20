package gr.ihu.tictactoe.controller;

import gr.ihu.tictactoe.SceneChange;
import gr.ihu.tictactoe.game.BoxQ;
import gr.ihu.tictactoe.game.MatrixBoxes;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController implements Initializable {

    BoxQ boxes[][] = new BoxQ[3][3];

    private Label label;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private Text XScore;
    @FXML
    private Text OScore;
    @FXML
    private Button backMenu;

    @FXML
    private void minimizedWindow(MouseEvent event) {
        Stage stage = new Stage();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        Platform.exit();
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        int gap = 20;
        int startx = 0;
        int starty = 0;
        float x = 100f;
        //create
        MatrixBoxes matrix;
        try {
            matrix = new MatrixBoxes(gap, startx, starty, x);
            Group group = matrix.getGroup();
            anchorPane2.getChildren().add(group);
            boxes = matrix.getBoxes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toClickBackMenu(ActionEvent event) throws Exception {
        SceneChange.toMenu();

    }


}
