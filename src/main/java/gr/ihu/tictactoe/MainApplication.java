package gr.ihu.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/signin_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
        stage.initStyle(StageStyle.UNDECORATED);

        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    static double xOffset = 0;
    static double yOffset = 0;

    public static void main(String[] args) {
        launch();
    }
}