/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;

/**
 *
 * @author User
 */
public class ScenesSet extends Scene{
    ScenesSet(Parent root){
        super(root, 600 + 50*2, 450 + 50*2, false, SceneAntialiasing.BALANCED);
    }
    
    
}
