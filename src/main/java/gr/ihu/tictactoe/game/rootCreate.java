/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.ihu.tictactoe.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * @author User
 */
public class rootCreate {
    Parent root;

    rootCreate(String res) throws IOException {
        root = FXMLLoader.load(getClass().getResource(res));

    }

    public Parent getRoot() {
        return root;
    }


}
