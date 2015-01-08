package jeujava;

public class Mage extends Playable { 
            
            @Override
            public void action(Playable player) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        
	public Mage(String name) {
		super(name);
		this.name = name;
                this.setAttack(30);
                this.setDefense(5);
                this.setHp(30);
                this.setHpMax(30);
                this.setLife(5);
                this.setMana(50);
                this.setManaMax(50);
	}
        
        @Override
        public void attackSpe(Individual enemy){
            enemy.hp = 0;
        }

}