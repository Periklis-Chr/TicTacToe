package gr.ihu.tictactoe.controller;

import gr.ihu.tictactoe.MainApplication;
import gr.ihu.tictactoe.SceneChange;
import gr.ihu.tictactoe.ScenesSet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class menuController implements Initializable{

    @FXML
    private AnchorPane main_menu;
    @FXML
    private HBox Hbox;
    @FXML
    private Button btnMainMenu;
    @FXML
    private Button btnGame;
    @FXML
    private Button btnDevelopers;
    @FXML
    private Button btnInformation;
    @FXML
    private Button btnPlay;
    @FXML
    private GridPane developersPane;
    @FXML
    private GridPane gamePane;
    @FXML
    private GridPane mainMenuPane;
    @FXML
    private GridPane informationPane;
    @FXML

    private Pane gamePlayTheGamePane;
    @FXML
    private Hyperlink link1;
    @FXML
    private Hyperlink link2;
    @FXML
    private Hyperlink link3;

    @FXML
    private void minimizedWindow(MouseEvent event) {
        Stage stage = new Stage();
        stage = (Stage) main_menu.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        Platform.exit();
    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        if (event.getSource() == btnMainMenu) {
            mainMenuPane.toFront();
        } else if (event.getSource() == btnGame) {
            gamePane.toFront();
        } else if (event.getSource() == btnDevelopers) {
            developersPane.toFront();
        } else if (event.getSource() == btnInformation) {
            informationPane.toFront();
        }
    }

    @FXML
    private void onClickPlay(ActionEvent event) throws IOException {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        Parent root;
        try {
            root = FXMLLoader.load(MainApplication.class.getResource("fxml/Game_view.fxml"));
            Scene scene = new ScenesSet(root, 796, 441);
            gamePlayTheGamePane.getChildren().add(scene.getRoot());
        } catch (IOException ex) {
            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
//    public void onClickHyper(){
//    Hyperlink link = new Hyperlink();
//    link.setText("http://example.com");
//    link.setOnAction(new EventHandler<ActionEvent>() {
//        //Hyperlink()
//        @Override
//        public void handle(ActionEvent e) {
//            System.out.println("This link is clicked");
//        }
//    })};


}
