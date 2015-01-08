package jeujava;

import java.util.*;

public abstract class Individual extends CellContent{
	
	public Individual(String name) {
		//super();
		this.name = name;
                this.bag = new ArrayList();
                
		
		
	}
        
    abstract public void action(Playable player);
    
        @Override
    public String getRaw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void interact(Playable player){
        Main.combat(player.getMap(), player, this);
    }
    
	protected Map map = new Map();
        protected Item item;
        protected Location position;
	protected String name;
	protected int hp;
	protected int hpMax;
	protected int level;
	protected ArrayList <Item> bag;
	protected int attack;
	protected int defense;
	protected int life;
        protected int mana;
        protected int manamax;
	
	
	public String getName() {
		
		
		return this.name;
	}
	
	public int getHpMax(){
		return this.hpMax;
	}
	
	public void setHpMax(int hpMax){
		
		this.hpMax = hpMax;
	}
	
	public int getHp(){
		
		return this.hp;
	}
	
	public void setHp(int hp){
		
		this.hp = hp;
	}
	
	public int getLevel(){
		
		return this.level;
	}
	
	public void setLevel(int level){
		
		this.level = level;
	}
	
	public int getAttack(){
		
		return this.attack;
	}
	
	public void setAttack(int attack){
		
		this.attack = attack;
	}
	public int getDefense(){
		
		return this.defense;
	}
	
	public void setDefense(int defense){
		
		this.defense = defense;
	}
	public int getLife(){
		
		return this.life;
	}
	
	public void setLife(int life){
		
		this.life = life;
	}
	public ArrayList<Item> getBag(){
		
		return this.bag;
	}
	
	public void setBag(ArrayList<Item> bag){
		
		this.bag = bag;
	}
	
	public void attack(Individual ind){
		
            if(this.attack>ind.defense)
		ind.hp -= (this.attack - ind.defense);
            else
                ind.hp -= 3;
	}
	
	public void defense(){
		this.defense = defense+5;
	}
	
	public void resetHP(){
		this.hp = this.hpMax;
	}
	
	public Location getLocation(){
            return this.position;
        }
	
	public int getMana(){
		return this.mana;
	}
	
	public void setMana(int mana){
		
		this.mana = mana;
	}
        
        public int getManaMax(){
		return this.manamax;
	}
	
	public void setManaMax(int manamax){
		
		this.manamax = manamax;
	}
	
        public Item getItem(){
		
		return this.item;
	}
	
	public void setItem(Item item){
		
		this.item = item;
	}
	
	
	public void run(){}
	public void fly(){}
	public void swim(){}
	
	
	public void main(){
		
		
		
	}

    
	
	
}