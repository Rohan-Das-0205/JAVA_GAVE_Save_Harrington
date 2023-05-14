package game.first.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	private Color col;
	int red[]={53,133,149,13,14,65,90,27,59,152};
	int green[]={19,27,34,16,42,22,46,42,48,122};
	int blue[]={19,33,29,67,107,64,46,57,47,107};
	
	public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - 3)+ 3);
		velY = (r.nextInt(5 - 3)+ 3);
		
		col = new Color(red[r.nextInt(9)], green[r.nextInt(9)], blue[r.nextInt(9)]);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(y<=0 || y>= Game.height - 42) velY *= -1;
		if(x<=0 || x>= Game.width -32) velX *= -1;
		
		handler.addObject(new Trail(x, y, col, 5, 5, 0.02f,ID.Trail, handler));  		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 1, 1);
	}
	@Override
	public void render(Graphics g) {
	
		g.setColor(col);
		g.fillRect((int)x/2, (int)y, 5, 5);
		
	}


}
