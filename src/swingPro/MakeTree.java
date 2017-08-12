package swingPro;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;
class MakeTree{

public static DefaultMutableTreeNode maketree(String s){
	DefaultMutableTreeNode res;
	File f= new File(s);
	DefaultMutableTreeNode file;
		if(!f.isDirectory()){
		res = new DefaultMutableTreeNode(f.getName());
		}
	else{
		res = new DefaultMutableTreeNode(f.getName());
		for(File f2: f.listFiles()){
			if(f2.isDirectory()){
				file = maketree(f2.getPath());
				}
			else{
				file = new DefaultMutableTreeNode(f2.getName());
			}
			res.add(file);
		}
	}
	return(res);
	}
}
