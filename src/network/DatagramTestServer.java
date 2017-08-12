package network;

import java.net.*;

public class DatagramTestServer {
	public static int server_port = 998;
	public static int client_port = 899;
	public static int buffer_size = 1024;
	public static DatagramSocket ds;
	public static byte buffer[] = new byte[buffer_size];
	
	public static void server() throws Exception {
		int pos = 0;
		while(true){
			int c = System.in.read();
			switch(c){
			case '1' : System.out.println("Server quits");
					System.exit(0);
			case '\r': System.out.println("break");
						break;
			case '\n':
				ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(),client_port));
				pos = 0;
				break;
			default:
				buffer[pos++] = (byte) c;
			}
		}
	}

	public static void main(String args[]) throws Exception{
			ds = new DatagramSocket(server_port);
			server();
	}

}
