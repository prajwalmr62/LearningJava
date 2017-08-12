package swingPro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawAppletSwing extends JApplet{
	public static final long serialVersionUID = 1;
	int[] x = new int[1000];
	int[] y = new int[1000];
	int i=0;
	boolean secondclick = false;
	
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					makeGUI();
				}
			});
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void makeGUI(){
		addMouseMotionListener(new MyMouse(this));
		addMouseListener(new MyMouseC(this));
		setVisible(true);
		add(new panel(this));
	}

}

class panel extends JPanel{
	public static final long serialVersionUID = 1;
	DrawAppletSwing d;
	panel(DrawAppletSwing d){
		this.d = d;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(d.secondclick){
			for(int j =1; j<d.i;j++){
				g.drawLine(d.x[j-1], d.y[j-1], d.x[j], d.y[j]);
			}
			}
	}
}

//Motion adapters classes from here.

class MyMouse extends MouseMotionAdapter{
	DrawAppletSwing drawapplet;
	public MyMouse(DrawAppletSwing drawapplet){
		this.drawapplet = drawapplet;
	}
	public void mouseMoved(MouseEvent me){
		int i = drawapplet.i;
		if(i==1000) i=0;
		drawapplet.x[i]=me.getX();
		drawapplet.y[i++]=me.getY();
		drawapplet.showStatus("Cursor at x: "+me.getX()+" y: "+me.getY());
		drawapplet.i = i;
		drawapplet.repaint();
	}
}

class Action implements ItemListener{
	DrawAppletSwing drawapplet;
	public Action(DrawAppletSwing drawapplet){
		this.drawapplet = drawapplet;
	}
	public void itemStateChanged(ItemEvent ie){
		drawapplet.repaint();
	}
}

class MyMouseC extends MouseAdapter{
	DrawAppletSwing drawapplet;
	MyMouseC(DrawAppletSwing drawapplet){
		this.drawapplet = drawapplet;
	}
	public void mouseClicked(MouseEvent me){
		if(!drawapplet.secondclick){
		drawapplet.i = 0;
		drawapplet.x = new int[1000];
		drawapplet.y = new int[1000];
		drawapplet.secondclick = true;
		}
		else{
			drawapplet.secondclick = false;
		}
	}
}