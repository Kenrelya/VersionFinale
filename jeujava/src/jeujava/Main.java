package jeujava;


import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		Map map = new Map();
		Playable player = createCharacter(map);
               // player.getBag().add(new Potion());
		Scanner sc = new Scanner(System.in);
		
                sc.nextLine();
		map.initMap(player); 
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		System.out.println("\t\t\t\t QUEST OF "+player.getName()+"™");
		while(player.life >0){ //BOUCLE QUI RAFRAICHIS LA MAP
  
                    System.out.println("\n");
                    
                    System.out.println("Level : "+map.getLevel());
                    System.out.println("Life : " +player.getLife());
                    System.out.println("Score : "+player.getMap().getScore());
                    map.showMap();
                    
                    System.out.println("Health : " +player.getHp()+ "/" +player.getHpMax());
                    System.out.println("Mana Hero :"+player.getMana()+"/"+player.getManaMax());
                    
                    
                    
                    String str = sc.next();
                    
                    if(str.equals("i")){
                        showInventory(player);
                    }
                    else if(str.equals("z")){
                        player.goUp();
                    }
                    else if(str.equals("d")){
                        player.goRight();
                    }
                    else if(str.equals("s")){
                        player.goDown();
                    }
                    else if(str.equals("q")){
                        player.goLeft();
                    }
                    else if(str.equals("f")){
                        useInventory(player);
                    }
                    else if(str.equals("x")){
                        map.initMap(player);
                        player.getBag().clear();
                    }
                    
                }
                
	}
        
	public static Playable createCharacter(Map map){
		
            Scanner sc = new Scanner (System.in);
            Playable player;
            String str;
            do {
                            System.out.println("Choose your hero between Warrior, Mage and Hunter : (type warrior mage or hunter)");
                            str = sc.next();
            }while(!str.equals("warrior") && !str.equals("mage") && !str.equals("hunter"));

            System.out.println("Choose your name character");
            String nameCharacter = sc.next();
            
            if(str.equals("warrior")){
                player = new Warrior(nameCharacter);
            }
            else if(str.equals("mage")){
                player = new Mage(nameCharacter);
            }
            else 
                player = new Hunter(nameCharacter);
            

            player.setMap(map);
            player.resetHP();

            System.out.println("Hello " +str+ " " +nameCharacter+" your quest is about to begin. \n\n"
                    + "z : go up \n"
                    + "d : go right \n"
                    + "s : go down \n"
                    + "q : go left\n "
                    + "x : reset level \n"
                    + "f : use inventory \n"
                    + "i : show inventory\n\n "
                    + "You have only one objectif.. Go as far as you can.. Good luck "+nameCharacter+" you will need it \n\n"
                    + "press enter to continue..." );
            return player;
	}

	public static void combat(Map map, Playable player, Individual enemy){
		String str;
		int count = 1; //attackspe can be only use once in a fight
		System.out.println("A fight is about to begin");
		do{
			do{
				Scanner sc = new Scanner(System.in);
                                System.out.println("HP Hero :"+player.getHp()+"/"+player.getHpMax());
                                System.out.println("Mana Hero :"+player.getMana()+"/"+player.getManaMax());
				System.out.println("Do you want to attack, defend youself (defense), use your attackspe or flee ?\n\n\n\n");
				str = sc.next();}while(!str.equals("attack") && !str.equals("defense") && !str.equals("flee")&& !str.equals("attackspe"));
		
                  
			if (str.equals("attack")) {
                            player.attack(enemy);
                            System.out.println("HP "+enemy.getName()+" "+enemy.getHp()+" /"+enemy.getHpMax());
                        }
                        else if (str.equals("defense")){
                           player.defense();
                           System.out.println("You defend youself");
                        }
                        else if (str.equals("attackspe") &&  count ==1 && player.getMana() >0){
                            
                            player.setMana(player.getMana()-10);
                            if(player.getMana()<0){
                                System.out.println("Not enough mana");
                            }
                            else{
                                player.attackSpe(enemy);
                                System.out.println("HP "+enemy.getName()+" "+enemy.getHp()+" /"+enemy.getHpMax());
                                count--;
                                map.setScore(map.getScore()-5);
                            }
                        }
                        else if(str.equals("attackspe") && player.getMana()<=0){
                            System.out.println("Not enough mana");
                        }
                        if (enemy.getHp() >0){
                                enemy.action(player);
                        }
		}while(enemy.getHp() > 0 && player.getHp() > 0 && !str.equals("flee"));
		
		if(enemy.hp <= 0){
			System.out.println("The fight is over, you win");
                        enemy.getCell().setContent(new Floor());
                        map.setScore(map.getScore()+30);
                       
                    
		}
		
		else if(player.getHp() <= 0){
                        player.setLife(player.getLife()-1);
                        if(player.getLife()==0){
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tGAME OVER");
                            System.out.println("\t\t\t\t\t\t\tTotal score : "+map.getScore()+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            
                        }
                        else{
                            System.out.println("You've lost this fight. You will respawn in a new map");
                            player.respawn();
                            player.getBag().clear();
                            
                        }
                        
		}
		
		else 
			System.out.println("Run coward");
                        
                        
                                
		
	}
        
        public static void showInventory(Playable player){
            int i =1;
            System.out.println("My bag contains : \n");
            for(Item elem: player.getBag()){
              System.out.println (i+"-"+elem.getName());
              i++;
            }
            
        }
        

        public static void useInventory(Playable player){
            
            Scanner sc = new Scanner(System.in);
            showInventory(player);
            System.out.println("Write the number of the item you want to use : ");
            
            
           try { 
                int index = sc.nextInt();  
                if(index <= player.getBag().size() && index>0){
                player.getBag().get(index-1).use(player);
            }
            else
                System.out.println("I can't do this");
                } 
            catch (Exception e) { 
                System.out.println("It's not a number"); 
                }
            
            
            
        }
}

