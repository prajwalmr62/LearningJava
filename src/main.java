/**
 * @author Prajwal
 *
 */

import javax.swing.*;

public class main {
	public static void main(String args[]) {
		try{
			SwingUtilities.invokeLater(new Runnable(){
			public void run(){
			new mainApplet();
			}
		});

	}catch (Exception e){
		System.out.println(e);
		}
	}
}

class mainApplet{
	public mainApplet(){
		JFrame jf = new JFrame();
		JLabel l = new JLabel("Main?");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(l);
		jf.setSize(240, 240);
		jf.setVisible(true);
	}
}
		
