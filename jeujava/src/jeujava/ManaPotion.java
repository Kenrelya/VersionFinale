/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeujava;

/**
 *
 * @author Kenrelya
 */
public class ManaPotion extends Item{
    
    public ManaPotion(){
    this.name="mana potion";
}

     @Override
    public  String getName(){
		
		return this.name;
	}
    
    @Override
    public void use(Playable player){
        if(player.mana<=player.manamax-10){
            player.mana +=10;
            player.getBag().remove(this);
        }
        else if (player.mana == player.manamax){
            System.out.println("I am already full mana");
        }
        else{
            player.mana = player.manamax;
            player.getBag().remove(this);
        }
        
    
    }
}
