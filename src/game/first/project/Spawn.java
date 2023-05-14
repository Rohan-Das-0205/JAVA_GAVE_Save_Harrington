package game.first.project;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scoreKeep=0;
	private Random r = new Random();
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 500)
			{
				scoreKeep = 0;
				hud.setLevel(hud.getLevel()+1);
				if(hud.getLevel() ==2)
					{
						handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
						handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
						handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));

					}
				else if(hud.getLevel() ==3) {
					handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() ==4)
					{
						handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
						handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
					}
				
				else if(hud.getLevel() ==5)
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
				
				else if(hud.getLevel() == 6)
					{
						handler.clearEnemies();
						handler.addObject(new EnemyBoss((Game.width/2)-48, -150, ID.EnemyBoss, handler));
						AudioPlayer.getBossMusic("boss_music").loop();
					}
				else if(hud.getLevel() == 15)
				{
					handler.clearEnemies();
					AudioPlayer.getMusic("music").loop();
					handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() == 16)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 17)
				{
					handler.clearEnemies();
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.SmartEnemy, handler));
				}
			}
	}
}
