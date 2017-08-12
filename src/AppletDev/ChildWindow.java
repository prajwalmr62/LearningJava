package AppletDev;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class ChildFrame extends Frame{
	final static long serialVersionUID = 10;
	ChildFrame(String str){
		super(str);
		WinAd adapter = new WinAd(this);
		addWindowListener(adapter);
	}
	public void paint(Graphics g){
		g.drawString("This is child window man.", 10, 100);
	}
	public void stop(){
		this.setVisible(false);
	}
}

class WinAd extends WindowAdapter{
	ChildFrame childFrame;
	public WinAd(ChildFrame childFrame){
		this.childFrame = childFrame;
	}
	public void windowclosing(WindowEvent we){
		childFrame.setVisible(false);
	}
}

public class ChildWindow extends Applet{
	final static long serialVersionUID = 10;
	Frame f;
	public void init(){
		f = new ChildFrame("Child Child Child");
		f.setSize(250, 250);
	}
	public void start(){
		f.setVisible(true);
	}
	public void paint(Graphics g){
		g.drawString("Main ", 10, 100);
	}
}
