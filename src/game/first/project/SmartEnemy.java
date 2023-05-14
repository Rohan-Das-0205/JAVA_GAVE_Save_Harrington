package game.first.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i=0; i<handler.object.size(); i++)
		{
			if(handler.object.get(i).getId()==ID.Player)
			{
				player = handler.object.get(i);
			}
		}
		
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		 
		x = Game.clamp(x, 0, Game.width - 48);
		y = Game.clamp(y, 0, Game.height -68);
		 
		 float diffX = x - player.getX() - 16;
		 float diffY = x - player.getY() - 16;
		 float distance= (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		 velX =   2* ((-1/distance) * diffX);
		 velY =   2* ((-1/distance) * diffY);
		 
		handler.addObject(new Trail(x, y, Color.GREEN, 16, 16, 0.02f,ID.Trail, handler));  		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	@Override
	public void render(Graphics g) {
	
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


}

