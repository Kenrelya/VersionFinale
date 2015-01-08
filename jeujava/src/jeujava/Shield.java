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
public class Shield extends Weapon{
    
    public Shield(){
        this.setDamage(0);
        this.setDefense(30);
        this.setDurability(4);
        this.setHands(1);
        this.name = "shield";
    }
    
}
