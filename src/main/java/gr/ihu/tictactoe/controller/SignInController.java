package gr.ihu.tictactoe.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import gr.ihu.tictactoe.DataBaseConnection;
import gr.ihu.tictactoe.MainApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;


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
    //SignUpButtonOnAction
//    public void SignUpButtonOnAction(ActionEvent event) throws IOException {
////        try {
////            Stage registerStage = new Stage();
////            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
////            Scene scene = new Scene(fxmlLoader.load());
////            registerStage.initStyle(StageStyle.UNDECORATED);
////            registerStage.setTitle("SignUp_TicTacToe");
////            registerStage.setScene(scene);
////            registerStage.show();
////        }
////        catch (Exception e){
////            e.printStackTrace();
////            e.getCause();
////        }
//    }

    public void SignInButtonOnAction(ActionEvent event) {
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

    public void SignUpButtonOnAction(ActionEvent event) throws IOException{
        //try {
//            Stage registerStage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("fxml/signup_view.fxml"));
//            Scene scene = new Scene(root, 1024, 580);
//            registerStage.initStyle(StageStyle.UNDECORATED);
//            registerStage.setTitle("TicTacToe!");
//            registerStage.setScene(scene);
//            registerStage.show();
            Stage main = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signup_view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
            main.initStyle(StageStyle.TRANSPARENT);
            main.setTitle("TicTacToe");
            main.setScene(scene);
            main.show();


            scene.setOnMousePressed((MouseEvent mouseEvent) -> {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            });
            scene.setOnMouseDragged((MouseEvent mouseEvent) -> {
                main.setX(mouseEvent.getScreenX() - xOffset);
                main.setY(mouseEvent.getScreenY() - yOffset);
            });
        //}
//        catch (Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
    }
        static double xOffset = 0;
        static double yOffset = 0;
    }
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
//
//    static double xOffset = 0;
//    static double yOffset = 0;
//}