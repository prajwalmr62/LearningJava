package AppletDev;

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class MouseEventHandler extends Applet implements MouseListener, MouseMotionListener{
	String message = "";
	int x =0, y=0;
	static final long serialVersionUID =0;
	
	public void init(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void mouseClicked(MouseEvent me){
		x=me.getX();
		y=me.getY();
		message = "Clicked";
		repaint();
	}
	public void mouseEntered(MouseEvent me){
		x= me.getX();
		y = me.getY();
		message = "Entered";
		repaint();
	}
	public void mouseExited(MouseEvent me){
		x= me.getX();
		y = me.getY();
		message = "Exited";
		repaint();
	}
	public void mousePressed(MouseEvent me){
		x = me.getX();
		y = me.getY();
		message = "Pressed";
		repaint();
	}
	public void mouseReleased(MouseEvent me){
		x = me.getX();
		y = me.getY();
		message = "Released";
		repaint();
	}
	public void mouseDragged(MouseEvent me){
		x= me.getX();
		y = me.getY();
		message = "*";
		showStatus("x: "+x+" y: "+y);
		repaint();
	}
	public void mouseMoved(MouseEvent me){
		x= me.getX();
		y = me.getY();
		showStatus("Cursor at x: "+x+" y: "+y);
		repaint();
	}
	public void paint(Graphics g){
		g.drawString(message, x, y);
	}
}
