package AppletDev;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TextEdit extends Applet{
	public static final long serialVersionUID = 0;
	TextField name,password;
	public void init(){
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		Label lname = new Label("Name: ",Label.CENTER);
		Label lpass = new Label("Password: ",Label.RIGHT);
		name = new TextField(32);
		password = new TextField(32);
		add(lname,BorderLayout.WEST);
		add(name,BorderLayout.WEST);
		add(lpass, BorderLayout.EAST);
		add(password,BorderLayout.EAST);
		password.setEchoChar('*');
		name.addActionListener(new myAct(this));
		password.addActionListener(new myAct(this));
	}
	public void paint(Graphics g){
		g.drawString("name: "+name.getText(), 10, 100);
		g.drawString("Password: "+password.getText(), 10, 120);
		g.drawString("Selected Text: "+name.getSelectedText(), 10, 130);
	}

}

class myAct implements ActionListener{
	TextEdit textedit;
	myAct(TextEdit textedit){
		this.textedit = textedit;
	}
	public void actionPerformed(ActionEvent ae){
		textedit.repaint();
	}
}