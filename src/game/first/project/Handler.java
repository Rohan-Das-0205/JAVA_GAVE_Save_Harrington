package game.first.project;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList <GameObject> object = new LinkedList<>();
	
	public void tick() {
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	public void render(Graphics g)
	{
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	public void clearEnemies()
	{
		for(int i=0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() != ID.Player)
			{
				object.remove(tempObject);
				i--;
			}
		}
		if(Game.gameState == Game.STATE.End)
		{
			object.clear();
			AudioPlayer.getMenuSong("menu_song").loop();
		}
	}
	public void addObject(GameObject object)
	{
		this.object.add(object);
		if(object.id == ID.Player)
			AudioPlayer.getMusic("music").loop();
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
