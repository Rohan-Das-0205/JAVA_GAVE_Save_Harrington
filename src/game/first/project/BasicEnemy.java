package game.first.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = 5;
		velY = 5;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(y<=0 || y>= Game.height - 42) velY *= -1;
		if(x<=0 || x>= Game.width -32) velX *= -1;
		
		handler.addObject(new Trail(x, y, new Color(168,4,4), 16, 16, 0.02f,ID.Trail, handler));  		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	@Override
	public void render(Graphics g) {
	
		g.setColor(new Color(168,4,4));
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


}
