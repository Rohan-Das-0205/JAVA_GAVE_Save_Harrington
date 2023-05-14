package game.first.project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.first.project.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	Game game;
	public KeyInput(Handler handler,Game game)
	{
		this.handler = handler;
		this.game = game;
	}
		public void keyPressed(KeyEvent e)
		{
			int key =e.getKeyCode();
			
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.Player)
				{
					if(key == KeyEvent.VK_UP)tempObject.setVelY(-5);
					if(key == KeyEvent.VK_DOWN)tempObject.setVelY(5);
					if(key == KeyEvent.VK_LEFT)tempObject.setVelX(-5);
					if(key == KeyEvent.VK_RIGHT)tempObject.setVelX(5);
				}
			}
			
			if(key == KeyEvent.VK_P)
			{
				if(game.gameState == STATE.Game)
					{
						if(Game.paused)Game.paused = false;
						else
							Game.paused =  true;
					}
			}
			if(key == KeyEvent.VK_ESCAPE)System.exit(1);
		}
		public void keyReleased(KeyEvent e) 
		{
			int key =e.getKeyCode();
			
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.Player)
				{
					if(key == KeyEvent.VK_UP)tempObject.setVelY(0);
					if(key == KeyEvent.VK_DOWN)tempObject.setVelY(0);
					if(key == KeyEvent.VK_LEFT)tempObject.setVelX(0);
					if(key == KeyEvent.VK_RIGHT)tempObject.setVelX(0);
				}
			}
		}
}
