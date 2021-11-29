/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class move {
    public static void doMove(BoxQ boxS,BoxQ[][] boxes){
        RotateTransition rt = new RotateTransition(Duration.millis(1000), boxS);
        
        
        if(boxS.getState().equals(" ") && Info.turn.equals("X")){
            boxS.setState("X");
            if(hasWon(boxes)){
                endGame(boxes,boxS);
                
            }
            else{
                rt.setAxis(Rotate.X_AXIS);
                rt.setByAngle(90);
                rt.play();
                Info.turn = "O";
            }
        }
        else if(boxS.getState().equals(" ") && Info.turn.equals("O")){
            boxS.setState("O");
            if(hasWon(boxes)){
                endGame(boxes,boxS);
                
            }
            else{
                rt.setAxis(Rotate.X_AXIS);
                rt.setByAngle(-90);
                rt.play();
                Info.turn = "X";
            }
        }
        
        //System.out.println(boxS.getState());
       // System.out.println();
    }
    public static void endGame(BoxQ boxes[][],BoxQ boxS){
        RotateTransition rtB = new RotateTransition(Duration.millis(1000), boxS);
        rtB.setAxis(Rotate.X_AXIS);
        if(boxS.getState().equals("X")){
            rtB.setByAngle(90);
        }
        else{
            rtB.setByAngle(-90);
        }
        
//        RotateTransition rtBE = new RotateTransition(Duration.millis(1000), boxS);
//        
//        boxS.setState(" ");
//        rtBE.setAxis(Rotate.X_AXIS);
//        rtBE.setByAngle(-90);
        ParallelTransition p = new ParallelTransition();

        SequentialTransition s = new SequentialTransition(rtB,p);
        
         for (int i=0;i<boxes.length;i++){
                for (int j=0;j<boxes[i].length;j++){
                    RotateTransition rt = new RotateTransition(Duration.millis(1000), boxes[i][j]);
                    p.getChildren().add(rt);
                    
                    
                        if(boxes[i][j].getState().equals("X")){
                            boxes[i][j].setState(" ");
                            rt.setAxis(Rotate.X_AXIS);
                            rt.setByAngle(-90);
                            
                        }
                        else if(boxes[i][j].getState().equals("O")){
                            boxes[i][j].setState(" ");
                            rt.setAxis(Rotate.X_AXIS);
                            rt.setByAngle(90);
                        }

                }

            }
        s.play();
        
        
    }
    public static boolean hasWon(BoxQ boxes[][]){
        for (int i = 0; i<3; i++){
            if(boxes[i][0].getState().equals(boxes[i][1].getState()) && boxes[i][0].getState().equals(boxes[i][2].getState()) && !boxes[i][0].getState().equals(" ")){
                
                if(boxes[i][0].getState().equals("X")){
                    System.out.println("X won");
                    Info.won = "X";
                    Info.turn = "O";
                    
                }
                else{
                    System.out.println("O won");
                    Info.won = "O";
                    Info.turn = "X";
                }
                return true;
            
            }
        
        }
        for (int i = 0; i<3; i++){
            for(int j=0;j<3;j++){
                if(boxes[i][j].getState().equals(" ")){
                    return false;
                    
                }
            }
            
        }
        System.out.println("NONE won");
        Info.won = "NONE";
        return true;

    }
}
