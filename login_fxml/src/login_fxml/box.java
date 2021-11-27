/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_fxml;

import org.fxyz3d.shapes.primitives.CuboidMesh;

/**
 *
 * @author User
 */
public class box extends CuboidMesh{
    private int state = 5;
    
    box(float w,float h,float d){
        super(w, h, d);
    }
    public void setState(int s){
        state= s;
    }
    public int getState(){
        return state;
    }
}
