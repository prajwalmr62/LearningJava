package AppletDev;

import java.applet.*;
import java.awt.*;
import java.net.URL;

public class Bases extends Applet{
	static final long serialVersionUID =0;
	URL codeurl,docurl;
	public void init(){
		codeurl = getCodeBase();
		docurl = getDocumentBase();
	}
	public void paint(Graphics g){
		g.drawString(codeurl.toString(), 10, 50);
		g.drawString(docurl.toString(), 10, 100);
	}

}
