package game.first.project;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static int Health = 100;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		Health = (int)Game.clamp((float)Health, (float)0, (float)200);
		
		greenValue = (int)Game.clamp((float)greenValue, (float)0, (float)255);
		greenValue = Health * 2;
		score++;
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)15, (int)15, (int)200, 32);
		
		g.setColor(new Color(75, greenValue,0));
		g.fillRect(15, 15, Health * 2, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: "+ score, 15, 64);
		g.drawString("Level: "+ level, 15, 80);
	}
	
	public void score (int score)
	{
		this.score = score;
	}
	public int getScore()
	{
		return score;
	}
	public void setLevel (int level)
	{
		this.level = level;
	}
	public int getLevel()
	{
		return level;
	}
}
