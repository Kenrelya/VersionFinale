package jeujava;
import java.util.*;

public class Enemy extends Individual{

	public Enemy(String name) {
		super(name);
                this.setHp(100);
                this.setHpMax(100);
		this.setAttack(10);
		this.setDefense(10);
		// TODO Auto-generated constructor stub
	}

        @Override
	public void action(Playable player){
		Random rand = new Random();
		int choice = rand.nextInt(10);
		
		if(choice < 7){
			this.attack(player);
			System.out.println(this.name+ " attacks");
		} else {
			this.defense();
			System.out.println(this.name+ " defends himself");
		}
		
	}
        
        @Override
        public String getRaw() {
            return Printer.getStringColored("M", Color.RED);
	}
}