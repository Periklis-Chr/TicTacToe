package gr.ihu.tictactoe.controller;

import gr.ihu.tictactoe.DataBaseConnection;
import javafx.fxml.FXML;

import javafx.stage.Stage;
import javafx.application.Platform;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import gr.ihu.tictactoe.ScenesSet;
import gr.ihu.tictactoe.MainApplication;
import gr.ihu.tictactoe.SceneChange;

import java.sql.Statement;
import java.sql.Connection;

import java.util.regex.Pattern;

public class SignUpController {

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

    private String regexPattern = "^(.+)@(\\S+)$";

    @FXML
    private void minimizedWindow(MouseEvent event) {
        Stage stage = new Stage();
        stage = (Stage) signUp_view.getScene().getWindow();
        stage.setIconified(true);
        testUsingSimpleRegex();
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        Platform.exit();
    }

    @FXML
    private void clearbox(MouseEvent event) {
        TextField text = ((TextField) event.getSource());
        text.setStyle("-fx-border-color: red ;");
        setError("");

    }

    public void RegisterButtonOnAction() throws Exception {
        boolean anyEmpty = setFirstName.getText().equals("") ||
                setLastName.getText().equals("") ||
                setEmail.getText().equals("") ||
                setUserName.getText().equals("") ||
                setPassword.getText().equals("") ||
                setConfirmPassword.getText().equals("");

        if (anyEmpty) {
            if (setFirstName.getText().equals("")) {
                setFirstName.setStyle("-fx-border-color: red;");

            }
            if (setLastName.getText().equals("")) {
                setLastName.setStyle("-fx-border-color: red;");
            }
            if (setEmail.getText().equals("")) {
                setEmail.setStyle("-fx-border-color: red;");

            }
            if (setUserName.getText().equals("")) {
                setUserName.setStyle("-fx-border-color: red;");

            }
            if (setPassword.getText().equals("")) {
                setPassword.setStyle("-fx-border-color: red;");

            }
            if (setConfirmPassword.getText().equals("")) {
                setConfirmPassword.setStyle("-fx-border-color: red;");

            }
            setError("Fill the Blanks");
            return;
        }
        if (patternMatches(setEmail.getText(), regexPattern)) {
            if (setPassword.getText().equals(setConfirmPassword.getText())) {
                registerUser();
                SceneChange.toLogin();

            } else {
                setConfirmPassword.setStyle("-fx-border-color: red;");
                setError("Not Matching Password");
            }
        } else {
            setError("Incorect Email");
        }
    }

    public void registerUser() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = setFirstName.getText();
        String lastName = setLastName.getText();
        String Email = setEmail.getText();
        String Username = setUserName.getText();
        String Password = setPassword.getText();

        String insertFields = "insert into user_account (firstname, lastname, email, username, pass) value ('";
        String insertValues = firstName + "', '" + lastName + "', '" + Email + "', '" + Username + "', '" + Password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("User has been registered successfully!");
            //System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public void testUsingSimpleRegex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(.+)@(\\S+)$";
        if (patternMatches(emailAddress, regexPattern)) {
            System.out.println("YES");
        }
    }

    public void setError(String error) {
        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(error);
    }
}
