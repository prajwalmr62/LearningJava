import java.io.*;
public class IOFirst {
	public static void main(String args[]) throws IOException {
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Thread.currentThread();
		c =(char) br.read();
		while(c!='q' && c!='Q'){
			System.out.print(c);
			c =(char) br.read();
			try{
				Thread.sleep(50);
			} catch (InterruptedException e){
				System.out.println(e);
			}
		}
		
	}

}
