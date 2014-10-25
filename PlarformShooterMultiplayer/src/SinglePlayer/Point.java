package SinglePlayer;

public class Point {
	
	public int x, y;
	public double doubleX, doubleY;
	
	public Point(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public Point(double x, double y){
		
		this.doubleX = x;
		this.doubleY = y;
		
	}
	
	/////////////////////////////// THE GETTER/SETTER SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//int functions
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
	//double functions
	public double getDoubleX(){
		return doubleX;
	}
	
	public double getDoubleY(){
		return doubleY;
	}
	
	public void setDoubleX(double x){
		this.doubleX = x;
	}
	
	public void setDoubleY(double y){
		this.doubleY = y;
	}
	
	//
	
	
	
	/////////////////////////////// THE FUNCTIONS SECTION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//apply int to int
	public void applyPoint(Point a){
		
		int px = this.getX();
		int py = this.getY();
		
		int ax = a.getX();
		int ay = a.getY();
		
		ax += px;
		ay += py;
		
	}
	
	public void applyx(Point a){
		
		int ax = a.getX();
		this.x += ax;
		
	}
	
	
	public void applyy(Point a){
		
		int ay = a.getY();
		this.y += ay;
		
	}
	
	
	
}
