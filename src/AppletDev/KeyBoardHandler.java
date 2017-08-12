package AppletDev;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class KeyBoardHandler extends Applet implements KeyListener{
	static final long serialVersionUID =0;
	String message = "";
	public void init(){
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent ke){
		showStatus("Down");
	}
	public void keyReleased(KeyEvent ke){
		showStatus("up");
	}
	public void keyTyped(KeyEvent ke){
		char ch =ke.getKeyChar();
		message+=ch;
		repaint();
	}
	public void paint(Graphics g){
		g.drawString(message, 10, 100);
	}

}
