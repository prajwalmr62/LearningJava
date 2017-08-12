package newIO;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;

public class NIODemo {
	public static void main(String args[]){
		String name =  "D:/mypy";
		FileInputStream f2 = null;
		ByteBuffer mbuf;
		long fsize =0;
		File f = new File(name);
		Extension txt = new Extension("py");
		if(f.isDirectory()){
			System.out.println("Is a Directory");
			System.out.println("Searching for the files of extension "+txt.ext+" in "+ name);
			if(!(name.endsWith("/") || name.endsWith("\\"))){
				name+="/";
			}
			try{
				if(f.list(txt).length>0){
					System.out.println("Found file "+f.list(txt)[0]);
			f2 = new FileInputStream(name + f.list(txt)[0]);
			System.out.println("===="+f.list(txt)[0]+"====");
				}else{
					System.out.println("No "+txt.ext+" Files exist.");
					System.exit(0);
				}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}
		}else{
			try{
			f2 = new FileInputStream(name);
		} catch(FileNotFoundException e){
			System.out.println(e);
			}
		}
		FileChannel Fin = f2.getChannel();
		try{
		fsize = Fin.size();
		mbuf = ByteBuffer.allocate((int)fsize);
		Fin.read(mbuf);
		mbuf.rewind();
		for(int i =0; i<fsize; i++){
			System.out.print((char)mbuf.get());
			Fin.close();
			f2.close();
		}
		}catch(IOException e){
			System.out.println(e);
		}
		
	}
}

class Extension implements FilenameFilter{
	String ext;
	public Extension(String ext){
		this.ext = "."+ext;
	}
	public boolean accept(File dir, String name){
		return name.endsWith(ext);
	}
}
