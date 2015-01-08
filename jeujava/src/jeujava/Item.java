package jeujava;

public abstract class Item extends Dropable{
	
	
	protected String name;

  
	
	public String getRaw(){
            return Printer.getStringColored("I", Color.PURPLE);
	}
        
        public abstract void use(Playable player);
        public void throwItem(Playable player){
            player.getBag().remove(this);
        }
	
	public String getName(){
		
		return this.name;
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
}
