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
