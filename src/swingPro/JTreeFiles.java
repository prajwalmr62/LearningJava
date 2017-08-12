package swingPro;

import java.awt.BorderLayout;


//import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
//import javax.swing.tree.*;

public class JTreeFiles extends JApplet{
	public static final long serialVersionUID = 0;
	JTree tree;
	JLabel l;
	JTextField tf;
	String S;
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				makeGUI();
			}
		});
		} catch(Exception e){
			System.out.println(e);
		}
	}
	public void makeGUI(){
		tf = new JTextField(32);
		S="D:/myjava";
		tree = new JTree(MakeTree.maketree(S));
		JScrollPane jsp = new JScrollPane(tree);
		add(jsp);
		l = new JLabel("Select the file");
		add(l,BorderLayout.SOUTH);
		tree.addTreeSelectionListener(new TrSeLi(this));
		add(tf, BorderLayout.NORTH);
		tf.addActionListener(new Act(this));
	}
	
}

class TrSeLi implements TreeSelectionListener{
	JTreeFiles a;
	TrSeLi(JTreeFiles a){
	this.a = a;	
		}
		public void valueChanged(TreeSelectionEvent te){
			a.l.setText("Selection is "+te.getPath());
		}
}

class Act implements ActionListener{
	JTreeFiles a;
	Act(JTreeFiles a){
		this.a =a;
	}
	public void actionPerformed(ActionEvent ae){
		a.S =a.tf.getText();
		a.showStatus(a.S);
		a.repaint();
	}
}