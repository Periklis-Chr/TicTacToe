package gr.ihu.tictactoe.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.sql.Connection;
import java.sql.Statement;

import gr.ihu.tictactoe.*;
import java.util.regex.Pattern;

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

    public void RegisterButtonOnAction() throws Exception {
        boolean anyEmpty = setFirstName.getText().equals("") || 
            setLastName.getText().equals("") || 
            setEmail.getText().equals("") ||
            setUserName.getText().equals("") ||
            setPassword.getText().equals("") ||
            setConfirmPassword.getText().equals("");
        
        if(anyEmpty){
            if(setFirstName.getText().equals("")){

            }
            if(setLastName.getText().equals(" ")){

            }
            if(setEmail.getText().equals(" ")){
                
            }
            setError("Fill the Blanks");
            return;
        }
        if(patternMatches(setEmail.getText(),regexPattern)){
            if(setPassword.getText().equals(setConfirmPassword.getText())){
                registerUser();
                toLogin();

            }
            else{
                setError("Not Matching Password");
            }
        }

        else{
                setError("Incorect Email");
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
            //System.exit(0);
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void toLogin() throws Exception{
        Stage main = new Stage();
        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/signin_view.fxml"));
       // FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580,"#Hbox");
        MainApplication.StageS.setScene(scene);    
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
    
    public void testUsingSimpleRegex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(.+)@(\\S+)$";
        if(patternMatches(emailAddress, regexPattern)){
            System.out.println("YES");
        }
    }
    public void setError(String error){
        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(error);
    }
}
