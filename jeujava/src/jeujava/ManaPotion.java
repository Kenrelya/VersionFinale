package jeujava;

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
