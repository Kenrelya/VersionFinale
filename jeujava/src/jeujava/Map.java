package jeujava;

import java.util.*;

public class Map {
	
	private int width;
	private int height;
	protected Cell cell[][];
	private int level = 1;
        private int score = 0;
	
	public Map(){
		this.width = 100;
		this.height = 30;
		this.cell = new Cell[this.width][this.height];
	}
	
	public int getWidth(){
		
		return this.width;
	}
	
	public void setWidth(int width){
		
		this.width = width;
	}
	
	public int getHeight(){
		
		return this.height;
	}
	
	public void setHeight(int height){
		
		this.height = height;
	}
	
	public Cell[][] getCell(){
		
		return this.cell;
	}
	
	public void setCell(Cell cell[][]){
		
		this.cell = cell;
	}
        
	public int getLevel(){
		
		return this.level;
	}
	
	public void setLevel(int level){
		
		this.level = level;
	}
        public int getScore(){
		
		return this.score;
	}
	
	public void setScore(int score){
		
		this.score = score;
	}
	
	public void UpLevel(){
		this.level++;
                
	}
	
	public void initMap(Playable player){
		Random rand = new Random();
                player.getLocation().setX(3);
                player.getLocation().setY(3);
                
                for(int j = 0; j<height; j++){
			for(int i = 0; i<width; i++){
				if(i == 0 || i == width-1){
                                        this.addCell(i, j, new Cell(new Wall(true)));
				}
				else if(j == 0 || j == height-1){
                                        this.addCell(i, j, new Cell(new Wall(false)));
				}
				else {
                                   int choice = rand.nextInt(1000);
                                   
                                    if(i == player.getLocation().getX() && j == player.getLocation().getY()){
                                        this.addCell(i, j, new Cell(player));
                                    }
                                    else if (choice<600-(this.getLevel()*10)) {
                                        this.addCell(i, j, new Cell(new Floor()));
                                    }
                                    else if(choice<855&&choice>=840){
                                        this.addCell(i, j, new Cell(new ManaPotion()));
                                    }
                                    else if(choice<840&&choice>=825){
                                        this.addCell(i, j, new Cell(new Potion()));
                                    }
                                    else if(choice<825&&choice>=815){
                                        this.addCell(i, j, new Cell(new Axe()));
                                    }
                                    else if(choice<815&&choice>=805){
                                        this.addCell(i, j, new Cell(new Shield()));
                                    }
                                    else if(choice<805&&choice>=800){
                                        this.addCell(i, j, new Cell(new Sword()));
                                    }
                                    else if(choice >=600&&choice<800){
                                        this.addCell(i, j, new Cell(new River()));
                                    }
                                    else 
                                        this.addCell(i, j, new Cell(new Enemy("Monster")));
				}
			}
		}
                
                cell[95][27] = new Cell(new Exit());
                
	}
	
	public void showMap(){

		for(int i = 0; i<height; i++){
			for(int j = 0; j<width; j++){
				System.out.print(cell[j][i].getContent().getRaw());
			}
			
			System.out.println();
		}
		
		
	}
        
        private void addCell(int x, int y, Cell cell){
            this.cell[x][y] = cell;
            cell.setPosition(new Location(x, y));
        }
	
}
