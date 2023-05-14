package game.first.project;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	//public static Map<String , Sound> soundMap = new HashMap<>();
	public static Map<String , Music> musicMap = new HashMap<>();
	
	public static void Load() {
		
		try {
			musicMap.put("menu_song", new Music("res/stranger-things-theme-song.ogg"));
			
			musicMap.put("boss_music", new Music("res/02__Master_Of_Puppets.ogg"));
			
			musicMap.put("music", new Music("res/AV-0-Running-Up-That-Hill-_Italo-Synthwave-Remix_-FEAT-Supernova-Collective.ogg"));
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
	}
	public static Music getMusic(String key)
	{
		return musicMap.get(key);
	}
	
	public static Music getBossMusic(String key)
	{
		return musicMap.get(key);
	}
	
	public static Music getMenuSong(String key)
	{
		return musicMap.get(key);
	}

}
