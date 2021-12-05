package gr.ihu.tictactoe;

import javafx.application.Application;

import javafx.stage.Stage;


public class MainApplication extends Application {
    public static Stage StageS;
    @Override
    public void start(Stage primaryStage) throws Exception{
        StageS = primaryStage;
        SceneChange.init();
        
    }

    public static void main(String[] args) {
        launch();
    }
}