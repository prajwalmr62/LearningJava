package swingPro;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddButton {
	JLabel l = new JLabel("You haven't selected a button yet");
	AddButton(){
		JFrame jf = new JFrame("Button Demo");
		JButton a = new JButton("A");
		JButton b = new JButton("B");
		JLabel la = new JLabel("Button demo Program");
		jf.setSize(350,350);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.addActionListener(new ActLis(this));
		b.addActionListener(new ActLis(this));
		jf.add(la,BorderLayout.NORTH);
		jf.add(l,BorderLayout.SOUTH);
		jf.add(a,BorderLayout.EAST);
		jf.add(b, BorderLayout.WEST);
		jf.setVisible(true);
	}
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new AddButton();
			}
		});
	}
}

class ActLis implements ActionListener{
	AddButton a;
	AddButtonApplet ap;
	boolean checkapplet = false;
	ActLis(AddButton a){
		this.a = a;
		
	}
	ActLis(AddButtonApplet a){
		this.ap = a;
		checkapplet = true;
	}
	public void actionPerformed(ActionEvent ae){
		switch(ae.getActionCommand()){
		case "A":
			if(checkapplet) ap.l.setText("You have Pressed : A");
			else a.l.setText("You have Pressed : A");
			break;
		case "B":
			if(checkapplet) ap.l.setText("You have Pressed : B");
			else a.l.setText("You have Pressed : B");
			break;
		default:
			if(checkapplet) ap.l.setText("unknown");
			else a.l.setText("Unknown");
		}
	}
}