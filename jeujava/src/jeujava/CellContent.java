package jeujava;

import java.util.ArrayList;

public abstract class CellContent{
	
        protected ArrayList<Item> bag;
        protected Map map;
        protected Cell cell;
        

        
	public abstract String getRaw();
	
        public abstract void interact(Playable player);
        
        public Cell getCell(){
            return this.cell;
        }
        
        public void setCell(Cell cell){
            this.cell = cell;
        }
}