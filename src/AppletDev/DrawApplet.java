package AppletDev;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
//import java.util.ArrayList;

public class DrawApplet extends Applet {
	public Choice li;
	public static final long serialVersionUID = 1;
	int[] x = new int[1000];
	int[] y = new int[1000];
	int i=0;
	//boolean start = false;
	boolean secondclick = false;
	//ArrayList<Integer> xl = new ArrayList<Integer>();
	//ArrayList<Integer> yl = new ArrayList<Integer>();
	public void init(){
		li = new Choice();
		li.add("red");
		li.add("black");
		li.add("blue");
		li.add("green");
		li.add("Pink");
		li.add("Magenta");
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		add(li);
		addMouseMotionListener(new MyMouse(this));
		addMouseListener(new MyMouseC(this));
		li.addItemListener(new Action(this));
	}
	public void colorpicker(){
		switch(li.getSelectedIndex()){
		case 0:
			setForeground(Color.RED);
			break;
		case 1:
			setForeground(Color.BLACK);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.GREEN);
			break;
		case 4:
			setForeground(Color.PINK);
			break;
		case 5:
			setForeground(Color.MAGENTA);
			break;
		default:
			setForeground(Color.WHITE);
		}
	}

	public void paint(Graphics g){
		colorpicker();
		if(secondclick){
		for(int j =1; j<i;j++){
			//g.drawLine(xl.get(j-1), yl.get(j-1), xl.get(j), yl.get(j));
			g.drawLine(x[j-1], y[j-1], x[j], y[j]);
			//System.out.println(x[j-1]+" "+y[j-1]);
			//System.out.println(x[j]+' '+y[j]);
		}
		}
		//System.out.println("called paint"+i);
	}

}
class MyMouse extends MouseMotionAdapter{
	DrawApplet drawapplet;
	public MyMouse(DrawApplet drawapplet){
		this.drawapplet = drawapplet;
	}
	public void mouseMoved(MouseEvent me){
		int i = drawapplet.i;
		if(i==1000){
			i=0;
		}
		
		drawapplet.x[i]=me.getX();
		drawapplet.y[i++]=me.getY();
		//drawapplet.xl.add(me.getX());
		//drawapplet.yl.add(me.getY());
		drawapplet.showStatus("Cursor at x: "+me.getX()+" y: "+me.getY());
		drawapplet.i = i;
		drawapplet.repaint();
	}
}

class Action implements ItemListener{
	DrawApplet drawapplet;
	public Action(DrawApplet drawapplet){
		this.drawapplet = drawapplet;
	}
	public void itemStateChanged(ItemEvent ie){
		drawapplet.repaint();
	}
}

class MyMouseC extends MouseAdapter{
	DrawApplet drawapplet;
	MyMouseC(DrawApplet drawapplet){
		this.drawapplet = drawapplet;
	}
	public void mouseClicked(MouseEvent me){
		if(!drawapplet.secondclick){
		drawapplet.i = 0;
		drawapplet.x = new int[1000];
		drawapplet.y = new int[1000];
		drawapplet.secondclick = true;
		//drawapplet.start = true;
		}
		else{
			drawapplet.secondclick = false;
			//drawapplet.start = false;
		}
	}
}