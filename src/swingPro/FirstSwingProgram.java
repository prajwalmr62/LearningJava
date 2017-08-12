package swingPro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FirstSwingProgram {
	JFrame jf;
	FirstSwingProgram(){
		jf = new JFrame("First Program with (J)Label only");
		JLabel l = new JLabel("Prajwal");
		jf.setSize(350,350);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//JMenuBar 
		JMenuBar jb = new JMenuBar();
		JMenu File = new JMenu("file");
		File.setMnemonic(KeyEvent.VK_F);
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
		File.add(Exit);
		jb.add(File);
		jf.add(l);
		jf.add(jb,BorderLayout.NORTH);
	}
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FirstSwingProgram fsw = new FirstSwingProgram();
				try{
					System.out.println("Thread goes to sleep");
					Thread.sleep(25);
				}catch(InterruptedException e){
					System.out.println(e);
				}
				System.out.println("Frame is set to visible");
				fsw.jf.setVisible(true);
			}
		});
	}

}
