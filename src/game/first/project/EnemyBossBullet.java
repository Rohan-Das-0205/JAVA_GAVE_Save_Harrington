package game.first.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = (r.nextInt(5 - -5)+ -5);
		velY = 5;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(y >= Game.height)handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, Color.red, 16, 16, 0.02f,ID.Trail, handler));  		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	@Override
	public void render(Graphics g) {
	
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


}
