package gr.ihu.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.application.Platform;

import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



import gr.ihu.tictactoe.DataBaseConnection;
import gr.ihu.tictactoe.SceneChange;

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
    private Button btnClose;
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
    @FXML
    private void onClickClose(ActionEvent event) {
        System.exit(0);
        Platform.exit();
    }

    public void SignInButtonOnAction(ActionEvent event) throws Exception {
        //SceneChange.toGame();

        if (UserNameTextField.getText().isBlank() == false && PasswordField.getText().isBlank() == false) {
            messageLabel.setText("You try to login!");
            validateLogin();

        } else {
            messageLabel.setText("Please enter your username and password!");
        }
    }
    boolean bypass= false;
    private void validateLogin() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from user_account.user_account where "
                + "username = '" + UserNameTextField.getText() + "' or "
                + "email = '" + UserNameTextField.getText() + "' and "
                + "pass = '" + PasswordField.getText() + "';";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (bypass  ||  queryResult.getInt(1) == 1 ) {
                    //game
                    messageLabel.setStyle("-fx-text-fill: green");
                    messageLabel.setText("Congratulations!");
                    SceneChange.toMenu();
                } else {
                    messageLabel.setText("Invalid login. Please try again !");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void SignUpButtonOnAction(ActionEvent event) throws Exception {
        SceneChange.toRegister();

    }


}
