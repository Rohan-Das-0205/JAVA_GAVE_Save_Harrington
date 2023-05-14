package game.first.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import game.first.project.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		
	}
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu)
		{
		//PLAY
		if(mouseOver(mx , my, 440, 220, 200, 64))
		{
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.width/2 -32, Game.height/2-32, ID.Player,handler));
			handler.clearEnemies();
			handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
		}
		//QUIT
		if(mouseOver(mx , my, 440, 420, 200, 64))
			System.exit(1);
		}
		if(game.gameState == STATE.End)
		{
			if(mouseOver(mx, my, 300, 520, 160, 64))
			{
				game.gameState = STATE.Game;
				hud.score(0);
				hud.setLevel(1);
				handler.addObject(new Player(Game.width/2 -32, Game.height/2-32, ID.Player,handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
			
			}
			if(mouseOver(mx, my, 600, 520, 160, 64))
			{
				hud.score(0);
				hud.setLevel(1);
				game.gameState = STATE.Menu;
				for(int i=0; i< 20; i++)
				{
					handler.addObject(new MenuParticle(r.nextInt(Game.width), r.nextInt(Game.height), ID.MenuParticle, handler));
				}
			}
		}
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}else return false;
		}
		else return false;
			
	}
	public void tick() {
		
	}
	
	public void render(Graphics g)
	{
		
		if(game.gameState == STATE.Menu)
		{
			
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,35);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Save Steve", 400, 115);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(440, 220, 200, 64);
			g.drawString("Play", 500, 265);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(440, 320, 200, 64);
			g.drawString("Store", 500, 365);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(440, 420, 200, 64);
			g.drawString("Exit", 500, 465);
		}
		else if(game.gameState == STATE.End)
		{
			
			Font fnt = new Font("arial",1,60);
			Font fnt2 = new Font("arial",1,40);
			Font fnt3 = new Font("arial",1,25);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 340, 130);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Your Score: "+hud.getScore(), 335, 220);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("You Killed King Harrington", 270, 340);
			
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("Save Him Next Time!!", 320, 440);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawRect(300, 520, 160, 64);
			g.drawString("Try Again", 325, 560);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawRect(600, 520, 160, 64);
			g.drawString("Menu", 648, 560);
		}
	}

}
