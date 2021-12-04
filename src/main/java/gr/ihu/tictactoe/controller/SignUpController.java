package gr.ihu.tictactoe.controller;

import gr.ihu.tictactoe.DataBaseConnection;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.sql.Connection;
import java.sql.Statement;

public class SignUpController{

    @FXML
    private AnchorPane signUp_view;
    @FXML
    private Button RegisterButton;
    @FXML
    private TextField setFirstName;
    @FXML
    private TextField setLastName;
    @FXML
    private TextField setEmail;
    @FXML
    private TextField setUserName;
    @FXML
    private PasswordField setPassword;
    @FXML
    private PasswordField setConfirmPassword;
    @FXML
    private ImageView registerImageView;
    @FXML
    private Label messageLabel;

    @FXML
    private void minimizedWindow(MouseEvent event) {
        Stage stage = new Stage();
        stage = (Stage) signUp_view.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        Platform.exit();
    }

    public void RegisterButtonOnAction(){
        if(setPassword.getText().equals(setConfirmPassword.getText())){
            registerUser();
        }
        else{
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Password does not match");
        }
    }

    public void registerUser(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = setFirstName.getText();
        String lastName = setLastName.getText();
        String Email = setEmail.getText();
        String Username = setUserName.getText();
        String Password = setPassword.getText();

        String insertFields = "insert into user_account (firstname, lastname, email, username, pass) value ('";
        String insertValues = firstName + "', '" + lastName + "', '" + Email + "', '" + Username + "', '" + Password + "')" ;
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("User has been registered successfully!");
            System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
