package game.first.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r =new Random();
	Handler handler;
	public Player(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
	}

	@Override
	public void tick() {		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.width - 48);
		y = Game.clamp(y, 0, Game.height -68);
		
		handler.addObject(new Trail(x, y, Color.white, 32, 32, 0.1f,ID.Trail, handler));
		
		collision();
	}
	private void collision() {
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId()==ID.BasicEnemy || tempObject.getId()==ID.FastEnemy || tempObject.getId()==ID.SmartEnemy || tempObject.getId()==ID.EnemyBoss || tempObject.getId()==ID.EnemyBossBullet)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//collision
					HUD.Health -= 2;
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	@Override	public void render(Graphics g) {
		

		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

}


