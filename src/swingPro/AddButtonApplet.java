package swingPro;

import java.awt.*;
import javax.swing.*;

public class AddButtonApplet extends JApplet {
	static final long serialVersionUID = 0;
	JLabel l = new JLabel("This text haven't you modified yet");
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
		setSize(200,100);
		JButton a = new JButton("A");
		JButton b = new JButton("B");
		JLabel la = new JLabel("Applet version!");
		setLayout(new FlowLayout());
		a.addActionListener(new ActLis(this));
		b.addActionListener(new ActLis(this));
		add(la);
		add(a);
		add(b);
		add(l);
		setVisible(true);
	}

}
