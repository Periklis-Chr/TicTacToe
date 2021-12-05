package gr.ihu.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApplication extends Application {
    public static Stage StageS;
    @Override
    public void start(Stage primaryStage) throws Exception{
        StageS = primaryStage;
        Parent root =FXMLLoader.load(getClass().getResource("fxml/signin_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580,"#Hbox");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("TicTacToe!");
        primaryStage.setScene(scene);
        primaryStage.show();
          
//          
        
    }

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