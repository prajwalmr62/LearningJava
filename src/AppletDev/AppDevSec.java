package AppletDev;

import java.applet.*;
import java.awt.*;

public class AppDevSec extends Applet implements Runnable {
	static final long serialVersionUID =0;
	String message = "This will be the message that will be typing in the window.";
	Thread t = null;
	int state;
	String typer = "";
	boolean StopFlag;
	public void init(){
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}
	public void start(){
		if(getParameter("message")!=null){
			message = getParameter("message");
		}
		t = new Thread(this);
		StopFlag = false;
		t.start();
	}
	public void run(){
		int len = message.length();
		for (int i =0;i<len;i++){
			try{
				repaint();
				Thread.sleep(250);
				typer += message.charAt(0);
				message = message.substring(1,message.length());
				//message +=typer;
				if(StopFlag){
					break;
				}
			} catch (InterruptedException e){
				System.out.println(e);
			}
		}
	}
	public void paint(Graphics g){
		g.drawString(typer,10,100);
		showStatus("This is the status!");
	}

}
