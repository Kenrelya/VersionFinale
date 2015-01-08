package jeujava;

/**
 *
 * @author Kenrelya
 */
public class Exit extends CellContent{
    
    @Override
    public String getRaw() {
            return "E";
    }
    
    @Override
    public void interact(Playable player){
        player.getMap().UpLevel();
        map.setScore(map.getScore()+100*player.getMap().getLevel());
        player.getMap().initMap(player);
        player.getMap().showMap();
    }
    
}