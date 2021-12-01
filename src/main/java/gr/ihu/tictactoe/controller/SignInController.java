package gr.ihu.tictactoe.controller;

import gr.ihu.tictactoe.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private AnchorPane signin_view;

    private Stage stage = null;

    @FXML
    private void minimizedWindow(MouseEvent event) {
        stage = (Stage) signin_view.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    public void openSignUp(ActionEvent actionEvent) throws IOException {
        Stage main = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
        main.initStyle(StageStyle.TRANSPARENT);
        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            main.setX(event.getScreenX() - xOffset);
            main.setY(event.getScreenY() - yOffset);
        });
        main.setTitle("TicTacToe");
        main.setScene(scene);
        main.show();
    }

    static double xOffset = 0;
    static double yOffset = 0;
}