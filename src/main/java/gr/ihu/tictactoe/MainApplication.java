package gr.ihu.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root =FXMLLoader.load(getClass().getResource("fxml/signin_view.fxml"));
        Scene scene = new Scene(root, 1024, 580);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("TicTacToe!");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }

    static double xOffset = 0;
    static double yOffset = 0;

    public static void main(String[] args) {
        launch();
    }
}

//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signin_view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
//        stage.setTitle("TicTacToe!");
//        stage.setScene(scene);
//        stage.show();}
//