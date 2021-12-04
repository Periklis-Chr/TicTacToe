package gr.ihu.tictactoe;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class rootCreate{
    Parent root;
    rootCreate(String res) throws IOException{
        root = FXMLLoader.load(getClass().getResource(res));  
        
    }
    public Parent getRoot(){
        return root;
    }
    
        
        
    
}
