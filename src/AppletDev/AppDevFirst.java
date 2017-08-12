package AppletDev;

import java.awt.*;
import java.applet.*;

public class AppDevFirst extends Applet{
	String message;
	static final long serialVersionUID =0;
	public void init(){
		setBackground(Color.black);
		setForeground(Color.blue);
		message = "1. init--";
	}
	public void start(){
		message +="\n 2. start --";
		
	}
	public void paint(Graphics g){
		message += "\n 3. paint --";
		g.drawString(message,10,100);

	}
	public void destroy(){
		System.out.println("Destroyed");
		
	}
	public void stop(){
		
	}

}
