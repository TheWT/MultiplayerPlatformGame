package SinglePlayer;

import java.awt.Graphics;

public class ArenaScreen extends Screen{
	
	Player player = null;
	
	public ArenaScreen(){
		player = new Player(new Point(200, 200));
	}
	
	public void update(Input input){
		player.update(input);
	}
	
	public void render(Graphics g){
		player.render(g);
	}

}
