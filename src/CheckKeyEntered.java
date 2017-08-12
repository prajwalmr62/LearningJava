
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CheckKeyEntered extends Applet{
	private static final long serialVersionUID = 1L;
	String status="";
	String keyName="";
	int keyCode = 0;
	keyListener k;
	public void start(){
		setSize(640,480);
		addKeyListener(new keyListener(this));
	}
	public void paint(Graphics g){
		showStatus(status);
		g.drawString(keyName, 10, 240);
		g.drawString(""+keyCode, 10,260);
	}
	
	class keyListener implements KeyListener{
		CheckKeyEntered cke;
		int sum = 0;
		public keyListener(CheckKeyEntered cke){
			this.cke = cke;
		}
		public void keyPressed(KeyEvent ke){
			cke.status = "Down";
			cke.keyCode = ke.getKeyCode();
			cke.repaint();
		}
		
		public void keyReleased(KeyEvent ke){
			cke.status = "up";
			//cke.keyName = "No Key Entered";
			cke.repaint();
		}
		
		public void keyTyped(KeyEvent ke){
			cke.status = "Type";
			if(cke.keyName.startsWith(ke.getKeyChar()+"")){
				sum++;
			}
			cke.keyName = ""+sum+ke.getKeyChar();
			cke.repaint();
		}
	}

}
