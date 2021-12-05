package gr.ihu.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;

import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import javafx.scene.Parent;
import java.io.IOException;
import gr.ihu.tictactoe.ScenesSet;
import gr.ihu.tictactoe.MainApplication;
import gr.ihu.tictactoe.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class SignInController {

    @FXML
    private ImageView loginImageView;
    @FXML
    private Button SignUpButtonOnAction;
    @FXML
    private Button SignInButtonOnAction;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField UserNameTextField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private AnchorPane signIn_view;
    private Stage stage = null;
    @FXML
    private void minimizedWindow(MouseEvent event) {
        stage = (Stage) signIn_view.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        Platform.exit();
    }

    public void SignInButtonOnAction(ActionEvent event) throws IOException {
        toGame();
        
        if (UserNameTextField.getText().isBlank() == false && PasswordField.getText().isBlank() == false) {
            messageLabel.setText("You try to login!");
            validateLogin();
        } else {
            messageLabel.setText("Please enter your username and password!");
        }
    }

    private void validateLogin() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from user_account where username = '" + UserNameTextField.getText() + "' and pass = '" + PasswordField.getText() + "';";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //game
                    messageLabel.setStyle("-fx-text-fill: green");
                    messageLabel.setText("Congratsulation!");
                } else {
                    messageLabel.setText("Invalid login. Please try again !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void SignUpButtonOnAction(ActionEvent event) throws Exception{
         toRegister();
    }
        
    public void toRegister() throws Exception{
        Parent root =FXMLLoader.load(MainApplication.class.getResource("fxml/signup_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580,"#Hbox");
        MainApplication.StageS.setScene(scene);    
//        root =FXMLLoader.load(MainApplication.class.getResource("fxml/FXMLDocument.fxml"));
    }
    public void toGame() throws IOException{
        Parent root =FXMLLoader.load(MainApplication.class.getResource("fxml/FXMLDocument.fxml"));
        Scene scene = new ScenesSet(root, 1500, 900,"#hbox2");
        MainApplication.StageS.setTitle("TicTacToe!");
        MainApplication.StageS.setScene(scene);
        MainApplication.StageS.show();
    }
    
}
