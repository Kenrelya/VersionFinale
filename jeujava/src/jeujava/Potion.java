/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeujava;

import java.util.ArrayList;

/**
 *
 * @author Kenrelya
 */
public class Potion extends Item{

    public Potion() {
        this.name = "potion";
    }

    
    @Override
    public  String getName(){
		
		return this.name;
	}
    
    @Override
    public void use(Playable player){
        if(player.hp<=player.hpMax-20){
            player.hp +=20;
            player.getBag().remove(this);
        }
        else if (player.hp == player.hpMax){
            System.out.println("I am already full hp");
        }
        else{
            player.hp = player.hpMax;
            player.getBag().remove(this);
        }
        
        
    }
    
   
}
