package AppletDev;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ButtonDemo extends Applet implements ActionListener {
	public static final long serialVersionUID = 0;
	String str = "";
	Button one,two,three;
	Label l = new Label("label");
	int i=0,j=0,k=0;
	public void init(){
		one = new Button("1");
		two = new Button("2");
		three = new Button("3");
		add(one);
		add(two);
		add(three);
		add(l);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		
		switch(ae.getActionCommand()){
		case "1":
			j = k = 0;
			str = "Pressed one "+(++i)+" times";
			break;
		case "2":
			i = k = 0;
			str = "Pressed Two "+(++j)+" times";
			break;
		case "3":
			i = j = 0;
			str = "Pressed Three "+(++k)+" times";
			break;
		default:
			str = "Unknown button";
		}
		repaint();
	}
	public void paint(Graphics g){
		g.drawString(str, 10, 100);
	}

}
