package concPro;

import java.util.concurrent.*;

public class SemaphoreDemo {
	
	public static void main(String args[]){
		Semaphore sm = new Semaphore(1);
		
		new inc(sm,"A");
		new dec(sm,"B");
	}

}
class SharedRes{
	static int a=0;
	static String th ="";
}

class inc extends Thread{
	String name;
	Semaphore sm;
	inc(Semaphore sm, String name){
		this.name = name;
		this.sm = sm;
		new Thread(this).start();
	}
	public void run(){
		try{
			sm.acquire();
			System.out.println("Resource locked");
			for(int i =0; i<5;i++){
				
				System.out.println("a: "+SharedRes.a++);
				Thread.sleep(100);
				
			}
			sm.release();
			SharedRes.th = this.name;
		}catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("Resource Released");
		
		System.out.println(SharedRes.th);
	}
}
class dec extends Thread{
	String name;
	Semaphore sm;
	dec(Semaphore sm, String name){
		this.name = name;
		this.sm = sm;
		new Thread(this).start();
	}
	public void run(){
		try{
			sm.acquire();
			for(int i =4;i>=0;i--){
				
				System.out.println("b: "+SharedRes.a--);
				Thread.sleep(50);
				
			}
			sm.release();
			SharedRes.th = this.name;
		}catch(InterruptedException e){
			System.out.println(e);
		}

		System.out.println(SharedRes.th);
	}
}