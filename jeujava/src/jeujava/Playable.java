package jeujava;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Playable extends Individual{
	private Weapon weapon;

    
        
    public Playable(String name){
            super(name);
            this.name = name;
            this.setLevel(1);
            this.setLife(5);
            this.position = new Location(3,3);
            
            
    }

    @Override
    public String getRaw() {
            return Printer.getStringColored("P", Color.GREEN);
    }

    public void respawn(){
        if(hp <= 0){
            map.initMap(this);
            this.resetHP();
        }
    }
    public void interact(CellContent content){
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void goLeft(){
        int currentX = this.position.getX();
        int nextX = this.position.getX()-1;
        int currentY = this.position.getY();

        move(currentX, currentY, nextX, currentY);
    }

    public void goRight(){
        int currentX = this.position.getX();
        int nextX = this.position.getX() +1;
        int currentY = this.position.getY();

        move(currentX, currentY, nextX, currentY);
    }

    public void goUp(){
        int currentX = this.position.getX();
        int nextY = this.position.getY() -1;
        int currentY = this.position.getY();

        move(currentX, currentY, currentX, nextY);
    }

    public void goDown(){
        int currentX = this.position.getX();
        int nextY = this.position.getY() +1;
        int currentY = this.position.getY();

        move(currentX, currentY, currentX, nextY);
    }

    public void setMap(Map map){
        this.map = map;
    }

    public Map getMap(){
        return this.map;
    }

    @Override
    public void action(Playable player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void move(int currentX, int currentY, int nextX, int nextY){
        CellContent nextCellContent = this.map.cell[nextX][nextY].getContent();
        
        if(nextCellContent instanceof Floor){
            if(currentY < 30 && currentY > 0){
                this.position.setY(nextY);
            }
            
            if(currentX < 100 && currentX > 0){
                this.position.setX(nextX);
            }

            CellContent floor = this.map.cell[nextX][nextY].getContent();
            this.map.cell[nextX][nextY].setContent(this);
            this.map.cell[currentX][currentY].setContent(floor);
        } else {
            nextCellContent.interact(this);
        }
    }
    
    public abstract void attackSpe(Individual enemy);
}
