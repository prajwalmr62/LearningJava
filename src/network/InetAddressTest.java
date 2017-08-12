package network;

import java.net.*;
import java.io.*;

public class InetAddressTest {
	public static void main(String args[]) throws Exception{
		InetAddress add = InetAddress.getLocalHost();
		int c;
		Socket s = new Socket("localhost",80);
		System.out.println(add);
		InputStream input = s.getInputStream();
		OutputStream output = s.getOutputStream();
		byte buf[] = "localhost/opencart".getBytes();
		output.write(buf);
		while ((c = input.read()) != -1){
			System.out.println((char) c);		
		}
		s.close();
	}

}
