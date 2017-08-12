package network;

import java.net.*;
import java.util.Date;
public class URLTest {
	public static void main(String args[]) throws Exception{
		URL mysite = new URL("http://localhost/opencart/image/no_image.png");
		URLConnection mycon = mysite.openConnection();
		System.out.println("===URL Info===");
		System.out.println("Protocol: "+mysite.getProtocol());
		System.out.println("Port: "+mysite.getPort());
		System.out.println("File Name: "+mysite.getFile());
		System.out.println("Contect info: "+mysite.getContent());
		System.out.println("Link: "+mysite.toExternalForm());
		System.out.println("===Remote File Info===");
		System.out.println("Read Timeout: "+mycon.getReadTimeout());
		System.out.println("Date: "+ new Date(mycon.getDate()));
		System.out.println("Content Type: "+mycon.getContentType());
		System.out.println("Content Expiration: "+new Date(mycon.getExpiration()));
	}

}
