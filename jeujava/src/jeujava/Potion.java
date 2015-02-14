package jeujava;

import java.util.ArrayList;

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
