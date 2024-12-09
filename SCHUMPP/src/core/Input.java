package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int SPACE = 4;
	
	public static boolean[] keys = new boolean [5];
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[LEFT] = true;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = true;
		else if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = true;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = true;
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
			keys[4] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[LEFT] = false;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = false;
		else if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = false;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = false;
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
			keys[4] = false;	
	}
}
