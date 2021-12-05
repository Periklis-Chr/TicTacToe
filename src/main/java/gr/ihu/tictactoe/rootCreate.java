package gr.ihu.tictactoe;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class rootCreate{
    Parent root;
    rootCreate(String res) throws IOException{
        root = FXMLLoader.load(getClass().getResource(res));  
        
    }
    public Parent getRoot(){
        return root;
    }
    
        
        
    
}
