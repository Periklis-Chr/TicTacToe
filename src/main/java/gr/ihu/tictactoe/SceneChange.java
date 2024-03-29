package gr.ihu.tictactoe;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneChange {
    private static Stage Stage = MainApplication.StageS;

    public static void init() throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/signin_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580, "#Hbox");
        Stage.initStyle(StageStyle.UNDECORATED);
        Stage.setTitle("TicTacToe!");
        Stage.setScene(scene);
        Stage.show();
        Stage.getIcons().add(new Image(MainApplication.class.getResourceAsStream("image/tic-tac-toe.png")));
    }

    public static void toRegister() throws Exception {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/signup_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580, "#Hbox");
        Stage.setScene(scene);
    }

    public static void toGame() throws IOException {

        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/Game_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580, "#Hbox");
        Stage.setTitle("TicTacToe!");
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.5;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.5;
        Stage.setX(x);
        Stage.setY(y);
        Stage.setScene(scene);
        Stage.show();
    }

    public static void toLogin() throws Exception {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/signin_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580, "#Hbox");
        Stage.setScene(scene);
    }

    public static void toMenu() throws Exception {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("fxml/menu_view.fxml"));
        Scene scene = new ScenesSet(root, 1024, 580, "#Hbox");
        Stage.setScene(scene);
    }
}
