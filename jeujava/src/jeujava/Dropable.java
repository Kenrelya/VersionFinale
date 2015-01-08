package jeujava;

public abstract class Dropable extends CellContent {
	
        @Override
        public void interact(Playable player){
            if (this instanceof Item){ //On s'assure que content est bien un item 
                    player.getBag().add((Item)this); // cast safe
                    this.cell.setContent(new Floor());
            }
        }
}