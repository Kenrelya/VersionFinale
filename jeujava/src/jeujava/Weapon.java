
package jeujava;

public class Weapon extends Item{
    
    private int damage;
    private int hands;
    private int durability;
    private int defense;
    
    
    
    public int getDamage(){
        return this.damage;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getHands(){
        return this.hands;
    }
    
    public void setHands(int hands){
        this.hands = hands;
    }
    
    public int getDurability(){
        return this.durability;
    }
    
    public void setDurability(int durability){
        this.durability = durability;
    }
    public int getDefense(){
        return this.defense;
    }
    
    public void setDefense(int defense){
        this.defense = defense;
    }
    
    @Override
    public void use(Playable player){
        
        player.attack += this.getDamage();
        player.defense += this.getDefense();
        player.getBag().remove(this);
        
    }
    
}
