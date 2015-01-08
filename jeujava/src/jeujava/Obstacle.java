package jeujava;

abstract class Obstacle extends CellContent{
	boolean isOnground;
	boolean isSwimable;
	
	@Override
        public void interact(Playable player){
            System.out.println("I can't walk thought this");
        }
}