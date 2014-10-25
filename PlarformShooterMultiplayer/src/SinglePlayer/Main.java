package SinglePlayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame implements Runnable, KeyListener, MouseMotionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private Image dbImage;
	private Graphics dbg;
	static int GWIDTH = 640, GHEIGHT = 640;
	private long period = 5*1000000;
	long beforeTime, afterTime, diff, sleepTime, overSleepTime = 0, delays = 0, FPS;
	public static final int DELAYS_BEFORE_YIELD = 10;
	public static Screen screen = null;
	Image img;
	
	Dimension screenSize = null;
	
	//input
	static Input input = null;
	static int mouseX, mouseY;


	public Main(){
		setSize(GWIDTH, GHEIGHT);
		setTitle("Platform Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setEnabled(true);
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		input = new Input();

		screen = new ArenaScreen();

	}

	@Override
	public void run() {
			while(true){
				beforeTime = System.nanoTime();
				
				gameUpdate();
				gameRender();
				paintScreen();
				
				afterTime = System.nanoTime();
				diff = afterTime - beforeTime;
				sleepTime = (period - diff) - overSleepTime;	
				if(sleepTime < period && sleepTime > 0){
					try {
						Thread.sleep(sleepTime / 1000000L);
						overSleepTime = 0;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(diff > period){
					overSleepTime = diff - period;
				} else if(++delays >= DELAYS_BEFORE_YIELD){
					Thread.yield();
					overSleepTime = 0;
				} else{
					overSleepTime = 0;
				}
			}
	}
	
	public void gameUpdate(){
			//update the game here
		this.screen.update(input);
		}
	
	public void gameRender(){
		if(dbImage == null){
			dbImage = createImage(GWIDTH, GHEIGHT);
			if(dbImage == null){
				System.err.println("dbImage cannot be created!");
				return;
			} else{
				dbg = dbImage.getGraphics();
			}
		}
		dbg.setColor(Color.BLUE);
		dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
		draw(dbg);
	}
	
	public void draw(Graphics g){

		this.screen.render(g);

	}
	
	public void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if(dbImage != null && g != null){
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		} catch (Exception e){
			System.err.println(e);
		}
	}

	
	
	public static void main(String[] args){
		Main t = new Main();
		
		Thread game = new Thread(t);
		game.start();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		input.set(arg0.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		input.set(arg0.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {	
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY  = arg0.getY();
	}
}
