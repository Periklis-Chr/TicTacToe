module gr.ihu.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens gr.ihu.tictactoe to javafx.fxml;
    exports gr.ihu.tictactoe;
    exports gr.ihu.tictactoe.controller;
    opens gr.ihu.tictactoe.controller to javafx.fxml;

}