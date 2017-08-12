package network;

import java.net.*;

public class DatagramTest {
	//public static int server_port = 998;
	public static int client_port = 899;
	public static int buffer_size = 1024;
	public static DatagramSocket ds;
	public static byte buffer[] = new byte[buffer_size];
	

	public static void client() throws Exception {
		while(true){
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			System.out.println(new String(p.getData(),0,p.getLength()));
		}
	}
	public static void main(String args[]) throws Exception{
			ds = new DatagramSocket(client_port);
			client();
	}

}
