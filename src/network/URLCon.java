package network;

import java.io.*;
import java.net.*;
import java.util.*;

public class URLCon {
	public static void main(String args[]) throws Exception{
		URL site = new URL("http://localhost:80/opencart");
		URLConnection con = site.openConnection();
		PrintWriter pw = new PrintWriter(System.out, true);
		InputStream is = con.getInputStream();  
		pw.println(con.getContentType());
		con.connect();
		is = con.getInputStream();
		long size = con.getContentLengthLong();
		pw.println(size);
		RandomAccessFile fl = new RandomAccessFile("Page","rw");
		byte Buffer[]= new byte[1024];
		int read = is.read(Buffer);
		
		pw.println(fl);
	
		
	}

}
