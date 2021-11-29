/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import javafx.animation.Animation.Status;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class move {
    static SequentialTransition seq;
    static RotateTransition rtS;
    public static void doMove(BoxQ boxS,BoxQ[][] boxes){
        
        RotateTransition rt = new RotateTransition(Duration.millis(1000), boxS);
        rtS = rt;
        try {
            System.out.println(rtS.getStatus());
            if(seq.getStatus().equals(Status.RUNNING)|| rtS.getStatus().equals((Status.RUNNING))){
                return;
            }

        } catch (Exception ex) {
        }
        
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
    }
    public static void endGame(BoxQ boxes[][],BoxQ boxS){
        score();
        RotateTransition rtB = new RotateTransition(Duration.millis(1000), boxS);
        rtB.setAxis(Rotate.X_AXIS);
        if(boxS.getState().equals("X")){
            rtB.setByAngle(90);
        }
        else{
            rtB.setByAngle(-90);
        }
        ParallelTransition p = new ParallelTransition();

        SequentialTransition s = new SequentialTransition(rtB,p);
        seq = s;
        
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
        boolean X1 = boxes[0][0].getState().equals(boxes[1][1].getState()) && boxes[0][0].getState().equals(boxes[2][2].getState()) && !boxes[0][0].getState().equals(" ");
        boolean X2 = boxes[0][2].getState().equals(boxes[1][1].getState()) && boxes[0][2].getState().equals(boxes[2][0].getState()) && !boxes[0][2].getState().equals(" ");
        for (int i = 0; i<3; i++){
            boolean row = 
                boxes[i][0].getState().equals(boxes[i][1].getState()) && boxes[i][0].getState().equals(boxes[i][2].getState()) && !boxes[i][0].getState().equals(" ");
            boolean collumn = 
                boxes[0][i].getState().equals(boxes[1][i].getState()) && boxes[0][i].getState().equals(boxes[2][i].getState()) && !boxes[0][i].getState().equals(" ");
            
            
            if(row){
                
                if(boxes[i][0].getState().equals("X")){
                    System.out.println("X won");
                    Info.scoreX++;
                    Info.won = "X";
                    Info.turn = "O";
                    
                }
                else if(boxes[i][0].getState().equals("O")){
                    System.out.println("O won");
                    Info.scoreO++;
                    Info.won = "O";
                    Info.turn = "X";
                }
 
                return true;
            
            }
            if(collumn){
                
                if(boxes[0][i].getState().equals("X")){
                    System.out.println("X won");
                    Info.scoreX++;
                    Info.won = "X";
                    Info.turn = "O";
                    
                }
                else if(boxes[0][i].getState().equals("O")){
                    System.out.println("O won");
                    Info.scoreO++;
                    Info.won = "O";
                    Info.turn = "X";
                }
                return true;
                
            }

        
        }
        
        if(X1){
                if(boxes[0][0].getState().equals("X")){
                    System.out.println("X won");
                    Info.scoreX++;
                    Info.won = "X";
                    Info.turn = "O";
                    
                }
                else if(boxes[0][0].getState().equals("O")){
                    System.out.println("O won");
                    Info.scoreO++;
                    Info.won = "O";
                    Info.turn = "X";
                }
                return true;
                
        }
        
        if(X2){
                if(boxes[0][2].getState().equals("X")){
                    System.out.println("X won");
                    Info.scoreX++;
                    Info.won = "X";
                    Info.turn = "O";
                    
                }
                else if(boxes[0][2].getState().equals("O")){
                    System.out.println("O won");
                    Info.scoreO++;
                    Info.won = "O";
                    Info.turn = "X";
                }
                return true;
                
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
    public static void score(){
        Text scoreX = (Text) Login_fxml.scene.lookup("#XScore");
        scoreX.setText(String.valueOf(Info.scoreX));
        Text scoreO = (Text) Login_fxml.scene.lookup("#OScore");
        scoreO.setText(String.valueOf(Info.scoreO));
    }
}
