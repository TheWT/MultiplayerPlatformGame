package SinglePlayer;


public class Input{
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int USE = 4;
	public static final int ESCAPE = 5;
	public static final int ONE = 6;
	public static final int TWO = 7;
	public static final int THREE = 8;
	public static final int FOUR = 9;
	public static final int FIVE = 10;
	public static final int SIX = 11;
	public static final int SEVEN = 12;
	public static final int EIGHT = 13;
	
	public boolean keys[];
	public boolean oldKeys[];
	

	public Input()
	{
		keys = new boolean[64];
		oldKeys = new boolean[64];
	}

	public void set(int key, boolean down)
	{
		int button = -1;
		if(key == 87)
			button = 0;
		if(key == 65)
			button = 2;
		if(key == 83)
			button = 1;
		if(key == 68)
			button = 3;
		if(key == 32)
			button = 4;
		if(key == 90)
			button = 5;
		if(key == 49)
			button = 6;
		if(key == 50)
			button = 7;
		if(key == 51)
			button = 8;
		if(key == 52)
			button = 9;
		if(key == 53)
			button = 10;
		if(key == 54)
			button = 11;
		if(key == 55)
			button = 12;
		if(key == 56)
			button = 13;
		if(button >= 0)
			keys[button] = down;
	}

	public void tick()
	{
		for(int i = 0; i < keys.length; i++)
			oldKeys[i] = keys[i];

	}

	public void releaseAllKeys()
	{
		for(int i = 0; i < keys.length; i++)
			keys[i] = false;

	}
}
