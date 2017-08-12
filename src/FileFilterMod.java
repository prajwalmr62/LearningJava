
import java.io.*;

public class FileFilterMod {
	public static void main(String args[]){
		String name = "D:/mypy";
		File f = new File(name);
		ExtensionFilter Extension = new ExtensionFilter("py");
		for(File S: f.listFiles(Extension)){
			System.out.println(S.getName());
		}
		System.out.println(f.getName());
	}
}

class ExtensionFilter implements FilenameFilter{
	String ext;
	public ExtensionFilter(String ext){
		this.ext = "."+ext;
	}
	public boolean accept(File dir, String name){
		return(name.endsWith(ext));
	}
}
