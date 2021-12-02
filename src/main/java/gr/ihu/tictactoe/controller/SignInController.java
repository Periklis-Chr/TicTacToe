package gr.ihu.tictactoe.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import gr.ihu.tictactoe.DataBaseConnection;
import gr.ihu.tictactoe.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class SignInController implements Initializable {

    @FXML
    private Button SignUpButton;
    @FXML
    private Button SignInButton;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;

    public void SignUpButtonAction(ActionEvent event) throws IOException {
        try {
            Stage registerStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setTitle("SignUp_TicTacToe");
            registerStage.setScene(scene);
            registerStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void SignInButtononAction(ActionEvent event){
        messageLabel.setText("You try to login!");
        if (textField.getText().isBlank() == false && passwordField.getText().isBlank() == false){
            messageLabel.setText("You try to login!");
            validateLogin();
        }
        else {
            messageLabel.setText("Please enter your usename and password!");
        }
    }




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

    private void validateLogin() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "";
    }


//    public void openSignUp(ActionEvent actionEvent) throws IOException {
//        Stage main = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
//        main.initStyle(StageStyle.TRANSPARENT);
//
//        scene.setOnMousePressed((MouseEvent event) -> {
//            xOffset = event.getSceneX();
//            yOffset = event.getSceneY();
//        });
//        scene.setOnMouseDragged((MouseEvent event) -> {
//            main.setX(event.getScreenX() - xOffset);
//            main.setY(event.getScreenY() - yOffset);
//        });
//        main.setTitle("TicTacToe");
//        main.setScene(scene);
//        main.show();
//    }

    static double xOffset = 0;
    static double yOffset = 0;
}