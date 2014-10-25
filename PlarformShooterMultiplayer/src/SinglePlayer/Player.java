package SinglePlayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	//player variables
	int health;
	Point location;
	
	//player physics
	float gravity, friction;
	boolean verticalCollision;
	boolean horizontalCollision;
	Rectangle rect;
	
	//player graphics
	ImageSheet images;
	Animation[] animations;
	
	
	public Player(Point p){
		
		//player variables
		this.location = p;
		
		//player physics
		gravity = 4.9f;
		friction = 0.5f;
		rect = new Rectangle(location.x, location.y, 20, 20);
		
		//player graphics
		
	}
	
	/////////////////////////////// THE GETTER/SETTER SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	
	
	
	
	/////////////////////////////// THE UPDATE SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void update(Input input){
		
		//physics
		rect.setLocation(location.x, location.y);
		//location.y += gravity;
	}
	
	
	
	
	
	
	/////////////////////////////// THE RENDER SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void render(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(location.getX(), location.getY(), 20, 20);
		
		g.setColor(Color.WHITE);
		g.drawRect(location.x, location.y, (int)rect.getWidth(), (int)rect.getHeight());
		
	}
	
	
	
	
	
	
	/////////////////////////////// THE PHYSICS FUNCTIONS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////// THE INPUT SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void makeItInput(Input input){
		
		
		
	}
	
	
}
