package jeujava;

public class Cell{
	
	private Location position;
	private CellContent content;
	
	public Cell(CellContent content){
		this.content = content;
                this.content.setCell(this);
	}
	
	public Location getPosition(){
		
		return this.position;
	}
	
	public void setPosition(Location position){
		
		this.position = position;
	}
	
	public CellContent getContent(){
		
		return this.content;
	}
	
	public void setContent(CellContent content){
		
		this.content = content;
	}
	
	

}