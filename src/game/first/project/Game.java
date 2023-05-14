package game.first.project;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1691441924519451365L;
	
	public static final int width = 1080, height = width/12 * 9;
	 private Thread thread;
	 private boolean running = false;
	 
	 public static boolean paused = false;
	 
	 private Handler handler;
	 private HUD hud;
	 private Random r;
	 private Spawn spawner;
	 private Menu menu;
	 
	 public enum STATE{
		Menu,
		Game,
		End
	 };
	
	 public static STATE gameState = STATE.Menu;
	 
	public Game() {
	
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this,handler,hud);
		this.addKeyListener(new KeyInput(handler,this));
		this.addMouseListener(menu);
		
		AudioPlayer.Load();
		if(gameState == STATE.Menu || gameState == STATE.End)
		{
			AudioPlayer.getMenuSong("menu_song").loop();
		}
				
		new Window(width,height,"SAVE STEVE HARRINGTON",this);

		spawner = new Spawn(handler, hud);
		r= new Random();

		if(gameState == STATE.Game) {
		
			handler.addObject(new Player(width/2 -32, height/2-32, ID.Player,handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.BasicEnemy, handler));
		}
		else {
			for(int i=0; i< 20; i++)
			{
				handler.addObject(new MenuParticle(r.nextInt(Game.width), r.nextInt(Game.height), ID.MenuParticle, handler));
			}
		}
		
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			 
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames=0;
			}
		}
		stop();
	}
	
	private void tick() {
		if(gameState == STATE.Game)
		{
			if(!paused)
			{
				
				handler.tick();
				hud.tick();
				spawner.tick();
				
				if(HUD.Health <=0)
				{
					HUD.Health = 100;
					gameState = STATE.End;
					handler.clearEnemies();
				}
			}
			
		}
		else if(gameState == STATE.Menu || gameState == STATE.End)
		{
			handler.tick();
			menu.tick();
			
		}
	}
	
	private void render() {
		BufferStrategy bs= this.getBufferStrategy();
		 if(bs==null)
		 {
			 this.createBufferStrategy(3);
			 return;
		 }
		 
		 Graphics g = bs.getDrawGraphics();
		  g.setColor(Color.black);
		  g.fillRect(0, 0, width, height);
		 
		  handler.render(g);
		  
		  if(gameState == STATE.Game)
		  {
			  
			if(paused)
		  	{
				g.setColor(Color.white);
				g.drawString("PAUSED", 100, 100);
		  	}
		  }
		  
		  if(gameState == STATE.Game) {
			  hud.render(g);
		  }
		  else if(gameState == STATE.Menu || gameState == STATE.End){
				menu.render(g);
			}
		  
		  g.dispose();
		  bs.show();
	}
	public static float clamp(float var , float min, float max)
	{
		if(var <= min)
			return var=min;
		else if( var >= max)
			return var=max;
		else return var;
	}
	public static void main(String[] args) {
		new Game();
	}

}
