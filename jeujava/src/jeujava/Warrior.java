package jeujava;

public class Warrior extends Playable {
    
        
        @Override
        public void action(Playable player) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
   
	
	public Warrior(String name) {
		super(name);
		this.name = name;
                this.setAttack(20);
                this.setDefense(10);
                this.setHp(35);
                this.setHpMax(35);
                this.setLife(5);
                this.setMana(30);
                this.setManaMax(30);
	}
        
        @Override
        public void attackSpe(Individual enemy){
            this.setAttack(50);
            this.attack(enemy);
            this.hp = hpMax;
            this.setAttack(20);
        }
}
